package com.example.demo;

import com.example.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringdemoApplicationTests {
	@Autowired
	private RedisTemplate<String,User> userRedisTemplate;

	@Test
	public void contextLoads() {

	}


	@Test
	public void testRedis() {
		User user = new User("lxy","20");
		User user2 = new User("cjm","18");

		userRedisTemplate.opsForValue().set("666",user);
		userRedisTemplate.opsForValue().set("777",user2);

		Assert.assertEquals("20",userRedisTemplate.opsForValue().get("666").getPassword());


	}

}
