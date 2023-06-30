package com.ict.cloud.wapper.mapper;

import com.ict.cloud.wapper.entity.SecurityGroupRuleDO;
import com.ict.cloud.wapper.entity.SecurityGroupRuleTemplateDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SecurityGroupRuleTemplateMapper {
    @Select({
            "select id as templateId,",
            "name as name,",
            "context as context,",
            "description as description,",
            "status as status ",
            "from openstack_security_group_rule_template"
    })
    List<SecurityGroupRuleTemplateDO> listSecurityGroupRuleTemplate();

    @Select({
            "select id as templateId,",
            "name as name,",
            "context as context,",
            "description as description,",
            "status as status ",
            "from openstack_security_group_rule_template ",
            "where name=#{name}"
    })
    SecurityGroupRuleTemplateDO getSecurityGroupTemplateByName(String name);
}
