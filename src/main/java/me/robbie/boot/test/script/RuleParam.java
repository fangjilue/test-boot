package me.robbie.boot.test.script;


/**
 * <p>
 * TODO:类定义
 * </p>
 *
 * @author Robbie
 * @version $Id$
 */
public class RuleParam {

    private int    age;
    private String name;

    public RuleParam() {
    }

    public RuleParam(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "RuleParam{" + "age=" + age + ", name='" + name + '\'' + '}';
    }
}
