package test;

import com.rabbitMQ.MQMessage;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeansException;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by Oliver.Liu on 9/21/2016.
 */
public class TestMQ {
    public static void main(String args[]) throws IOException, TimeoutException {
        AbstractApplicationContext ctx = null;
        try {
            ctx = new ClassPathXmlApplicationContext(
                    new String[]{
                            "spring-mq.xml"
                    });
            AmqpTemplate template = ctx.getBean(AmqpTemplate.class);
            MQMessage mqMsg = new MQMessage();
            mqMsg.setTopic("Oliver.Liu44444");
            mqMsg.setContent("Just for Test55555");
            mqMsg.setDestination("348944382@qq.com");
            System.out.println("i get mqMsg:"+mqMsg.getTopic()+" :"+mqMsg.getContent());
            template.convertAndSend("mailQ",mqMsg);
            Thread.sleep(100000);
            ctx.destroy();
        } catch (BeansException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare("emailQueue", true, false, false, null);
        MQMessage mqMsg = new MQMessage();
        mqMsg.setTopic("Oliver.Liu1");
        mqMsg.setContent("Just for Test2");
        System.out.println("i get mqMsg:"+mqMsg.getTopic()+" :"+mqMsg.getContent());
        channel.basicPublish( "", "emailQueue",
                MessageProperties.PERSISTENT_TEXT_PLAIN,
                mqMsg.toString().getBytes());
        System.out.println(" [x] Sent '" + mqMsg.toString() + "'");

        channel.close();
        connection.close();*/
    }
}
