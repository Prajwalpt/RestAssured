package Testcase;

import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import utlities.RestassuredUtlities;

public class postrequest {

	RestassuredUtlities util =new RestassuredUtlities();
	
	
	@Test(priority=1)
	public void post() throws FileNotFoundException {
		util.postrequest();
	}
	
}
