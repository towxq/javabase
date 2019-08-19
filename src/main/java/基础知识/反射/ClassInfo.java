package 基础知识.反射;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ClassInfo {
    String value();
}
//@Retention：指Annotation被保留的时间长短，通过RetentionPolicy取值有3种
//        SOURCE：在源文件中有效（即源文件保留）
//        CLASS：在class文件中有效（即class保留）
//        RUNTIME：在运行时有效（即运行时保留）
//
//@Target：指Annotation所修饰的对象范围，通过ElementType取值有8种，如下
//        TYPE：类、接口（包括注解类型）或枚举
//        FIELD：属性
//        METHOD：方法
//        PARAMETER：参数
//        CONSTRUCTOR：构造函数
//        LOCAL_VARIABLE：局部变量
//        ANNOTATION_TYPE：注解类型
//        PACKAGE：包



//注解定义格式
//    public @interface 注解名 { 定义体 }


//注解参数可支持的数据类型
//        8种基本数据类型 int、float、boolean、byte、double、char、long、short
//        String、Class、enum、Annotation
//        以上所有类型的数组


