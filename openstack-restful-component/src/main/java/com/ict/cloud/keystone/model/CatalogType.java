package com.ict.cloud.keystone.model;

public enum CatalogType {
    metering,compute,
    image,alarming,workflowv2,
    volumev3,placement,
    metric,volumev2,
    network,identity,
    object_store, baremetal,
    cloudformation,orchestration,
    baremetal_introspection,compute_legacy,
    application_catalog, container,
    murano,gnocchi,rca,container_infra,
    zun,heat_cfn,nfv_orchestration,
    ironic,heat,cyborg,
    nova_legacy,cinderv2,
    cinderv3,logging,application_deployment,
    rating,reservation,
    share,load_balancer,
    clustering,infra_optim,
    monitoring,backup,data_processing,
    database,instance_ha,
    sharev2,dns,image_builder,
    key_manager,event;
    //not add swift object-store
    public static CatalogType of(String type) {
        return CatalogType.valueOf(type);
    }
}