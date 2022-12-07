package restassure;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class googlemaps_practice {
	
	public static String baseurl="http://216.10.245.166";
	String placeid;
	
	
	@Test(enabled=true)
	public void add()
	{
		
		RestAssured.baseURI=baseurl;
		JSONObject js=new JSONObject();
		JSONArray ja=new JSONArray();
		JSONObject jy=new JSONObject();
		jy.put("lat", 38.383494);
		jy.put("lng", 33.427362);
		ja.add(jy);
		js.put("location", jy);
		js.put("accuracy", 50);
		js.put("name", "Frontline house");
		js.put("phone_number", "983 893 3937");
		js.put("address", "29, side layout, cohen 09");
		js.put("types", "shoe park");
		js.put("website", "http://google.com");
		js.put("language", "French-IN");
		
//	given().queryParam("key","qaclick123").contentType(ContentType.JSON).accept(ContentType.JSON).body(js.toJSONString())
//	.when().post("/maps/api/place/add/json").then().log().all();
		
		Response R=given().queryParam("key","qaclick123").contentType(ContentType.JSON).accept(ContentType.JSON).body(js.toJSONString())
				.when().post("/maps/api/place/add/json").then().extract().response();
		
		String jsresponse=R.asString();
		JsonPath jp=new JsonPath(jsresponse);
		placeid=jp.get("place_id");
	System.out.println(placeid);
	
		
		
		
	}
	
	@Test(enabled=true)
	public void delete()
	
	{
		
		
		RestAssured.baseURI=baseurl;
		JSONObject js=new JSONObject();
		
		//js.put("place_id","3fde962cdb1dfc53332fde1c3e885c93");
		js.put("place_id", placeid);
		
		given().queryParam("Key","qaclick123").contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(js.toJSONString()).when().delete("/maps/api/place/delete/json").then().log().all();
		
	}
	
	
	
	

}
