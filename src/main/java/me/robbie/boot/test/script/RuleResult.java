package me.robbie.boot.test.script;


/**
 * <p>TODO:类定义</p>
 *
 * @author Robbie
 * @version $Id$
 */
public class RuleResult {

    private String code;
    private String name;

    public RuleResult() {
    }

    public RuleResult(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RuleResult{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
