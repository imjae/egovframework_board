package com.egovframwork.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import egovframework.example.sample.Restaurant;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {
				"file:src/main/webapp/WEB-INF/config/springmvc/test-servlet.xml"
				}
		)
@Log4j
public class SampleTests {
	
	@Setter(onMethod_ = @Autowired)
	private Restaurant restaurant;
	
	@Test
	public void testExist(){
		assertNotNull(restaurant);
		
		log.info(restaurant);
		log.info("--------------------------------------");
		log.info(restaurant.getChef());
		
	}
	
}
