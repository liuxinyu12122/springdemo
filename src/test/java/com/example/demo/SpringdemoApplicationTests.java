package com.example.demo;

import com.example.dao.mapper.UserMapper;
import com.example.entity.User;
import com.example.enumsource.Events;
import com.example.enumsource.States;
import com.example.service.RabbitMqSender;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.statemachine.StateMachine;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringdemoApplicationTests {
	@Autowired
	private RedisTemplate<String,User> userRedisTemplate;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private RabbitMqSender sender;
	@Autowired
	private StateMachine<States, Events> stateMachine;
	@Test
	public void findByName() throws Exception {
		List<User> userList = userMapper.selectUsers();
		Long size = userRedisTemplate.opsForList().size("users");
		Assert.assertEquals("10",size);
	}


	@Test
	public void testRedis() {
		User user = new User(1,"lxy","5");
		User user2 = new User(2,"cjm","18");

		userRedisTemplate.opsForValue().set("666",user);
		userRedisTemplate.opsForValue().set("777",user2);

		String value = userRedisTemplate.opsForValue().get("666").getPassword();
		Assert.assertEquals("20",userRedisTemplate.opsForValue().get("666").getPassword());


	}

	@Test
	public void sendEmail(){
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("283276132@qq.com");
		simpleMailMessage.setTo("283276132@qq.com");
		simpleMailMessage.setSubject("主题：测试");
		simpleMailMessage.setText("测试邮件内容");
		mailSender.send(simpleMailMessage);
	}

	@Test
	public void sendMqMsg(){
		sender.sender();
	}

	@Test
	public void testStateMachine(){
		stateMachine.start();
		stateMachine.sendEvent(Events.PAY);
		stateMachine.sendEvent(Events.RECEIVE);	}
}
