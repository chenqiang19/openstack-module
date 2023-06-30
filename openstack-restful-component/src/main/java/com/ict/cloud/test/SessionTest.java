package com.ict.cloud.test;

import com.ict.cloud.common.exception.OperationException;
import com.ict.cloud.nova.model.Hypervisor;
import com.ict.cloud.session.OpenStackSession;
import com.ict.cloud.nova.Nova;

import java.util.List;

public class SessionTest {
	public static void main(String[] args) throws OperationException {
		OpenStackSession session = OpenStackSession.getSession("admin", "admin", "ADMIN_PASS");
		Nova nova = session.getNovaClient();
		List<Hypervisor> listHypervisor = nova.hypervisors.list();
	}
}
