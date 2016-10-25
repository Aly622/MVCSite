package com.rabbitMQ.listener;

import com.mail.MailSenderService;
import com.rabbitMQ.MQMessage;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Oliver.Liu on 9/27/2016.
 */
public class MailListener implements MessageListener {
    private static final Logger log = Logger.getLogger(MailListener.class);
    private final static Long SEND_DELAY_TIME = 10000l;
    @Autowired
    private Jackson2JsonMessageConverter jsonMessageConverter;
    @Autowired
    private MailSenderService mailsenderService;

    @Override
    public void onMessage(Message message) {
        MQMessage mqMessage = (MQMessage) jsonMessageConverter.fromMessage(message);
        try {
            Thread.sleep(SEND_DELAY_TIME);
            Map model=new HashMap();
            model.put("username", mqMessage.getTopic());
            model.put("url", mqMessage.getContent());
            model.put("email", mqMessage.getDestination());
            mailsenderService.setTemplateName("/vm/mail.vm");//设置的邮件模板
            mailsenderService.setTo(mqMessage.getDestination());
            mailsenderService.setSubject(mqMessage.getTopic());
            mailsenderService.sendWithTemplate(model);
            System.out.println("邮件发送成功！");
        } catch (InterruptedException e) {
            log.error(e);
        } catch (MessagingException e) {
            log.error(e);
        }
    }

    public void setMailsenderService(MailSenderService mailsenderService) {
        this.mailsenderService = mailsenderService;
    }

    public void setJsonMessageConverter(Jackson2JsonMessageConverter jsonMessageConverter) {
        this.jsonMessageConverter = jsonMessageConverter;
    }
}
