package test;

import com.mail.MailSenderService;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Oliver.Liu on 3/21/2016.
 */
public class MailSenderServiceTest {

    @Test
    public void testSendWithTemplate() throws Exception {
        //注册完马上发送邮件
        ApplicationContext ctx = null;
        try {
            ctx = new ClassPathXmlApplicationContext("spring-mvc.xml");
        } catch (BeansException e) {
            e.printStackTrace();
        }
        MailSenderService mailSender=new MailSenderService();
        mailSender.setMailSender((JavaMailSender) ctx.getBean("mailSender"));
        mailSender.setSimpleMailMessage((SimpleMailMessage) ctx.getBean("simpleMailMessage"));
        mailSender.setVelocityEngine((VelocityEngine) ctx.getBean("velocityEngine"));
        mailSender.setTemplateName("/vm/mail.vm");//设置的邮件模板
        mailSender.setTo("li_jian0812@126.com");
        mailSender.setSubject("来自Oliver的邮件");
        Map model=new HashMap();
        model.put("username", "348944382");
        String url="http://www.mail.com?ttt=3";
        url=url.substring(0, url.lastIndexOf("/"));
        model.put("url", url);
        model.put("email", "li_jian0812@126.com");
        mailSender.sendWithTemplate(model);
        System.out.println("邮件发送成功！");
    }
}