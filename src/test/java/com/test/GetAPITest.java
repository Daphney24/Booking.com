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

public class GetAPITest extends TestBase {

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
	public void getAPITest() throws ClientProtocolException, IOException, JSONException {
		restClient = new RestClient();
		closeableHttpResponse = restClient.get(url);

		//Getting status code
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code is: "+statusCode);

		//getting response string
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
		JSONArray responseJson = new JSONArray(responseString);
		System.out.println("Response JSON from api: "+responseJson);
		Assert.assertNotNull(responseJson);
		Assert.assertEquals("Status Code is not 200",statusCode, RESPONSE_STATUS_CODE_200);

		//getting all headers
		Header[] headersArray = closeableHttpResponse.getAllHeaders();
		HashMap<String,String> allHeaders =  new HashMap<String,String>();

		for(Header header : headersArray) {
			allHeaders.put(header.getName(), header.getValue());		
		}

		System.out.println("Headers Array: "+allHeaders);
	}
}
