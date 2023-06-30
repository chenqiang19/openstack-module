package com.ict.cloud.keystone.api;

import java.util.List;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.keystone.model.Service;
import com.ict.cloud.common.exception.OperationException;

public class Services extends AbstractManager<Service> implements ServiceManager {
    private static final String PREFIX = "/OS-KSADM/services";
    public Services(Authenticated credentical) {
        super(credentical, Service.class);
    }

    @Override
    public List<Service> list() throws OperationException {
        return super._list(PREFIX);
    }

    @Override
    public Service get(String id) throws OperationException {
        return super._get(PREFIX + "/" + id);
    }

    @Override
    public Service create(String name, String type, String description)
            throws OperationException {
        Service service = new Service();
        service.setName(name);
        service.setType(type);
        service.setDescription(description);
        return create(service);
    }
    @Override
    public Service create(Service service) throws OperationException {
        return super._create(PREFIX, service);
    }

    @Override
    public void delete(String id) throws OperationException {
        /** FIXME 删除成功也会抛出异常 **/
        try {
            super._delete(PREFIX + "/" + id);
        } catch (Exception ignore) {

        }
    }

}
