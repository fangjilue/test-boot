package me.robbie.boot.test.script;


import java.io.File;
import java.io.StringReader;
import java.net.URL;
import java.util.Date;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;


import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyCodeSource;
import groovy.lang.GroovyObject;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import groovy.util.Eval;
import groovy.util.GroovyScriptEngine;

/**
 * <p>TODO:类定义</p>
 *
 * @author Robbie
 * @version $Id$
 */
public class Main {



    public static void test1() throws Exception {
        File file = new File("/Users/fangjilue/IdeaProjects/test/test-boot/src/main/resources/script/test.groovy");

        System.out.println(file.getAbsolutePath());

        GroovyClassLoader gcl = new GroovyClassLoader(Main.class.getClassLoader());

        Class clazz = gcl.parseClass(file);

        RuleEngine  engine = (RuleEngine) clazz.newInstance();

        RuleParam param = new RuleParam("java",18);

        RuleResult result = engine.exe(param);

        System.out.println(result);
    }

    public static void test2() throws Exception{
        File file2 = new File("/Users/fangjilue/IdeaProjects/test/test-boot/src/main/resources/script/file");

        GroovyClassLoader gcl = new GroovyClassLoader(Main.class.getClassLoader());

        Class clazz2 = gcl.parseClass(file2);

        RuleEngine  engine2 = (RuleEngine) clazz2.newInstance();

        RuleParam param2 = new RuleParam("file",0);

        RuleResult result2 = engine2.exe(param2);

        System.out.println(result2);
    }


    public static void test12() throws Exception{

        String script ="import me.robbie.boot.test.script.RuleEngine\n" +
                "import me.robbie.boot.test.script.RuleParam\n" +
                "import me.robbie.boot.test.script.RuleResult\n" +
                "class TestRule2 implements RuleEngine {\n" +
                "    @Override\n" +
                "    RuleResult exe(RuleParam param) {\n" +
                "\n" +
                "        println(param)\n" +
                "\n" +
                "\n" +
                "        new RuleResult(code:\"1\",name:\"fail\")\n" +
                "\n" +
                "    }\n" +
                "}\n";

        String dm5= "";

        GroovyClassLoader gcl = new GroovyClassLoader(Main.class.getClassLoader());

        Class clazz2 = gcl.parseClass(script);

        RuleEngine  engine2 = (RuleEngine) clazz2.newInstance();

        RuleParam param2 = new RuleParam("file",0);

        RuleResult result2 = engine2.exe(param2);

        System.out.println(result2);
    }


    public static void test3() throws Exception{

        String[] roots = new  String[]{"/Users/fangjilue/IdeaProjects/test/test-boot/src/main/resources/script/"} ;//定义Groovy脚本引擎的根路径
        GroovyScriptEngine engine = new GroovyScriptEngine(roots);

        //class 无缓存
        Class clazz = engine.loadScriptByName("test.groovy");


        RuleEngine  ruleEngine = (RuleEngine) clazz.newInstance();

        RuleParam param = new RuleParam("groovy",7);

        RuleResult result = ruleEngine.exe(param);

        System.out.println(result);
    }

    public static void test4(){

        System.out.println(Eval.me("v",3,"v * 5"));

        GroovyShell shell = new GroovyShell();
        Object result = shell.evaluate("3*5");
        Object result2 = shell.evaluate(new StringReader("3*5"));

        System.out.println(result+","+result2);

        Script script = shell.parse("3*5");

        assert script instanceof groovy.lang.Script;

        System.out.println(script.run());

        Script script2 = shell.parse("int fun(i,j){ i+j}");

        System.out.println(script2.invokeMethod("fun",new Integer[]{3,5}));
    }

    public static void test5(String name, int age) throws Exception{

        URL[] urls = new URL[]{new URL("http","localhost",80,"/")};

        GroovyScriptEngine engine = new GroovyScriptEngine(urls);

        //class 无缓存
        Class clazz = engine.loadScriptByName("hello.groovy");

        RuleEngine  ruleEngine = (RuleEngine) clazz.newInstance();

        RuleParam param = new RuleParam(name,age);

        RuleResult result = ruleEngine.exe(param);

        System.out.println(result);
    }

    public static void test6(){

        Binding sharedData = new Binding();
        GroovyShell shell = new GroovyShell(sharedData);
        Date now = new Date();

        sharedData.setProperty("text", "I am shared data!");
        sharedData.setProperty("date", now);

        String result =(String) shell.evaluate("date.toString() + ' abc ' + text.toString()");
        System.out.println(result);
    }

    public static  void test7() throws Exception {
        Binding binding = new Binding();
        GroovyShell shell = new GroovyShell(binding);
        //直接方法调用
        Script script = shell.parse(new File("/Users/fangjilue/IdeaProjects/test/test-boot/src/main/resources/script/fun2.groovy")) ;

        Long time = (Long)script.invokeMethod("getTime",new Date());
        System.out.println(time);



        GroovyClassLoader classLoader = new GroovyClassLoader(Thread.currentThread().getContextClassLoader());
        File sourceFile = new File("/Users/fangjilue/IdeaProjects/test/test-boot/src/main/resources/script/fun2.groovy");
        Class testGroovyClass = classLoader.parseClass(new GroovyCodeSource(sourceFile));
        GroovyObject instance = (GroovyObject)testGroovyClass.newInstance();//proxy
        time = (Long)instance.invokeMethod("getTime", new Date());
        System.out.println(time);
    }


    public static void evalScript() throws Exception{
        ScriptEngineManager factory = new ScriptEngineManager();
        //每次生成一个engine实例
        ScriptEngine engine = factory.getEngineByName("groovy");
        System.out.println(engine.toString());

        Integer sum = (Integer) engine.eval("(1..10).sum()");
        System.out.println(sum);

        System.out.println(engine.eval("5 > 3"));

        //javax.script.Bindings
        Bindings binding = engine.createBindings();
        binding.put("date", new Date());
        //如果script文本来自文件,请首先获取文件内容
        Object result1= engine.eval("def getTime(){return date.getTime();} \r\n def sayHello(name,age){return 'Hello,I am ' + name + ',age' + age;}",binding);
        //Object result2= engine.eval("def sayHello(name,age){return 'Hello,I am ' + name + ',age' + age;}");
        System.out.println(result1);
        //System.out.println(result2);
        Long time = (Long)((Invocable)engine).invokeFunction("getTime", null);
        System.out.println(time);
        String message = (String)((Invocable)engine).invokeFunction("sayHello", "zhangsan",new Integer(12));
        System.out.println(message);
    }

    public static void main(String[] args) throws Exception {

        //Main.test1();
        //Main.test2();
        //GroovyClassLoader gcl = new GroovyClassLoader(Main.class.getClassLoader());

        //gcl.getResourceAsStream("script/spring.groovy");
        //System.out.println(gcl.getResource("script/spring.groovy"));

        //Main.test12();

        //Main.test3();
        //Main.test4();
        //Main.test5("name",5);
        //Main.test6();
        //Main.test7();

        //evalScript();
    }
}
