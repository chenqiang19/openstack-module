package com.ict.cloud.baremetal;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.baremetal.api.NodesManager;
import com.ict.cloud.baremetal.api.v1.Nodes;
import com.ict.cloud.common.Client;

public class BareMetal extends Client {
    public final NodesManager nodes;
    public BareMetal(Authenticated credentical) {
        super(credentical);
        nodes = new Nodes(credentical);
    }
}
