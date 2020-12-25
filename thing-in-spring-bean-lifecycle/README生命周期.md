	
Spring Bean生命周期

1. 	Spring Bean元信息配置阶段
	BeanDefinition配置
	●面向资源
		●XML配置
		●Properties资源配置
	●面向注解
	●面向API
	
2. 	Spring Bean元信息解析阶段
	●面向资源BeanDefinition 解析
		●BeanDefinitionReader
		●XML解析器- BeanDefinitionParser
	●面向注解BeanDefinition解析
		●AnnotatedBeanDefinitionReader
	
3. 	Spring Bean注册阶段
	●BeanDefinition 注册接口
		●BeanDefinitionRegistry
	
4. 	Spring BeanDefinition合并阶段
	●BeanDefinition 合并
		●父子BeanDefinition合并
			●当前BeanFactory查找
			●层次性BeanFactory查找
	
5. 	Spring Bean Class加载阶段
	●ClassL oader类加载
	●Java Security安全控制
	●ConfigurableBeanFactory 临时ClassL oader

6. 	Spring Bean实例化前阶段
	●非主流生命周期- Bean实例化前阶段
		●InstantiationAwareBeanPostProcessor #postProcessBeforelnstantiation
	
7. 	Spring Bean实例化阶段
	●实例化方式
		●传统实例化方式
			实例化策略- InstantiationStrategy
		●构造器依赖注入
	
8. 	Spring Bean实例化后阶段
	●Bean属性赋值(Populate) 判断
		●InstantiationAwareBeanPostProcessor #postProcessAfterlnstantiation
	
9. 	Spring Bean属性赋值前阶段
	●Bean属性值元信息
		●PropertyValues
	●Bean属性赋值前回调
		●Spring 1.2 - 5.0: InstantiationAwareBeanPostProcessort#postProcessPropertyValues
		●Spring 5.1: InstantiationAwareBeanPostProcessor #postProcessProperties
	
10. Spring Bean Aware接口回调阶段
	●Spring Aware接口
		●BeanNameAware   bean 名称
		●BeanClassLoaderAware  bean 类加载
		●BeanFactoryAware    bean 工厂
		●EnvironmentAware    
		●EmbeddedValueResolverAware
		●ResourceloaderAware
		●ApplicationEventPublisherAware
		●MessageSourceAware  国际化
		●ApplicationContextAware
	
11. Spring Bean初始化前阶段
	●.已完成
		●Bean实例化
		●Bean属性赋值
		●Bean Aware接口回调
	●方法回调
		●BeanPostProcessor #postProcessBeforelnitialization
		
12. Spring Bean初始化阶段
	Bean初始化(Initialization)
		●@PostConstruct标注方法
		●实现InitializingBean接口的afterPropertiesSet()方法
		●自定义初始化方法.
	
13. Spring Bean初始化后阶段
	●方法回调
		●BeanPostProcessor #postProcessAfterlnitialization
	
14. Spring Bean初始化完成阶段
	●方法回调
		●Spring 4.1 +: SmartlnitializingSingleton#afterSingletonsInstantiated
	
15. Spring Bean销毁前阶段
	●方法回调
		●DestructionAwareBeanPostProcessor#postProcessBeforeDestruction
	
16. Spring Bean销毁阶段
	●Bean销毁(Destroy)
		●@PreDestroy标注方法
		●实现DisposableBean接口的destroy()方法
		●自定义销毁方法，
	
17. Spring Bean垃圾收集
	●Bean垃圾回收(GC)
		●关闭Spring容器(应用上下文)
		●执行GC
		●Spring Bean覆盖的finalize() 方法被回调
	
18. 面试题
	沙雕面试题- BeanPostProcessor的使用场景有哪些?
	答: BeanPostProcessor提供Spring Bean初始化前和初始化后的
	生命周期回调，分别对应postProcessBeforelnitialization以及
	postProcessAfterlnitialization方法，允许对关心的Bean进行扩展
	甚至是替换。
	加分项:其中，ApplicationContext 相关的Aware回调也是基于
	BeanPostProcessor实现，即ApplicationContextAwareProcessor
	
	996面试题- BeanFactoryPostProcessor与BeanPostProcessor的区别
		答: BeanFactoryPostProcessor是Spring BeanFactory (实际为
		ConfigurableListableBeanFactory)的后置处理器， 用于扩展
		BeanFactory,或通过BeanFactory进行依赖查找和依赖注入。
		加分项: BeanFactoryPostProcessor 必须有Spring ApplicationContext
		执行，BeanFactory 无法与其直接交互。
		而BeanPostProcessor则直接与BeanFactory关联，属于N对1的关系
	
	劝退面试题- BeanFactory是怎样处理Bean生命周期?
	答:
	BeanFactory的默认实现为DefaultL istableBeanFactory,其中Bean生命周期与方法映射如下:
		●BeanDefinition注册阶段- registerBeanDefinition
		●BeanDefinition合并阶段- getMergedBeanDefinition
		●Bean实例化前阶段- resolveBeforelnstantiation
		●Bean实例化阶段- createBeanInstance
		●Bean实例化后阶段- populateBean
		●Bean属性赋值前阶段- populateBean
		●Bean属性赋值阶段- populateBean
		●Bean Aware接口回调阶段- initializeBean
		●Bean初始化前阶段- initializeBean
		●Bean初始化阶段- initializeBean
		●Bean初始化后阶段- initializeBean
		●Bean初始化完成阶段- prelnstantiateSingletons
		●Bean销毁前阶段- destroyBean
		●Bean销毁阶段- destroyBean
	


