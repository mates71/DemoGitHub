package restfullapi;

import static io.restassured.RestAssured.*;

import java.net.URI;

import org.junit.Assert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class RestFullApi {
	
	static String pingUrl="http://localhost:8085/laptop-bag/webapi/api/ping/Musa Bey!";
	
	public static void main(String[] args) {
		
	
		String Greeting =when().get(pingUrl).asString();
		
		System.out.println(Greeting);
	
	
		int statusCode=when().get(pingUrl).getStatusCode();
		
		System.out.println(statusCode);
	}
}
