package org.spring.bean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.stream.Stream;

public class BeanInfoMain {

	public static void main(String[] args) throws IntrospectionException {
		BeanInfo info = Introspector.getBeanInfo(Person.class,Object.class);
		
		
		Stream.of(info.getPropertyDescriptors())
		.forEach(bean -> {
			System.out.println(bean);
		});
	}
}
