package test;

import com.mail.MailSenderService;
import com.service.IUserService;
import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Oliver.Liu
 */
@RunWith(SpringJUnit4ClassRunner.class)     //��ʾ�̳���SpringJUnit4ClassRunner��
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestMybatis {
    private static Logger logger = Logger.getLogger(TestMybatis.class);
    //  private ApplicationContext ac = null;
    @Resource
    private IUserService userService = null;
//  @Before
//  public void before() {
//      ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//      userService = (IUserService) ac.getBean("userService");
//  }
   /* @Test
    public void test1() {
        User user = userService.getUserById(1);
        System.out.println(user.getUserName());
        // logger.info("ֵ��"+user.getUserName());
        logger.info(JSON.toJSONString(user));
    }*/
    @Test
    public void test1() {
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
        mailSender.setTemplateName("/vm/mail.vm");
        mailSender.setTo("348944382@qq.com");
        mailSender.setSubject("来自worthtech的邮件");
        mailSender.setTemplateName("mail.vm");//设置的邮件模板
        Map model=new HashMap();
        model.put("username", "348944382");
        String url="http://www.mail.com?ttt=3";
        url=url.substring(0, url.lastIndexOf("/"));
        model.put("url", url);
        model.put("email", "li_jian0812@126.com");
        mailSender.sendWithTemplate(model);
        System.out.println("邮件发送成功！");

        //mybatis
        //String resource = "mybatis.xml";
        //InputStream is = TestMybatis.class.getClassLoader().getResourceAsStream(resource);
        //sqlSession
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        /*//ʹ��MyBatis�ṩ��Resources�����mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
        //Reader reader = Resources.getResourceAsReader(resource);
        //����sqlSession�Ĺ���
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //������ִ��ӳ���ļ���sql��sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * ӳ��sql�ı�ʶ�ַ�����
         * mapping.userMapper��userMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
         * getUser��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
         */
        //String statement = "mapping.userMapper.getUser";//ӳ��sql�ı�ʶ�ַ���
        //ִ�в�ѯ����һ��Ψһuser�����sql
        //User user = session.selectOne(statement, 1);
        /*
        SqlSession session = sessionFactory.openSession();
        try {
            IUserDAO userOperation=session.getMapper(IUserDAO.class);
            User user = userOperation.getUser(1);
            System.out.println(user.getId());
            System.out.println(user.getName());
            System.out.println(user);
        } finally {
            session.close();
        }*/
        /*
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        IUserDAO mapper = (IUserDAO) ctx.getBean("userMapper");
        //����id=1���û���ѯ���������ݿ��е���������Ըĳ����Լ���.
        System.out.println("�õ��û�id=1���û���Ϣ");
        User user = mapper.selectUser(1);
        System.out.println(user.getId());
        //�õ������б����
        System.out.println(user.getUserName());*/
    }
}
