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
	
	
	
	
	
	
	
	Spring loC依赖查找
	1.依赖查找的今世前生
		●单一类型依赖查找
			●JNDI - javax.naming.Context#lookup(javax.naming.Name)
			●JavaBeans - java.beans.beancontext. Bean Context
		●集合类型依赖查找
			●java.beans.beancontext. BeanContext
		●层次性依赖查找
			●java.beans.beancontext.BeanContext
	2.单一 类型依赖查找
		● 单一类型依赖查找接口- BeanFactory
		●根据Bean名称查找
			●getBean(String)
			●Spring 2.5覆盖默认参数: getBean(String,Objet..)
		●根据Bean类型查找
			●Bean实时查找
			●Spring 3.0 getBean(Class)
			●Spring 4.1覆盖默认参数: getBean(Class,Object..)
		●Spring 5.1 Bean 延迟查找
			●getBeanProvider(Class)
			●getBeanProvider(ResolvableType)
		●根据Bean名称+类型查找: getBean(String,Class)
	3.集合类型依赖查找
		●集合类型依赖查找接口- ListableBeanFactory
		●根据Bean类型查找
			●获取同类型Bean名称列表
				●getBeanNamesFor Type(Class)
				●Spring 4.2 getBeanNamesForType(ResolvableType)
			●获取同类型Bean实例列表
				●getBeansOfType(Class)以及重载方法
		●通过注解类型查找
				●Spring 3.0获取标注类型Bean名称列表
					●getBeanNamesForAnnotation(Class<? extends Annotation>)
				●Spring 3.0获取标注类型Bean实例列表
					●getBeansWithAnnotation(Class<? extends Annotation>)
				●Spring 3.0获取指定名称+标注类型Bean实例
					●findAnnotationOnBean(String,Class<? extends Annotation>)
				
	4.层次性依赖查找
		
		●层次性依赖查找接口- HierarchicalBeanFactory
		双亲BeanFactory: getParentBeanFactory()
		层次性查找
			●根据Bean名称查找
				●基于contains ocalBean方法实现
			●根据Bean类型查找实例列表
				●单一类型: BeanFactoryUtils#beanOfType
				●集合类型: BeanFactoryUtils#beansOfTypelncludingAncestors
			●根据Java注解查找名称列表
				●BeanFactoryUtils#beanNamesFor TypeIncludingAncestors
				
		
	5.延迟依赖查找	
		●Bean延迟依赖查找接口
			●org.springframework.beans.factory.ObjectFactory
			●org.springframework.beans.factory.ObjectProvider
				Spring5对Java 8特性扩展
					●函数式接口
						●getlfAvailable(Supplier)
						●ifAvailable(Consumer)
					●Stream扩展- stream()
		
		
	6.安全依赖查找
		依赖查找安全性对比
	依赖查找类型						代表实现						是否安全
	单一类型查找					BeanFactory#getBean					否
								ObjectFactory#getObject				否
								ObjectProvider#getlfAvailable		是
	集合类型查找					ListableBeanFactory#getBeansOfType	是
								ObjectProvider#stream				是
	注意:层次性依赖查找的安全性取决于其扩展的单一或集合类型的BeanFactory接口
		
	
	7.内建可查找的依赖
		AbstractApplicationContext内建可查找的依赖
	Bean名称										Bean实例								使用场景
	environment 							Environment对象 						外部化配置以及Profiles
	systemProperties 						java.util.Properties对象 				Java系统属性
	systemEnvironment 						java.util.Map对象 					操作系统环境变量
	messageSource 							MessageSource对象 					国际化文案
	lifecycleProcessor 						LifecycleProcessor对象 				Lifecycle Bean处理器
	applicationEventMulticaster 			pplicationEventMulticaster对象Spring 事件广播器
		
	Bean名称										Bean实例								使用场景
	org.springframework.context.				ConfigurationClassPostProcessor对象		处理Spring配置类
	annotation.
	internalConfigurationAnnotationProcessor								
	
	org.springframework.context.				AutowiredAnnotationBeanPostProcessor对象			处理@Autowired以及@Value注解
	annotation.internalAutowired
	AnnotationProcessor
	
	org.springframework.context. 				CommonAnnotationBeanPostProcessor对象		(条件激活)处理JSR- -250注解，如@PostConstruct等
	annotation.internalCommonAnnotationProcessor
	 
	org.springframework.context. 				EventListenerMethodProcessor对象		处理标注@EventListener的Spring事件监听方法
	event.internalEventL istenerProcessor

	org.springframework.context.					DefaultEventL istenerFactory对象       	@EventL istener事件监听方法适配为ApplicationListener
	event.internalEventL istenerFactory			
	
	org.springframework.context. 					PersistenceAnnotationBeanPost		(条件激活)处理JPA注解场景
	annotation.internalPersistenc					Processor对象
	eAnnotationProcessor


		
		
	8.依赖查找 中的经典异常
	BeansException子类型
	异常类型								触发条件(举例)					场景举例
	NoSuchBeanDefinitionException		当查找Bean不存在于loC容器时		BeanFactory#getBean
																	ObjectFactory#getObject
	NoUniqueBeanDefinitionException		类型依赖查找时，loC 容器存在多		BeanFactory#getBean(Class)
										个Bean实例	
													
	BeanInstantiationException			当Bean所对应的类型非具体类时		BeanFactory#getBean
	
	BeanCreationException				当Bean初始化过程中				Bean初始化方法执行异常时
	
	BeanDefinitionStoreException		当BeanDefinition配置元信息非法时	XML配置资源无法打开时



	
	
	
	9.面试题精选
		
	ObjectFactory和BeanFactory的区别？
		答: ObjectFactory与BeanFactory 均提供依赖查找的能力。
		不过ObjectFactory仅关注一个或一 种类型的Bean依赖查找，并且
		自身不具备依赖查找的能力，能力则由BeanFactory输出。
		BeanFactory则提供了单-类型、集合类型以及层次性等多种依赖查找方式，。
		
	996面试题- BeanFactory.getBean操作是否线程安全?
		答: BeanFactory.getBean 方法的执行是线程安全的，操作过程中会增加互斥锁
	
	
	
	
	沙雕面试题-有多少种依赖注入的方式?
		答:构造器注入 : 少依赖，强制性依赖的时候使用
		Setter注入 : 多依赖，非强制性的依赖时候
		字段注入	:主要是开发比较便利
		方法注入	：通常只要是做声明
		接口回调注入：比较特殊，有可能有些生命周期回调的时候一些注入。setBeanFactory  setApplicationContext
	
	996面试题-你偏好构造器注入还是Setter注入?
		答:两种依赖注入的方式均可使用，如果是必须依赖的话，那么推荐使用构
		造器注入，Setter 注入用于可选依赖。
	
	
	
	
		
	
	
	
	
	
	