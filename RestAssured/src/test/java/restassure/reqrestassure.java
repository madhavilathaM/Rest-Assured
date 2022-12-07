package restassure;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class reqrestassure {
	
	
	public static String url="https://reqres.in/api/users?page=2";
	
	
	@Test(enabled=false)
	public void getallusers()
	{
		
	given().get(url).then().statusCode(200).log().all();
		
		
	}
	@Test(enabled=false)
	public void singleuser()
	{
		
		given().get("https://reqres.in/api/users/2").then().statusCode(200).log().all();
		
		
	}

	
	@Test(enabled=true)
	public void creat()
	{
		
		JSONObject js=new JSONObject();
		js.put("name", "madhavilatha");
		js.put("job", "tester");
		
		
		//System.out.println(js);
		
		//given().body(js.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(js.toJSONString()).
		when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
		
	}
	@Test(enabled=false)
	public void update()
	{
		
		JSONObject js=new JSONObject();
		js.put("name", "madhaviM");
		js.put("job","testing");
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(js.toJSONString()).when().put("https://reqres.in/api/users/506").
		then().statusCode(200).log().all();
	}
	
	
	@Test(enabled=false)
	public void delete()
	{
		
		given().delete("https://reqres.in/api/users/506").then().statusCode(204).log().all();
		
	}
	@Test(enabled=false)
	public void register()
	{
		
		JSONObject js=new JSONObject();
		js.put("email","eve.holt@reqres.in");
		js.put("password", "madhu@1234");
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(js.toJSONString()).when().post("https://reqres.in/api/register")
		.then().statusCode(200).log().all();
		
		
	}
	@Test(enabled=false)
	public void login()
	{
		JSONObject js=new JSONObject();
		js.put("email","eve.holt@reqres.in");
		js.put("password", "madhu@1234");
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(js.toJSONString()).when().post("https://reqres.in/api/login")
		.then().statusCode(200).log().all();
		
		
	}
	
	
}
