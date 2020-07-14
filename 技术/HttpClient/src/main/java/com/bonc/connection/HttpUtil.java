package com.bonc.connection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.SSLException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;



public class HttpUtil {
	
	public static String postRequest(String url, String actionName, Map<String, String> params)
			throws Exception{
		HttpClient client = HttpClientBuilder.create().build();
		
		 String body = "";
		try{
	        //拼接url
			
			url = url+"/"+actionName ;
	        HttpPost request = new HttpPost(url);
	        
	        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
	        Set<String> keySet = params.keySet();  
	        for(String key : keySet) {  
	            nvps.add(new BasicNameValuePair(key, params.get(key)));  
	        }  
			request.setEntity(new UrlEncodedFormEntity(nvps, StandardCharsets.UTF_8));
			//发送请求
			HttpResponse response = client.execute(request);
			
			HttpEntity entity = response.getEntity();  

			body = EntityUtils.toString(entity);  
			 
		}catch(Exception e){
			//连接失败
			
			body="Proxy Server Connection timed out";
			
			throw e;
		}

//		System.out.println(body);
        return body;  
	}
		
	}
	
	
