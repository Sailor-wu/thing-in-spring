Spring Bean基础

1. 	定义Spring Bean
	●
什么是BeanDefinition?
BeanDefinition是Spring Framework中定义Bean的配置元信息接口，包含:
	●Bean的类名
	●Bean 行为配置元素， 如作用域、自动绑定的模式、 生命周期回调等
	●其他Bean引用，又可称作合作者(Collaborators) 或者依赖( Dependencies )
	●配置设置， 比如Bean属性(Properties)
	
2. 	BeanDefinition元信息
	BeanDefinition元信息
	属性(Property)					说明
	Class						Bean全类名，必须是具体类，不能用抽象类或接口
	Name						Bean的名称或者ID
	Scope						Bean的作用城(如: singleton、 prototype 等)
	Constructor arguments		Bean构造器参数(用于依赖注入)
	Properties					Bean属性设置(用于依赖注人)
	Autowiring mode				Bean自动绑定模式(如:通过名称byName)
	Lazy initialization mode	Bean延迟初始化模式(延迟和非延迟)
	Initialization method		Bean初始化回调方法名称
	Destruction method			Bean销毁回调方法名称
			
	BeanDefinition构建
		通过BeanDefinitionBuilder
		通过AbstractBeanDefinition以及派生类
	
	
	
3.	命名 Spring Bean
	Bean的名称
	每个Bean拥有一个或多个标识符(identifiers) ，这些标识符在Bean所在的容器必须是唯 一的。
	通常一个Bean仅有一个标识符，如果需要额外的，可考虑使用别名(Alias) 来扩 充。
	在基于XML的配置元信息中，开发人员可用id 或者name属性来规定Bean的标识符。
	通常Bean的标识符由字母组成，允许出现特殊字符。如果要想引入Bean的别名的话，可在name属性使用半角逗号(“,”) 或分号(“;,") 来间隔。
	Bean的id或name属性并非必须制定，如果留空的话，容器会为Bean自动生成一个唯一的名称。
	Bean的命名尽管没有限制，不过官方建议采用驼峰的方式，更符合Java的命名约定。
 	
 	
		
4. 	Spring Bean的别名
	●Bean别名(Alias) 的价值
		复用现有的BeanDefinition
		更具有场景化的命名方法，比如:
	<alias name="myApp--dataSource" alias="subsystemA-dataSource"/>
	<alias name="myApp--dataSource" alias="subsystemB--dataSource"/>
	
5.	注册Spring Bean---》BeanDefinitionRegisterByApiDemo.java

	BeanDefinition注册
	●XML配置元信息
		<bean name=".." ... />
	●Java注解配置元信息
		@Bean
		@Component
		@Import
	●Java API配置元信息( UI底层的方式)
		命名方式: BeanDefinitionRegistry#registerBeanDefinition(String,BeanDefinition)
		非命名方式:
		BeanDefinitionReaderUtils#registerWithGeneratedName(AbstractBeanDefinition,Bean)
		finitionRegistry)
		配置类方式: AnnotatedBeanDefinitionReader#register(Class)
			

6.	实例化 Spring Bean
7.	初始化 Spring Bean
8.	延迟初始化 Spring Bean
9.	销毁 Spring Bean
10.	垃圾回收Spring Bean
11.	面试题精选
