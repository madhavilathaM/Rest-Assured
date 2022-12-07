package restassure;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class trellorestassure {
	
	public static String url="https://api.trello.com";
	public static String key="49092fc173bad640710c2819ec044089";
	public static String token="7e681907f3eebeb9077f49965bb433584499b3320d89ed4c0cdf9b0d5b18b2e6";
public String str;

@Test(enabled=true)
public void create()
{
	
	JSONObject js=new JSONObject();
	JsonPath jp=new JsonPath(js.toJSONString());
	str=jp.toString();
	
	js.get("id");
	
	baseURI=url;
	given().queryParam("name","RestAssured2").queryParam("key",key)
	.queryParam("token",token)
	.when()
	.contentType(ContentType.JSON).accept(ContentType.JSON)
	.post("/1/boards/").then().log().all();
	System.out.println(str);
	
	
	
	
}
@Test(enabled=false)
public void delete()
{
	
	
	JSONObject js=new JSONObject();
	
	
	baseURI=url;
	given().queryParam("name","RestAssured").queryParam("key",key)
	.queryParam("token",token)
	.when()
	.contentType(ContentType.JSON).accept(ContentType.JSON)
	.delete("/1/boards/VKph3dTb").then().log().all();
	
	
}

@Test(enabled=false)
public void update()
{
	
	baseURI=url;
	given().queryParam("name", "madhavi").queryParam("key", key).queryParam("token", token).when().contentType(ContentType.JSON)
	.accept(ContentType.JSON).put("/1/boards/GstMEg0B").then().log().all();
	
	
}
@Test(enabled=false)
public void getallboards()
{
	
	baseURI=url;
	
	given().queryParam("key", key).queryParam("token", token).when().contentType(ContentType.JSON)
	.accept(ContentType.JSON).get("/1/members/me/boards").then().log().all();
	
	
}
@Test(enabled=false)
public void getaboard()
{
	
baseURI=url;
	

given().queryParam("name", "latha").queryParam("key", key).queryParam("token", token).when().contentType(ContentType.JSON)
.accept(ContentType.JSON).get("/1/boards/pbb1EbVD").then().log().all();

	
	
	
	
}


}