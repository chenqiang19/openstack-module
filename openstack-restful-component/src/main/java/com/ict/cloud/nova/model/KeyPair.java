package com.ict.cloud.nova.model;

import com.ict.cloud.common.annotation.Entity;
import com.ict.cloud.common.annotation.Property;
import com.ict.cloud.common.model.AbstractEntity;
import org.json.JSONObject;

@Entity
public class KeyPair extends AbstractEntity {
	private static final long serialVersionUID = -5328121718576284239L;
	@Property("public_key")
	private String publicKey;
	@Property("fingerprint")
	private String fingerPrint;
	@Property("private_key")
	private String privateKey;
	@Property("user_id")
	private String userId;
	@Property("type")
	private String type;
	public KeyPair() {
		super();
	}

	public KeyPair(JSONObject keypair) {
		super(keypair);
	}

	public KeyPair(Object obj) {
		this(new JSONObject(obj.toString()));
	}
	public KeyPair(String s) {
		this(new JSONObject(s));
	}
	public String getPublicKey() {
		return publicKey;
	}

	public String getFingerPrint() {
		return fingerPrint;
	}
	
	public String getPrivateKey() {
		return privateKey;
	}

	public String getUserId() {
		return userId;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getType() { return this.type; }
	public void setType(String type) { this.type = type; }

	@Override
	public boolean isValid() {
		return name != null;
	}
}
