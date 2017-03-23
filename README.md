# Spring Cloud与Docker微服务实战笔记

* 本Repo是Spring Cloud与Docker微服务实战笔记的配套代码
* 包含X个DEMO
* 覆盖的项目有Eureka



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
- c (spring cloud 服务网关) 子项目为apiGateway，通过spring cloud 的zuul实现服务对外路由与
负载均衡，通过zuulfilter,实现自定义的filter来剥离主要微服务的业务之上构建安全访问。通过fallback实现对路由服务回调返回操作。



