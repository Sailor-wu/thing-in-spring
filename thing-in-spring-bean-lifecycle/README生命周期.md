	
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
9. 	Spring Bean属性赋值前阶段
10. Spring Bean Aware接口回调阶段
11. Spring Bean初始化前阶段
12. Spring Bean初始化阶段
13. Spring Bean初始化后阶段
14. Spring Bean初始化完成阶段
15. Spring Bean销毁前阶段
16. Spring Bean销毁阶段
17. Spring Bean垃圾收集
18. 面试题



