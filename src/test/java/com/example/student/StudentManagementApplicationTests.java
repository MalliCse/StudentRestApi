package com.example.student;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentManagementApplicationTests {

	@Test
	public void sample()
	{
		String name="Malli";
	    assertNotEquals(name,"malli");
	    assertEquals(name,"Malli");
	    
	    
	}
	
	@Test
	public void sample1()
	{
		String name="Malli";
	    assertNotEquals(name,"malli");
	    assertEquals(name,"Malli");
	    
	    
	}

}
