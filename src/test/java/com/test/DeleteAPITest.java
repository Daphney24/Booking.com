package com.test;
import java.io.IOException;
import java.util.HashMap;
import org.apache.http.Header;
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


public class DeleteAPITest extends TestBase{
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
		url = serviceUrl + apiUrl+"/"+idValue;	
	}

	@Test
	public void deleteAPITest() throws ClientProtocolException, IOException, JSONException {
		restClient = new RestClient();
		closeableHttpResponse = restClient.delete(url);

		//Getting status code
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code is: "+statusCode);
		Assert.assertEquals("Status Code is not 404", RESPONSE_STATUS_CODE_404,statusCode);		
	}
}
