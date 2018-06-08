import me.robbie.boot.test.script.RuleEngine
import me.robbie.boot.test.script.RuleParam
import me.robbie.boot.test.script.RuleResult

/**
 * <p>TODO:类定义</p>
 *
 * @author Robbie
 * @version $Id$
 */
class TestRule implements RuleEngine {

    @Override
    RuleResult exe(RuleParam param) {

        println(param)

        new RuleResult(code:"0",name:"success")

    }
}
