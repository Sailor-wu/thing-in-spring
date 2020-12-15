package org.spring.bean.definition;

import org.spring.bean.Person;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class BeanDefinitionDemo {

	public static void main(String[] args) {
		// 通过 BeanDefinitionBuilder 构建  bean
		BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Person.class);
		definitionBuilder.addPropertyValue("name", "abc");
		definitionBuilder.addPropertyValue("age", "22"); 
		 
		// 通过 AbstractBeanDefinition 以及派生类
		GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
		genericBeanDefinition.setBeanClass(Person.class);
		MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
		mutablePropertyValues.add("name", "abc").add("age", "22");
		genericBeanDefinition.setPropertyValues(mutablePropertyValues);
		
	}
}
