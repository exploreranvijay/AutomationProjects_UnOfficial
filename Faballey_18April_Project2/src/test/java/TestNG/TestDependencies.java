package TestNG;

//import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestDependencies {
  @Test(priority=1)
  public void orange() {
	  System.out.println("Orange");
  }
@Test(priority=2,dependsOnMethods = {"orange"})
public void white() {
	System.out.println("White");
	
}
@Test(priority=3,dependsOnMethods = {"white"})
public void blue() {
	System.out.println("Blue");
	//Assert.fail("Blue Test Is Fail");
	throw new SkipException("Blue Test is Skipped");
}
@Test(priority=4,dependsOnMethods= {"blue"})
public void green() {
	System.out.println("Green");
}









}

