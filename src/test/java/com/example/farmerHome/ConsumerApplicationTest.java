package com.example.farmerHome;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.farmerHome.apis.ConsumerService;
import com.example.farmerHome.entities.Consumer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerApplicationTest {

	@Autowired
	ConsumerService conService;
	
	@Test
	public void addConsumerUsingService() {
		Consumer con = new Consumer();
		con.setConsno(4);
		con.setName("Consumer 4");
		con.setEmail("consumer4@test.com");
		con.setAddress("4 Test Lane");
		con.setPhone(447777788);
		con = conService.registerOrUpdateConsumer(con);
		assertNotNull(con);
	}
	
	@Test
	public void findByConsnoUsingService() {
		int consno = 1;
		assertNotNull(conService.findByConsno(consno));
	}
	
	@Test
	public void deleteByConsnoUsingService() {
		int consno = 1;
		conService.deleteByConsno(consno);
		assertNull(conService.findByConsno(consno));
	}
	
	@Test
	public void simpleTest() {
		System.out.println();
	}
	
	@Test
	public void contextLoads() {
		System.out.println("System Test Executed");
	}
	
}
