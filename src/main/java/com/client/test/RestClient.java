package com.client.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestClient {

	//1. Create GET method
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient= HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		httpClient.execute(httpGet); //Hitting the URL
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);
		return closeableHttpResponse;
	}

	//2. Create POST method
	public CloseableHttpResponse post(String url,String entryString, HashMap<String,String> headerMap) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient= HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new StringEntity(entryString));

		for(Map.Entry<String,String> entry : headerMap.entrySet()){
			httpPost.addHeader(entry.getKey(),entry.getValue());
		}
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpPost);
		return closeableHttpResponse;
	}

	//3. Create PUT method
	public CloseableHttpResponse put(String url,String entryString, HashMap<String,String> headerMap) throws ClientProtocolException, IOException{
		CloseableHttpClient httpClient= HttpClients.createDefault();
		HttpPut  httpPut = new HttpPut(url);
		httpPut.setEntity(new StringEntity(entryString));

		for(Map.Entry<String,String> entry : headerMap.entrySet()){
			httpPut.addHeader(entry.getKey(),entry.getValue());
		}
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpPut);
		return closeableHttpResponse;
	}

	//4. Create Delete method
	public CloseableHttpResponse delete(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient= HttpClients.createDefault();
		HttpDelete httpDelete = new HttpDelete(url);
		httpClient.execute(httpDelete); //Hitting the URL
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpDelete);
		return closeableHttpResponse;
	}
}
