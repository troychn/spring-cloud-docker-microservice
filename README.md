# Spring Cloud与Docker微服务实战笔记

* 本Repo是Spring Cloud与Docker微服务实战笔记的配套代码
* 包含X个DEMO
* 覆盖的spring cloud的组件有有Eureka，Feign,zuul,bus,config,sidecar等



## 交流

* 个人博客：[http://www.troylc.cc](http://www.troylc.cc)


## 项目结构：
### spring-cloud-docker-microservice  (父级项目)  
- microservice-eureka-service (eureka服务注册中心)  
子项目为服务注册中心，考虑到高可用，通过docker-compose编排部署3个实例在docker swarm容器集群环境
- microservice-provider-userService(用户服务注册)  
子项目为用户服务，加入了spring boot中的监控管理的actuator，API接口文档模块swagger2,eurekaDiscoveryClient用户将服务注册到eureka注册中心  
- microservice-consumer-productservice（商品服务消费用户服务）
子项目为商品服务，加入了FeignClient、Hystrix断路器、Hystrix仪表盘监控服务运行情况，商品服务通过FeignClient调用用户服务
- microservice-api-gateway (spring cloud 服务网关) 子项目为apiGateway，通过spring cloud 的zuul实现服务对外路由与
负载均衡，通过zuulfilter,实现自定义的filter来剥离主要微服务的业务之上构建安全访问。通过fallback实现对路由服务回调返回操作。
- microservice-nodejs-comment 子项目 用nodejs写的一个简单的商品评论系统，做为接入微服务注册中的异构平台
- microservice-sidecar-comment 通过此应用把用nodejs构建的异构平台的服务接入了整个微服务体系中



