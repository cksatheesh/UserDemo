package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.repos.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDemoApplicationTests {

	@Autowired
	ApplicationContext context;
	
	@Test
	public void saveUser() {
		
		UserRepository repository = context.getBean(UserRepository.class);
		
		User user = new User();
		
		user.setId(1);
		user.setName("user1");
		user.setAge(24);
		user.setEmail("user1@user.com");
		
		repository.save(user);
		
		user.setId(2);
		user.setName("user2");
		user.setAge(24);
		user.setEmail("user2@user.com");
		
		repository.save(user);

		User result = repository.findOne(2);
		System.out.println(result);
		
		result.setAge(35);
		repository.save(result);
		System.out.println(result);
		
		repository.findAll().forEach(p -> {System.out.println(p.getName());});
	}

}
