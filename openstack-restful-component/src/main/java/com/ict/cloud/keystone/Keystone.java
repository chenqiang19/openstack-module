package com.ict.cloud.keystone;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.keystone.api.*;
import com.ict.cloud.keystone.model.Secret;
import com.ict.cloud.common.Client;
import com.ict.cloud.common.exception.OperationException;

public class Keystone extends Client{
    public final UserManager users;
    public final RoleManager roles;
    public final TokenManager tokens;
    public final ServiceManager services;
    public final TenantManager tenants;
    public final EndpointManager endpoints;
    public final ProjectManager projects;
    public Keystone(Authenticated credentical) {
        super(credentical);
        this.users = new Users(credentical);
        this.roles = new Roles(credentical);
        this.tokens = new Tokens(credentical);
        this.services = new Services(credentical);
        this.tenants = new Tenants(credentical);
        this.endpoints = new Endpoints(credentical);
        this.projects = new Projects(credentical);
    }
    public static Authenticated authenticate(Secret secret) throws OperationException {
        TokenManager authenticator = new Tokens();
        return authenticator.authenticate(secret);
    }
    public TokenManager getTokens(){ return this.tokens; }
}
