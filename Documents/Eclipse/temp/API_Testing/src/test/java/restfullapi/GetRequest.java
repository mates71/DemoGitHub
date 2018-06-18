package restfullapi;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class GetRequest {
	
	@Test
	public void getTest() throws URISyntaxException{
		URI pingURI = new URI("http://localhost:8085/laptop-bag/webapi/api/ping/musa");
		
		Response response=when().get(pingURI);
		
		System.out.println(response.asString());
		
		Assert.assertEquals(200, response.getStatusCode());
		Assert.assertEquals("Hi! musa", response.body().asString());
		
		
	}
	@Test
	public void pingMethNoArg() throws URISyntaxException{
		URI pingURI = new URI("http://localhost:8085/laptop-bag/webapi/api/ping/");
		
		Response response=given().get(pingURI);
		System.out.println(response.asString());
		
		int staCode=given().get(pingURI).getStatusCode();
		System.out.println(staCode);
		
		Assert.assertEquals(404, response.getStatusCode());
		
	}
	
	@Test
	public void testAllMeth() throws URISyntaxException{
		
		URI UriAll = new URI("http://localhost:8085/laptop-bag/webapi/api/all");
		
		Response response=given().accept(ContentType.JSON).when().get(UriAll);
		System.out.println(response.asString());
		
		Assert.assertEquals(200, response.statusCode());
		
	}

}
