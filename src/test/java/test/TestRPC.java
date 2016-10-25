package test;

import org.aspectj.weaver.patterns.ArgsAnnotationPointcut;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Oliver.Liu on 3/30/2016.
 */
public class TestRPC {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("spring-mvc.xml");
    }
}
