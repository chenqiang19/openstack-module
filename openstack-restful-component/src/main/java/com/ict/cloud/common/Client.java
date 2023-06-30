package com.ict.cloud.common;

import com.ict.cloud.authentication.Authenticated;

public abstract class Client {
    protected Authenticated credentical;
    public Client(Authenticated credentical) {
        this.credentical = credentical;
    }
    public Authenticated getCredentical () {
        return credentical;
    }
}