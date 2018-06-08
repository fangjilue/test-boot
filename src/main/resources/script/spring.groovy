import me.robbie.boot.test.script.RuleEngine
import me.robbie.boot.test.script.RuleParam
import me.robbie.boot.test.script.RuleResult


class SpringRule implements RuleEngine {


    @Override
    RuleResult exe(RuleParam param) {

        println(param)

        new RuleResult(code:"0",name:"success")

    }
}
