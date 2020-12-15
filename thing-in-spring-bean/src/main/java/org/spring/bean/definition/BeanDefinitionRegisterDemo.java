package org.spring.bean.definition;

import java.util.Map;

import org.spring.bean.Person;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
/**
 *  bean 的注册
 * @author Sailor-why
 *
 */
@Import(BeanDefinitionRegisterDemo.Config.class)
public class BeanDefinitionRegisterDemo {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext 	applicationContext = new AnnotationConfigApplicationContext();
		// 注册
		applicationContext.register(BeanDefinitionRegisterDemo.class);
		// 启动
		applicationContext.refresh();
		System.out.println("注解 Config 注册bean ："+applicationContext.getBeansOfType(Config.class));
		System.out.println("注解 @Bean Person 注册bean ："+applicationContext.getBeansOfType(Person.class));
		// 显示关闭
		applicationContext.close();
		
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
