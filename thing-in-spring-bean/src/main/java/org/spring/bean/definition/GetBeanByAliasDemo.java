package org.spring.bean.definition;

import org.spring.bean.Person;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *  通过别名的形式获取bean
 * @author Sailor-why
 *
 */
public class GetBeanByAliasDemo {

	public static void main(String[] args) { 
		// 通过属性文件的形式 查找注册的bean 信息  实时查找
		BeanFactory factory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definition-context.xml");
		Person bean = (Person) factory.getBean("person");
		
		Person wu_bean = (Person) factory.getBean("wu-person");
		System.out.println(bean == wu_bean);
	}
}
