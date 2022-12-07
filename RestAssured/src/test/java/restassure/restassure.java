package restassure;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.*;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;



public class restassure {
	
	
	
	public static String url="https://reqres.in/api/users?page=2";
	

	@Test(enabled=false)
	public void test()
	{
		
		Response rep=RestAssured.get(url);
		
//int actual=	rep.statusCode();

//Assert.assertEquals(actual, 201);
//		rep.body();
//		rep.asString();
		System.out.println(rep.statusCode());
		System.out.println(rep.body());
		System.out.println(rep.asString());
		
	}
	
	@Test(enabled=false)
	public void test2()
	{
		
		
		given().get(url).then().statusCode(200).log().all();//get all users
		
		
		
		given().
		get(url).
		then().statusCode(200).body("data.first_name",hasItems("Michael"));
		
		given().
		get(url).
		then().statusCode(200).body("data.id[12]",equalTo(2)).log().all();
			
		
		
	}
	@Test(enabled=false)
	public void test3()
	{
		JSONObject js=new JSONObject();
        js.put("name","madhavi");
		js.put("job","tester");
		
		//System.out.println(js);
		given().body(js.toJSONString()).when().post("https://reqres.in/api/users").then().log().all();//create user
	
			
		
		//given().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();//delete user
		
			
		
	}
	@Test(enabled=false)
	public void test4()
	{
		
		given().get("https://reqres.in/api/users/2").then().log().all();//get single user
		
		
		
	}
	
	
	
	@Test(enabled=true)
	public void register()
	{
		JSONObject js = new JSONObject();
		js.put("email", "eve.holt@reqres.in");
		js.put("password", "pistol");
		
		given().body(js.toJSONString()).when().post("https://reqres.in/api/register").then().log().all();
		
		//Response R=given().contentType(ContentType.JSON).log().all().body(js).post("https://reqres.in/api/register");
		//R.prettyPrint();
	}
	
	
	
	

}
