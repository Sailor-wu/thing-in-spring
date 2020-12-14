package main.java.org.bean;

/**
 * @author sailor
 * @Date { 2020/12/14-15:15 }
 */
public class Person {
    String name;
    Integer age;

    public Person() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }
}
