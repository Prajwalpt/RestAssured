package Testcase;

import java.io.FileNotFoundException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utlities.RestassuredUtlities;

public class deleterequest {

	
	RestassuredUtlities util =new RestassuredUtlities();
	
	@BeforeMethod
	public void post() throws FileNotFoundException {
		util.postrequest();
	}
	@Test(priority=4)
	public void delete() throws FileNotFoundException {
		util.deleteRequest();
		
	}
}
