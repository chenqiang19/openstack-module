package com.ict.cloud.resource.mapper;

import com.ict.cloud.resource.domain.OpenstackVolumes;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OpenstackVolumesMapper {
    @Insert({
            "<script>",
            "insert into openstack_volume",
            "(user_id, volume_id, status, migration_status, volume_name, volume_type, replication_status, size,",
            "provider_id,volume_type_id, create_at, update_at, description, encrypted, availability_zone,",
            "snapshot_id, consumes_quota, group_id, service_uuid, bootable, shared_targets, server_id, attachment_id, device)",
            " values ",
            "<foreach collection = 'list' item = 'item' separator = ','>",
            "(#{item.userId}, #{item.volumeId},#{item.status},#{item.migrationStatus}, #{item.volumeName},#{item.volumeType},#{item.replicationStatus},#{item.size},",
            "#{item.providerId}, #{item.volumeTypeId},#{item.createAt},#{item.updateAt}, #{item.description},#{item.encrypted},#{item.availableZone},#{item.snapShotId},",
            "#{item.consumesQuota},#{item.groupId},#{item.serviceUUID}, #{item.bootable},#{item.sharedTargets},#{item.serverId},#{item.attachmentId}, #{item.device})",
            "</foreach>",
            "</script>"
    })
    void batchInsertVolumes(@Param("openstackVolumes") List<OpenstackVolumes> openstackVolumes);
}
