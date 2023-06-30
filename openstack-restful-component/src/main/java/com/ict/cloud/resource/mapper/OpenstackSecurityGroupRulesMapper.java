package com.ict.cloud.resource.mapper;

import com.ict.cloud.resource.domain.OpenstackSecurityGroupRules;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface OpenstackSecurityGroupRulesMapper {
    @Insert({
            "insert into openstack_security_group_rules",
            "(direction, protocol, ether_type, security_group_id, security_group_rule_id, description, tenant_id, port_range_min, port_range_max, action)",
            " values ",
            "(#{direction}, #{protocol},#{etherType},#{securityGroupId}, #{securityGroupRuleId},#{description},#{tenantId},#{portRangeMin},#{portRangeMax},#{action})"
    })
    int insert(OpenstackSecurityGroupRules openstackSecurityGroupRules);


    @Insert({
            "<script>",
            "insert into openstack_security_group_rules",
            "(direction, protocol, ether_type, security_group_id, security_group_rule_id, description, tenant_id, port_range_min, port_range_max, action)",
            " values ",
            "<foreach collection = 'list' item = 'securityGroupRule' separator = ','>",
            "(#{securityGroupRule.direction}, #{securityGroupRule.protocol},#{securityGroupRule.etherType},",
            "#{securityGroupRule.securityGroupId}, #{securityGroupRule.securityGroupRuleId},",
            "#{securityGroupRule.description},#{securityGroupRule.tenantId},#{securityGroupRule.portRangeMin},#{securityGroupRule.portRangeMax},#{securityGroupRule.action})",
            "</foreach>",
            "</script>"
    })
    int batchInsertSecurityGroupRules(List<OpenstackSecurityGroupRules> openstackSecurityGroupRulesList);

    @Select({
            "<script>",
            "select ",
            "direction as direction,",
            "protocol as protocol,",
            "ether_type as etherType,",
            "security_group_id as securityGroupId,",
            "security_group_rule_id as securityGroupRuleId,",
            "description as description,",
            "tenant_id as tenantId,",
            "port_range_min as portRangeMin,",
            "port_range_max as portRangeMax,",
            "action as action ",
            "from openstack_security_group_rules ",
            "<where>",
            "1=1",
            "<if test=\"tenantId != null\"> and tenant_id=#{tenantId}</if>",
            "<if test=\"securityGroupId != null and securityGroupId != ''\"> and security_group_id=#{securityGroupId}</if>",
            "</where>",
            "</script>"
    })
    List<OpenstackSecurityGroupRules> getSecurityGroupRules(@Param("tenantId") Integer tenantId,
                                                            @Param("securityGroupId") String securityGroupId);

    @Delete({
            "delete from openstack_security_group_rules where security_group_rule_id =#{securityGroupRuleId}"
    })
    void removeSecurityGroupRule(String securityGroupRuleId);
}
