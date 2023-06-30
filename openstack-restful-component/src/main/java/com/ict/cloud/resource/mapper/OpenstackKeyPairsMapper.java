package com.ict.cloud.resource.mapper;

import com.ict.cloud.resource.domain.OpenstackKeyPairs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;

@Mapper
public interface OpenstackKeyPairsMapper {

    @Insert({
            "insert into openstack_keypairs",
            "(keypair_name, keypair_public_key, keypair_fingerprint, keypair_user_id, keypair_private_key, keypair_type, tenant_id, extend)",
            " values ",
            "(#{keypairName}, #{keypairPublicKey},#{keypairFingerprint},#{keypairUserId}, #{keypairPrivateKey},#{keypairType},#{tenantId},#{extend})"
    })
    int insert(OpenstackKeyPairs openstackKeyPairs);

    @Select({
            "<script>",
            "select ",
            "keypair_name as keypairName,",
            "keypair_public_key as keypairPublicKey,",
            "keypair_fingerprint as keypairFingerprint,",
            "keypair_user_id as keypairUserId,",
            "keypair_private_key as keypairPrivateKey,",
            "keypair_type as keypairType,",
            "tenant_id as tenantId,",
            "extend as extend,",
            "<where>",
            "1=1",
            "<if test=\"tenantId != null\"> and tenant_id=#{tenantId}</if>",
            "<if test=\"keyPairName != null and keyPairName != ''\"> and keypair_name=#{keyPairName}</if>",
            "</where>",
            "</script>"
    })
    List<OpenstackKeyPairs> getKeyPairsByTenantId(@Param("tenantId") Integer tenantId,
                                                  @Param("keyPairName") String keyPairName);
}
