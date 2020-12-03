package spring.aop.aoptest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserAspect {
    Long begin;

//      execution（<修饰符> <返回类型> <类路径> <方法名>(<参数列表>) <异常模式> ）
//      <修饰符>：类型修饰符，可选，如public、protected，*表示任意修饰符
//      <返回类型>：必填，如void,String等，*表示任意类型
//      <类路径>：类型表达式匹配（包名.类名），可选 “包名.*”表示包下所有类，“包名..*”表示包以及子包下所有的类
//      <方法名>：方法名匹配，必填，*表示可以匹配任意方法
//     （参数列表）：参数匹配，必填,()表示没有参数，(..)表示匹配任意个数参数,(..,String)表示匹配最后一个参数是String类型方法，前面可以是任意参数
//      <异常模式>：异常列表，可选
    @Pointcut("execution(* spring.aop.aoptest..*.*(..))")
    public void aspectMethod(){
    }

    @Before("aspectMethod()")
    public void before(){
        begin = System.currentTimeMillis();
        System.out.println("before run");
    }

    @After("aspectMethod()")
    public void after(){
        Long time = System.currentTimeMillis();
        Long ss = begin-time;
        System.out.println("after run"+ss);
    }

//    @Around("aspectMethod()")
//    public void around(){
//        System.out.println("around run ");
//    }

}

//spring aop
// 1,Enabling @AspectJ Support
//spring容器初始化的时候完成了代理  AnnotationAwareAspectJAutoProxyCreator


//proxy
//    1，jdk动态代理 (spring默认)
//    2，cglib
//    3，asm
//    4，javasit


//@Aspect   切面 就是对横切面关注点的抽象，一个切面能够包含同一个类型的不同增强方法，比如事务处理和日志处理可以理解为两个切面
//              切面由切入点和通知组成，包含了横切逻辑的定义，也包含了切入点的定义，spring将切面定义的横切逻辑织入到切面所指定的连接点中

//@JoinPoint  连接点 程序过程中拦截的点 spring中一般是方法

//@Pointcut  切点 切点就是对连接点进行拦截的条件定义，切入点表达式如何和连接点匹配是aop的核心，spring默认使用Aspectj切入点的语法
//                决定advice通知应该作用域的那个连接点

//@Advice    通知 定义在连接点做什么  spring中通知的类型：前置通知  后置通知  返回通知  异常通知  环绕通知

//切面 = 切点+连接点+通知
//切点是所有连接点的集合

//引入 无需修改现有类的代码，向现有类添加新的方法或属性
//织入 把切面应用到目标对象并创建新的代理对象的过程

//静态织入： 通过特定的编译器在编译期间将需要增加的代码的织入，即编译生成class文件，字节码已被织入
//动态织入： 运行时动态将要增强的代码织入到目标类中，一般通过动态代理技术实现，如JDK动态代理和cglib动态代理