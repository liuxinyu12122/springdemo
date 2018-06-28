package com.example.demo;

import com.example.dao.mapper.UserMapper;
import com.example.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringdemoApplicationTests {
	@Autowired
	private RedisTemplate<String,User> userRedisTemplate;
	@Autowired
	private UserMapper userMapper;

	@Test
	public void findByName() throws Exception {
		List<User> userList = userMapper.selectUsers();
		Assert.assertEquals(20, userList);
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

}
