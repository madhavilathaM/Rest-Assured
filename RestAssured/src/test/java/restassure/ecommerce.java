package restassure;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

//import io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;


public class ecommerce {

	
	public static String url="https://ecommerceservice.herokuapp.com";
	public String Accesstoken;
	
	@Test(enabled=false)
	public void user_register()
	{
		RestAssured.baseURI=url;
				
		JSONObject js=new JSONObject();
		
	js.put("email", "madhu12344@gmail.com");
	js.put("password", "ml1224");
		
	given().contentType(ContentType.JSON).accept(ContentType.JSON).when().body(js.toJSONString()).post("/user/signup").then()
	.statusCode(201).log().all();
		
		
	}
	@Test(enabled=false)
	public void user_login()
	{
		
		
		RestAssured.baseURI=url;
		JSONObject js=new JSONObject();
		js.put("email", "madhu12344@gmail.com");
		js.put("password", "ml1224");
		
	Response R=	given().contentType(ContentType.JSON).accept(ContentType.JSON).body(js.toJSONString()).when().post("/user/login")
		.then().extract().response();
	String jsonresponse=R.asString();
	JsonPath jp=new JsonPath(jsonresponse);
	//System.out.println(jsonresponse);
		Accesstoken=jp.get("accessToken");
		System.out.println(Accesstoken);
		
		
		
	}
	@Test(enabled=false)
	public void getalluser()
	{
		
		
		RestAssured.baseURI=url;
		
		JSONObject js=new JSONObject();
		//js.put("token", Accesstoken);
		//given().contentType(ContentType.JSON)
		//.accept(ContentType.JSON).when().get("/user").then().log().all();
		given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczOGVhYzllYjcxMzAwMTc2MmE1ZDEiLCJpYXQiOjE2Njg1MjY1NzUsImV4cCI6MTY2ODYxMjk3NX0.ZyGFo64dH_4O-G6C0UYmf3-fe05DTGW9ZI4mdaG3jz4")
		.contentType(ContentType.JSON).when().get("/user").then().log().all();
		
		
		
	}
	@Test(enabled=false)
	public void delete()
	{
		RestAssured.baseURI=url;
	JSONObject js=new JSONObject();
	given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczOGVhYzllYjcxMzAwMTc2MmE1ZDEiLCJpYXQiOjE2Njg1MjY1NzUsImV4cCI6MTY2ODYxMjk3NX0.ZyGFo64dH_4O-G6C0UYmf3-fe05DTGW9ZI4mdaG3jz4")
	.contentType(ContentType.JSON).accept(ContentType.JSON).when().
	delete("/user/6357601a8754360017c355e2").then().log().all();
		
		
	
		
	}
	@Test(enabled=false)
	public void getallproducts()
	{
		
		
		RestAssured.baseURI=url;
		JSONObject js=new JSONObject();
		
		given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczOGVhYzllYjcxMzAwMTc2MmE1ZDEiLCJpYXQiOjE2Njg1MjY1NzUsImV4cCI6MTY2ODYxMjk3NX0.ZyGFo64dH_4O-G6C0UYmf3-fe05DTGW9ZI4mdaG3jz4")
		.contentType(ContentType.JSON).accept(ContentType.JSON).when().get("/products").then().log().all();
				
		
	}
		
	
	@Test(enabled=false)
	public void creat_product()
	{
		
		RestAssured.baseURI=url;
		JSONObject js=new JSONObject();
		js.put("name", "Handbags_School");
		js.put("price", "500");
		
		
		given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczOGVhYzllYjcxMzAwMTc2MmE1ZDEiLCJpYXQiOjE2Njg1MjY1NzUsImV4cCI6MTY2ODYxMjk3NX0.ZyGFo64dH_4O-G6C0UYmf3-fe05DTGW9ZI4mdaG3jz4")
		.contentType(ContentType.JSON).accept(ContentType.JSON).body(js.toJSONString()).when().post("/products").then().log().all();
		
	}
	@Test(enabled=false)
	public void getproduct()
	{
		
		RestAssured.baseURI=url;
		JSONObject js=new JSONObject();
		given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczOGVhYzllYjcxMzAwMTc2MmE1ZDEiLCJpYXQiOjE2Njg1MjY1NzUsImV4cCI6MTY2ODYxMjk3NX0.ZyGFo64dH_4O-G6C0UYmf3-fe05DTGW9ZI4mdaG3jz4")
		.contentType(ContentType.JSON).accept(ContentType.JSON).when().get("/products/63746a0a347b900017d6fde2").then().log().all();
				
			
	}
	
	@Test(enabled=false)
	public void update_product()
	{
		
		RestAssured.baseURI=url;
		JSONObject js=new JSONObject();
		js.put("name", "Handbags_School");
		js.put("price", 1000);
		
		given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczOGVhYzllYjcxMzAwMTc2MmE1ZDEiLCJpYXQiOjE2Njg1MjY1NzUsImV4cCI6MTY2ODYxMjk3NX0.ZyGFo64dH_4O-G6C0UYmf3-fe05DTGW9ZI4mdaG3jz4")
		.contentType(ContentType.JSON).accept(ContentType.JSON).body(js.toJSONString()).when().patch("/products/6374af22904d2b0017e8017c").then().log().all();
				
		
	}
	@Test(enabled=false)
	public void delete_product()
	{
		
		RestAssured.baseURI=url;
		
		//JSONObject js=new JSONObject();
		given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczOGVhYzllYjcxMzAwMTc2MmE1ZDEiLCJpYXQiOjE2Njg1MjY1NzUsImV4cCI6MTY2ODYxMjk3NX0.ZyGFo64dH_4O-G6C0UYmf3-fe05DTGW9ZI4mdaG3jz4")
		.contentType(ContentType.JSON).accept(ContentType.JSON).when().
		delete("/products/63746195347b900017d6fde1").then().log().all();
		
		
	}
	
	@Test(enabled=false)
	public void getall_orders()
	{
		
		RestAssured.baseURI=url;
		given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczOGVhYzllYjcxMzAwMTc2MmE1ZDEiLCJpYXQiOjE2Njg1MjY1NzUsImV4cCI6MTY2ODYxMjk3NX0.ZyGFo64dH_4O-G6C0UYmf3-fe05DTGW9ZI4mdaG3jz4")
		.contentType(ContentType.JSON).accept(ContentType.JSON).when().
		get("/orders").then().log().all();
		
			
		
	}
	
	
	@Test(enabled=false)
	public void creat_order()
	{
		
		RestAssured.baseURI=url;
		JSONObject js=new JSONObject();
		js.put("product", "6374af22904d2b0017e8017c");
		js.put("quantity", 100);
		
		given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczOGVhYzllYjcxMzAwMTc2MmE1ZDEiLCJpYXQiOjE2Njg1MjY1NzUsImV4cCI6MTY2ODYxMjk3NX0.ZyGFo64dH_4O-G6C0UYmf3-fe05DTGW9ZI4mdaG3jz4")
		.contentType(ContentType.JSON).accept(ContentType.JSON).body(js.toJSONString()).when().
		post("/orders").then().log().all();	
		
	}
	@Test(enabled=false)
	public void getorder_id()
	{
		RestAssured.baseURI=url;
		
		given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczOGVhYzllYjcxMzAwMTc2MmE1ZDEiLCJpYXQiOjE2Njg1MjY1NzUsImV4cCI6MTY2ODYxMjk3NX0.ZyGFo64dH_4O-G6C0UYmf3-fe05DTGW9ZI4mdaG3jz4")
		.contentType(ContentType.JSON).accept(ContentType.JSON).when().
		get("/orders/6374c33aab8672001707bbde").then().log().all();
		
	}
	
	@Test(enabled=false)
	public void update_order_id()
	{
		RestAssured.baseURI=url;
		
		JSONObject js=new JSONObject();
		js.put("product", "6374c33aab8672001707bbde");
		js.put("quantity", "1000");
		
		given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczOGVhYzllYjcxMzAwMTc2MmE1ZDEiLCJpYXQiOjE2Njg1MjY1NzUsImV4cCI6MTY2ODYxMjk3NX0.ZyGFo64dH_4O-G6C0UYmf3-fe05DTGW9ZI4mdaG3jz4")
		.contentType(ContentType.JSON).accept(ContentType.JSON).body(js.toJSONString()).when().
		patch("/orders/6373c8009eb713001762a677").then().log().all();
		
	}
	
	@Test(enabled=true)
	public void delete_order_id()
	{
		RestAssured.baseURI=url;
		
		JSONObject js=new JSONObject();
		
		
		given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczOGVhYzllYjcxMzAwMTc2MmE1ZDEiLCJpYXQiOjE2Njg1MjY1NzUsImV4cCI6MTY2ODYxMjk3NX0.ZyGFo64dH_4O-G6C0UYmf3-fe05DTGW9ZI4mdaG3jz4")
		.contentType(ContentType.JSON).accept(ContentType.JSON).when().
		delete("/orders/6374c33aab8672001707bbde").then().log().all();
		
	}
	
}
