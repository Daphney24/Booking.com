package com.test;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.test.TestBase;
import com.client.test.RestClient;
import com.data.test.Owner;
import com.data.test.Pets;
import com.data.test.Type;
import com.data.test.Visits;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PostAPITest extends TestBase{
	TestBase testBase;
	RestClient restClient;
	String serviceUrl;
	String apiUrl;
	String url;
	CloseableHttpResponse closeableHttpResponse;

	@BeforeMethod
	public void setup() throws ClientProtocolException, IOException {
		testBase = new TestBase();
		serviceUrl = prop.getProperty("URL");
		apiUrl = prop.getProperty("serviceURL");
		url = serviceUrl + apiUrl;	
	}

	@Test
	public void postAPITest() throws ClientProtocolException, IOException, JSONException {
		restClient = new RestClient();
		
		//Header
		HashMap<String,String> headerMap = new HashMap<String,String>();
		headerMap.put("Content-Type", "application/json");

		//Jackson API
		ObjectMapper mapper= new ObjectMapper();
		Type type = new Type(123,"cat");
		Owner owner = new Owner(1,"George","Franklin","110 W. Liberty St","Madison","6085551023");
		Visits visits = new Visits(1,"2013/01/04","spayed",7);
		Pets pets = new Pets("","Leo","2010/09/07",type,owner,visits);
		
		//Convert object to JSON file
		mapper.writeValue(new File("./src/test/java/com/data/test/pets.json"), pets);
		System.out.println("Object copied over to JSON file. Please check there ");
		
		//Object to JSONS in string
		String petsJsonString = mapper.writeValueAsString(pets);
		System.out.println(petsJsonString);
		closeableHttpResponse = restClient.post(url, petsJsonString, headerMap);
		System.out.println(closeableHttpResponse);
		
		//Check status code
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals("Status Code is not 201", RESPONSE_STATUS_CODE_201,statusCode);
		
		//Check JSONString
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
		JSONArray responseJson = new JSONArray(responseString);
		System.out.println("The Response form the API is: "+responseJson);
	}
}
