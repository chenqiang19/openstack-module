package com.ict.cloud.nova.model;

import com.ict.cloud.common.annotation.Entity;
import com.ict.cloud.common.annotation.Property;
import com.ict.cloud.common.model.AbstractEntity;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Entity("server_group")
public class ServerGroup extends AbstractEntity {
    private static final long serialVersionUID = 6779486910984672120L;
    @Property
    private List<String> policies;
    @Property
    private String policy;
    @Property
    private JSONObject rules;
    @Property
    private List<String> members;
    @Property
    private JSONObject metadata;
    @Property
    private String userId;

    public ServerGroup() {
        super();
    }
    public ServerGroup(JSONObject object) {
        super(object);
    }
    public ServerGroup(Object obj) {
        this(new JSONObject(obj.toString()));
    }
    public ServerGroup(String s) {
        this(new JSONObject(s));
    }

    public ServerGroup(JSONObject header, JSONObject body) {
        JSONObject serverGroup = body.getJSONObject("server_group");
        this.id = serverGroup.getString("id");
        this.name = serverGroup.getString("name");
        this.policy = serverGroup.getString("policy");
        this.userId = serverGroup.getString("user_id");
        if (serverGroup.has("members")) {
            JSONArray jsonArray = serverGroup.getJSONArray("members");
            this.members = new ArrayList<>();
            for (int i=0; i<jsonArray.length(); ++i) {
                this.members.add(jsonArray.get(i).toString());
            }
        }
    }

    public List<String> getPolicies()  { return this.policies; }
    public void setPolicies(List<String> policies) { this.policies = policies; }

    public List<String> getMembers()  { return this.members; }
    public void setMembers(List<String> members) { this.members = members; }

    public String getUserId()  { return this.userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getPolicy()  { return this.policy; }
    public void setPolicy(String policy) { this.policy = policy; }

    public JSONObject getRules() { return this.rules; }
    public void setRules(JSONObject object) { this.rules = rules; }

    public JSONObject getMetadata() { return this.metadata; }
    public void setMetadata(JSONObject metadata) { this.metadata = metadata; }

    @Override
    public boolean isValid() {
        return false;
    }
}
