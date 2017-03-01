package com.troylc.cloud.dao;

import com.troylc.cloud.bean.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by troylc on 2017/2/27.
 * 用户持久层JPA接口
 * /**
 * 通过前面的配置可以看出，Spring 对 JPA 的支持已经非常强大，开发者无需过多关注 EntityManager 的创建、事务处理等 JPA 相关的处理
 * ***********************************************************************
 * 然而spring对Jpa的支持不止于此，它要从根本上来简化我们的业务代码                        **
 * 在没用使用jpa支持的时候，我们的代码应该是这样的：                                    **
 *     1、IUserDao   持久层接口                                                **
 *     2、IUserDaoImpl   持久层实现类                                            **
 *     3、IUserService    业务层接口.....后面不在列举                                    **
 * 每写一个实体类，都要衍生出5、6个类来对他进行操作，即使有了注解，我们可以依赖注入方式来拿到实现类，    **
 * 但是通用的CRUD等操作却不免在每个实现类里声明，你又说，我可以定义一个父类，利用泛型反射原理就可以了，    **
 * 但那样你还需要为每个Dao声明自己的实现类来继承你的父类                                    **
 * ***********************************************************************
 * 那么问题来了...（不是挖掘机技术）对持久层的简化技术哪家强？      Spring Data Jpa            **
 * 你唯一要做的就只是声明持久层的接口，来继承他自身已经封装好的持久层接口，正如本类IUserDao一样        **
 * 可使用的接口有：                                                            **********
 *　    Repository：是 Spring Data的一个核心接口，它不提供任何方法，开发者需要在自己定义的接口中声明需要的方法。**
 *     CrudRepository：继承Repository，提供增删改查方法，可以直接调用。                            **
 *     PagingAndSortingRepository：继承CrudRepository，具有分页查询和排序功能（本类实例）        **
 *     JpaRepository：                         继承PagingAndSortingRepository，针对JPA技术提供的接口            **
 *     JpaSpecificationExecutor：          可以执行原生SQL查询 用来做复杂查询的接口                                   **
 *    继承不同的接口，有两个不同的泛型参数，他们是该持久层操作的类对象和主键类型。                            **
 *********************************************************************************
 */
@Repository
public interface UserDaoRepository extends JpaRepository<UserBean,Long> {
}
