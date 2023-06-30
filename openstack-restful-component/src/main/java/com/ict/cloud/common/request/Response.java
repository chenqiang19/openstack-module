package com.ict.cloud.common.request;

import java.io.InputStream;

public interface Response {
	String getBody();
	byte[] getBytes();
	InputStream getInputStream();
	int getCode();
	String getHeader();
	boolean isSuccess();
}