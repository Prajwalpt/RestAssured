package Testcase;

import java.io.FileNotFoundException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utlities.RestassuredUtlities;

public class putrequest {

	RestassuredUtlities util =new RestassuredUtlities();
	
	@BeforeMethod
	public void post() throws FileNotFoundException {
		util.postrequest();
	}
	@Test(priority=3)
	public void upadte() throws FileNotFoundException {
		util.putrequest();
		
	}
}
