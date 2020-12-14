记录笔记信息

1.错误: 找不到或无法加载主类
	由于在创建项目的时候，没有选中自动编译，在运行的时候，会找不到执行的class文件信息。因此会报这个错误。
	解决：手动build一次或者  Project--> Build Automatically开启自动编译并修改一次运行文件。



Spring loC容器概述

1. Spring IoC依赖查找(
		/thing-in-spring-ioc/src/main/java/org/spring/thing/ioc/dependency/lookup/DependencyLookupDemo.java
		/thing-in-spring-ioc/src/main/resources/META-INF/dependency-lookup.xml
		)
	根据Bean名称查找
		●实时查找
		●延迟查找
	根据Bean类型查找
		●单个Bean对象
	集合Bean对象
	根据Bean名称+类型查找
		●根据Java注解查找
	单个Bean对象
		●集合Bean对象
	
2. Spring loC依赖注入

	●根据Bean名称注入
	●根据Bean类型注入
	●单个 Bean对象
	●集合Bean对象
	●注入容器內建Bean对象
	●注入非Bean对象
	●注入类型
	●实时注入
	●延迟注入
	
3. Spring loC依赖来源
	●自定义Bean
	
	●容器內建Bean对象
	
	●容器內建依赖
	
4. Spring loC配置元信息
	●Bean定义配置
		●基于XML文件
		●基于Properties文件
		●基于Java注解
		●基于Java API (专题讨论)
	●loC容器配置
		●基于XML文件
		●基于Java注解
		●基于Java API (专 题讨论)
	●外部化属性配置
		●基于Java注解a
	
5. Spring IoC容器
	BeanFactory和ApplicationContext谁才是Spring loC容器?
	BeanFactory是ApplicationContext的一个基础的实现类，ApplicationContext具有更多的实现信息和功能接口。
	
	BeanFactory是Spring底层loC容器
	ApplicationContext是具备应用特性的BeanFactory超集
	
	
6. Spring 应用上下文
	ApplicationContext除了loC 容器角色，还有提供:
		●面向切面(AOP)
		●配置元信息(Configuration Metadata)
		●资源管理(Resources)
		●事件(Events)
		●国际化(i18n)
		●注解(Annotations)
		●Environment抽象(Environment Abstraction)
	
7. 使用Spring IoC容器
	启动
	运行
	停止
8. Spring IoC容器生命周期

9.面试题精选
	沙雕面试题一什么是Spring IoC容器?
	答:Spring框架实现反转
	 控制(IoC)原则。loC也称为依赖项
	注入(DI)。它是一个对象定义它们的过程
	仅依赖项(即它们使用的其他对象)
	通过构造函数参数，工厂方法的参数，
	或在对象实例之后在其上设置的属性
	从工厂方法构造或返回。容器
	然后在创建bean时注入这些依赖项。
	
	996面试题- BeanFactory与FactoryBean?
	答:
	BeanFactory是loC底层容器:
	FactoryBean是创建Bean的一种方式，帮助实现复杂的初始化逻辑
	
	劝退面试题- Spring loC容器启动时做了哪些准备?
	答: IoC配置元信息读取和解析、loC容器生命周期、Spring 事件发布、国际化等，更多答案将在后续专题章节逐一讨论
	