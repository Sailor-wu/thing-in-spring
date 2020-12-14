package org.spring.thing.ioc.dependency.lookup;

import java.util.Map;

import org.spring.annotation.MAnnotation;
import org.spring.bean.Man;
import org.spring.bean.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖查找
 * @author Sailor-why
 *
 */
public class DependencyLookupDemo {
	public static void main(String[] args) {
		// 通过属性文件的形式 查找注册的bean 信息  实时查找
		BeanFactory factory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup.xml");
		
//		lookupByRealTIme(factory);
		
		lookupByType(factory);
		
//		查找返回集合
		lookupCollectionsByType(factory);
		
//		根据注解返回对象
		lookupByAnnotation(factory);
	}

	private static void lookupByAnnotation(BeanFactory factory) {
		if(factory instanceof ListableBeanFactory) {
			ListableBeanFactory beanFactory = (ListableBeanFactory) factory;
			Map<String, Man> beansOfType = (Map)beanFactory.getBeansWithAnnotation(MAnnotation.class);
			System.out.println("getBeansWithAnnotation @MAnnotation查找集合数据："+beansOfType);
		}
	}

	/**
	 * 返回一个Map  key 存储的是bean 的id value 是Type类型的集合数据
	 * @author {Sailor-why}
	 */
	private static void lookupCollectionsByType(BeanFactory factory) {
		if(factory instanceof ListableBeanFactory) {
			ListableBeanFactory beanFactory = (ListableBeanFactory) factory;
			Map<String, Person> beansOfType = beanFactory.getBeansOfType(Person.class);
			System.out.println("查找集合数据："+beansOfType);
		}
	}

	private static void lookupByType(BeanFactory factory) {
		Person p =  factory.getBean(Person.class);
		System.out.println(p);
		
	}

	private static void lookupByRealTIme(BeanFactory factory) {
		Person p =  (Person) factory.getBean("person");
		System.out.println(p);
	}
}
