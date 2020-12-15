package org.spring.bean.definition;

import java.util.Map;

import org.spring.bean.Person;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
/**
 *  bean 的注册
 * @author Sailor-why
 *
 */
@Import(BeanDefinitionRegisterByApiDemo.Config.class)
public class BeanDefinitionRegisterByApiDemo {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext 	applicationContext = new AnnotationConfigApplicationContext();
		// 注册
		applicationContext.register(BeanDefinitionRegisterByApiDemo.class);
		
		// 命名的方式
		beandefinitionRegisterBypai(applicationContext, "haiyuan.wu");
		// 非命名方式
		beandefinitionRegister(applicationContext);
		// 启动
		applicationContext.refresh();
		System.out.println("注解 Config 注册bean ："+applicationContext.getBeansOfType(Config.class));
		System.out.println("注解 @Bean Person 注册bean ："+applicationContext.getBeansOfType(Person.class));
		// 显示关闭
		applicationContext.close();
		
	}
	
	public static void beandefinitionRegisterBypai(BeanDefinitionRegistry registry,String name) {
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Person.class);
		builder.addPropertyValue("age", 25)
		.addPropertyValue("name", "haiyuan.wu");
		// 通过api 自定义命名的方式注册bean
		if(StringUtils.hasText(name)) {			
			registry.registerBeanDefinition(name, builder.getBeanDefinition());
		}else {
			BeanDefinitionReaderUtils.registerWithGeneratedName(builder.getBeanDefinition(), registry);
		}
	}
	
	public static void beandefinitionRegister(BeanDefinitionRegistry registry ) {
		beandefinitionRegisterBypai(registry, null);
	}
	@Component
	class Config{
		
		@Bean(name="person_wu")
		public Person getPerson() {
			Person person = new Person();
			person.setAge(22);
			person.setName("haiyuan.wu");
			return person;
		}
	}
}
