package com.ict.cloud.common.request;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Objects;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.*;
import org.apache.http.entity.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

public class HTTPRequest extends AbstractHTTPRequest implements AutoCloseable {
	private static long requestTimes = 0;
	private CloseableHttpClient proxy;
	private static Logger logger = LogManager.getFormatterLogger(HTTPRequest.class);
	public HTTPRequest() {
		proxy = HttpClients.createDefault();
	}
	@Override
	public void close() throws Exception {
		destroy();
		proxy.close();
	}
	public static long getRequestTimes() {
		return requestTimes;
	}
	
	public Response request(HttpUriRequest httpRequest) throws IOException {
		setHeader(httpRequest);
		CloseableHttpResponse resp = proxy.execute(httpRequest);
		Response response = processResponse(resp);
		resp.close();
		return response;
	}
	public Response request(HttpUriRequest httpRequest, Object data)
			throws IOException {
		setHeader(httpRequest);
		if (httpRequest instanceof HttpEntityEnclosingRequest) {
			HttpEntity entity = null;
			if (data != null) {
				if (data instanceof File) {
					entity = new FileEntity((File) data);
				} else if(data instanceof byte[]) {
					entity = new ByteArrayEntity((byte[])data);
				} else if(data instanceof InputStream) {
					entity = new InputStreamEntity((InputStream)data);
				} else {
					ContentType contentType = ContentType.create("application/json", Charset.defaultCharset());
					entity = new StringEntity(data.toString(), contentType);
				}
			}
			((HttpEntityEnclosingRequest) httpRequest).setEntity(entity);
		}
		CloseableHttpResponse resp = proxy.execute(httpRequest);
		Response response = processResponse(resp);
		resp.close();
		return response;
	}

	public void clean() {
		clearHeader();
	}
	private void setHeader(HttpRequest request) {
		for (String key : getHeader().keySet()) {
			request.setHeader(key, getHeader().get(key).toString());
		}
	}
	private boolean canProcess(HttpResponse response) {
		HttpEntity entity = response.getEntity();
		Objects.requireNonNull(entity);
		try{
			if(entity.getContentType()!=null){
				String contentType = entity.getContentType().getValue();
				if (contentType.indexOf("application/octet-stream") >= 0) {
					return false;
				}
				return true;
			}else{
				return false;
			}
		}catch (Exception e){
			return false;
		}
	}
	private Response processResponse(HttpResponse res) {
		HTTPResponse response = new HTTPResponse();
		HttpEntity entity = res.getEntity();

		/* 有些请求直接把内容放到头部，比如glance */
		if (entity == null) {
			JSONObject json = new JSONObject();
			for (org.apache.http.Header header : res.getAllHeaders()) {
				json.put(header.getName(), header.getValue());
			}
			response.setHeader(json.toString());
			StatusLine status = res.getStatusLine();
			response.setCode(status.getStatusCode());
			response.setStatus(status.getReasonPhrase());
			return response;
		}
		JSONObject json = new JSONObject();
		for (org.apache.http.Header header : res.getAllHeaders()) {
			json.put(header.getName(), header.getValue());
		}
		response.setHeader(json.toString());
		StatusLine status = res.getStatusLine();
		response.setCode(status.getStatusCode());
		response.setStatus(status.getReasonPhrase());
		if (!canProcess(res)) {
			try {
				response.setInputStream(entity.getContent());
			} catch(Exception e) {
				e.printStackTrace();
			}
			return response;
		}

		try {
			response.setBody(EntityUtils.toString(entity));
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				EntityUtils.consume(entity);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return response;
	}

	@Override
	protected Response get(String url) throws IOException {
		return request(new HttpGet(url));
	}
	protected Response post(String url) throws IOException {
		return request(new HttpHead(url));
	}

	@Override
	protected Response delete(String url) throws IOException {
		return request(new HttpDelete(url));
	}
	@Override
	protected Response post(String url, Object data) throws IOException {
		return request(new HttpPost(url), data);
	}


	@Override
	public Response put(String url, Object data) throws IOException {
		return request(new HttpPut(url), data);
	}
	@Override
	public Response head(String url) throws IOException {
		return request(new HttpHead(url));
	}

	@Override
	protected Response patch(String url, Object data) throws IOException {
		return request(new HttpPatch(url), data);
	}
}
