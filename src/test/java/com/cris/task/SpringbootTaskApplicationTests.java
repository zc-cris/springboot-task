package com.cris.task;

import org.apache.logging.log4j.message.SimpleMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTaskApplicationTests {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    // 测试发送一封简单的邮件
	@Test
	public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        // 邮件设置
        message.setSubject("今晚开会");
        message.setText("晚上8:00 到4楼开会");

        message.setTo("17623887386@163.com");
        message.setFrom("990435014@qq.com");

	    javaMailSender.send(message);

	}

	// 发送一封复杂的邮件
	@Test
    public void test() throws Exception{
	    // 创建一封复杂的邮件
        MimeMessage message = javaMailSender.createMimeMessage();
        // 是否要上传文件
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        // 邮件设置
        helper.setSubject("通知—今晚开会");
        helper.setText("<b style='color:red'>今晚9:00到天台好好聊聊，兄弟</b>", true);
        helper.setTo("17623887386@163.com");
        helper.setFrom("990435014@qq.com");

        // 上传附件
        helper.addAttachment("1.jpg", new File("C:\\Users\\zc-cris\\Pictures\\FLAMING MOUNTAIN.JPG"));
        helper.addAttachment("2.jpg", new File("C:\\Users\\zc-cris\\Downloads\\明日花\\1.jpg"));

        // 发送邮件
        javaMailSender.send(message);


    }

}
