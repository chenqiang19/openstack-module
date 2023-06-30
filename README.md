## Openstack Module

### 一、模块介绍

openstack-module是基于Java的Spring Boot架构，对openstack api进行二次开发的一个子模块。可以作为云管理平台中的一个子模块，负责对云管理平台的资源进行管理和操作等。其中包括了下面的子模块:
- keystone
- baremetal
- cinder
- glance
- neutron
- nova

### 二、模块结构

本模块包含了三个子模块openstack-restful-api、openstack-restful-component、openstack-restful-service。其中，openstack-restful-api对外提供RESTful规范的API接口，
openstack-restful-component模块提供了通过http request对openstack中的各个组件进行url拼接和服务调用和Model转化，openstack-restful-service中实现了各个openstack
中组件的controller控制路由转换。

### 三、模块技术架构

- SpringBoot
- Java
- Mybatis
- Maven
- RocketMQ
- Dubbo

### 四、项目组织

```
├─openstack-restful-api
│  └─src
│      └─main
│          └─java
│              └─com
│                  └─ict
│                      └─cloud
│                          ├─model
│                          ├─result
│                          ├─rpc
│                          └─vo
├─openstack-restful-component
│  └─src
│      └─main
│          ├─java
│          │  └─com
│          │      └─ict
│          │          └─cloud
│          │              ├─authentication
│          │              ├─baremetal
│          │              │  ├─api
│          │              │  │  └─v1
│          │              │  └─model
│          │              ├─cinder
│          │              │  ├─api
│          │              │  │  └─v3
│          │              │  └─model
│          │              ├─common
│          │              │  ├─analzye
│          │              │  ├─annotation
│          │              │  ├─Bean
│          │              │  ├─cache
│          │              │  ├─conf
│          │              │  ├─constants
│          │              │  ├─exception
│          │              │  ├─helper
│          │              │  ├─model
│          │              │  └─request
│          │              ├─configure
│          │              ├─image
│          │              │  ├─api
│          │              │  │  └─v2
│          │              │  └─model
│          │              ├─keystone
│          │              │  ├─api
│          │              │  └─model
│          │              ├─neutron
│          │              │  ├─api
│          │              │  │  └─v2
│          │              │  └─model
│          │              ├─nova
│          │              │  ├─api
│          │              │  │  └─v2
│          │              │  └─model
│          │              ├─plugin
│          │              │  └─influxdb
│          │              │      └─model
│          │              ├─resource
│          │              │  ├─domain
│          │              │  ├─mapper
│          │              │  └─service
│          │              │      └─impl
│          │              ├─session
│          │              ├─test
│          │              ├─tools
│          │              └─wapper
│          │                  ├─Configure
│          │                  ├─entity
│          │                  ├─Impl
│          │                  ├─mapper
│          │                  └─rpcImpl
│          └─resources
│              └─mybatis
└─openstack-restful-service
    └─src
        └─main
            ├─java
            │  └─com
            │      └─ict
            │          └─cloud
            │              ├─block-storage
            │              │  └─controller
            │              ├─compute
            │              │  └─controller
            │              ├─config
            │              ├─identity
            │              │  └─controller
            │              ├─image
            │              │  └─controller
            │              ├─load-balance
            │              │  └─controller
            │              └─network
            │                  └─controller
            └─resources
```
**说明：本项目不能单独打包，单独作为一个子项目使用。**

[参考项目](https://github.com/int32bit/openstack-java-sdk)
