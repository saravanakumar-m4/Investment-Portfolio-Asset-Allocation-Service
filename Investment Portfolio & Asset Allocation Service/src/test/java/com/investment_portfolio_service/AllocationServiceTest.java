package com.investment_portfolio_service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.investment_portfolio_service.allocation.AllocationService;
import com.investment_portfolio_service.user.User;
import com.investment_portfolio_service.user.UserRepository;
import com.investment_portfolio_service.user.UserService;

@ExtendWith(MockitoExtension.class)
public class AllocationServiceTest {
	
	AllocationService service = new AllocationService();
	
	@InjectMocks
	UserService userService;
	
	@Mock
	UserRepository userRepo;
	
	@Test
	void testHighRiskAllocation() {
		var result = service.allocate("HIGH", 100000);
		assertEquals(70000, result.get("EQUITY"));
	}
	
	@Test
	void testLowRiskAllocation1() {
		var result = service.allocate("LOW", 100000);
		assertEquals(50000, result.get("DEBT"));
	}


//	  @AfterClass
//	    void contextLoads() {
//		  //fail("Testing");
//		  System.out.println("After class..");
//	    }
	  
	  @Test
	  public void createUserTest() {
		  User u1 = new User(4, "sk","sk@gmail.com", "sk@123","HIGH");
		  userService.save(u1);
		  
	  }
}
