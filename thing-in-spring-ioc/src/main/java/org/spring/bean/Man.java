package org.spring.bean;
import org.spring.annotation.MAnnotation;
/**
 * 男人 ，继承
 * @author Sailor-why
 *
 */
@MAnnotation
public class Man extends Person {
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Man [address=" + address + ", name=" + name + ", age=" + age + "]";
	}
	
}
