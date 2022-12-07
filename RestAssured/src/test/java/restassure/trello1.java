package restassure;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class trello1 {
	
	public static String baseurl="https://api.trello.com";
	public String id;
	@Test()
	public void createBoard()
	{
		RestAssured.baseURI=baseurl;
	Response response=given().queryParam("name", "madhavilatha")
		.queryParam("key", "49092fc173bad640710c2819ec044089")
		.queryParam("token", "7e681907f3eebeb9077f49965bb433584499b3320d89ed4c0cdf9b0d5b18b2e6")
		.header("Content-Type", "application/json")
		.when()
		.post("/1/boards/")
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();
		String jsonresponse = response.asString();
		JsonPath js= new JsonPath(jsonresponse);
		
		id = js.get("id");
		System.out.println(id);		
	}
	@Test(enabled=true)
	public void delete()
	{
		
		
		JSONObject js=new JSONObject();
		
		
		baseURI=baseurl;
		given().queryParam("name","madhavilatha").queryParam("key","49092fc173bad640710c2819ec044089")
		.queryParam("token","7e681907f3eebeb9077f49965bb433584499b3320d89ed4c0cdf9b0d5b18b2e6")
		.when()
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.delete("/1/boards/"+id).then().log().all();
		
		
	}
	
	

}
