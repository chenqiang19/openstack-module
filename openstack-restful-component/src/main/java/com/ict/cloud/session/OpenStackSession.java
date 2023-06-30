package com.ict.cloud.session;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.baremetal.BareMetal;
import com.ict.cloud.image.Image;
import com.ict.cloud.keystone.Keystone;
import com.ict.cloud.keystone.model.Secret;
import com.ict.cloud.cinder.Cinder;
import com.ict.cloud.neutron.Neutron;
import com.ict.cloud.nova.Nova;
import com.ict.cloud.common.exception.OperationException;

public class OpenStackSession{

    private Authenticated credentical;
    private Nova nova;
    private Keystone keystone;
    private Cinder cinder;
    private BareMetal bareMetal;
    private Neutron neutron;
    private Image image;

    public OpenStackSession(Authenticated credentical) {
        this.credentical = credentical;
        this.nova = new Nova(credentical);
        this.keystone = new Keystone(credentical);
        this.cinder = new Cinder(credentical);
        this.bareMetal = new BareMetal(credentical);
        this.neutron = new Neutron(credentical);
        this.image = new Image(credentical);
    }

    public Nova getNovaClient() { return this.nova; }
    public Keystone getKeystoneClient() {
        return this.keystone;
    }
    public Cinder getCinderClient() { return this.cinder; }
    public BareMetal getBareMetal() { return this. bareMetal; }
    public Authenticated getCredentical() {
        return this.credentical;
    }
    public Neutron getNeutron() { return this.neutron; }
    public Image getImage() { return this.image; }

    /**
     * 通过用户名和密码，获取指定tenant的session实例
     * @param tenantName tenant名，比如admin
     * @param username 用户名
     * @param password 密码
     * @return session实例
     * @throws OperationException
     */
    public static OpenStackSession getSession(String tenantName, String username, String password) throws OperationException  {
        Secret secret = new Secret();
        secret.setPassword(password);
        secret.setTenantName(tenantName);
        secret.setUsername(username);
        /** 必须保证secret合法 **/
        assert(secret.isValid());
        return new OpenStackSession(Keystone.authenticate(secret));
    }
}