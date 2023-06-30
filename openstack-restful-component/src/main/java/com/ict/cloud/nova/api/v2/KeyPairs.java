package com.ict.cloud.nova.api.v2;

import java.util.List;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.nova.model.KeyPair;
import com.ict.cloud.nova.api.KeyPairManager;

public class KeyPairs extends AbstractManager<KeyPair> implements KeyPairManager {

	public KeyPairs(Authenticated credentical) {
		super(credentical, KeyPair.class);
	}
	@Override
	public void delete(String name) throws OperationException {
		_delete("/os-keypairs/" + name);
	}

	@Override
	public KeyPair get(String name) throws OperationException {
		return _get("/os-keypair/" + name);
	}

	@Override
	public List<KeyPair> list() throws OperationException {
		return _list("/os-keypairs");
	}

	@Override
	public KeyPair create(String name, String type) throws OperationException {
		KeyPair keypair = new KeyPair();
		keypair.setName(name);
		keypair.setType(type);
		return _create("/os-keypairs", keypair);
	}

	@Override
	public KeyPair create(String name, String publicKey, String type)
			throws OperationException {
		KeyPair keypair = new KeyPair();
		keypair.setName(name);
		keypair.setType(type);
		keypair.setPublicKey(publicKey);
		return _create("/os-keypairs", keypair);
	}
}
