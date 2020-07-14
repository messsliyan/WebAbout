package com.bonc.connection;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Test3 {
	public final static String url = "http://"
			+ "172.16.125.80" + ":"
			+ "8080"
			+ "/DBService/xcloud/MigrationData";
	static boolean Connect() {
		
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpPost request = new HttpPost(url);
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			
			request.setEntity(new UrlEncodedFormEntity(nvps, StandardCharsets.UTF_8));
			HttpResponse response = client.execute(request);
			int code = response.getStatusLine().getStatusCode();
			if(code == HttpStatus.SC_OK) 
				return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	void Close(){
		
	}
	public static void main(String[] args) {
		try {
			
			Map<String, String> params = new HashMap<String, String>();
			params.put("clusterId", "4");
			params.put("webSocketSessionId", "12345");
			
			System.out.println(HttpUtil.postRequest(url,"executePurge", params));
			String restule=HttpUtil.postRequest(url,"executePurge", params);
			
//			//str 转map
//			Map maps = (Map)JSON.parse(restule);  
//			
//			String tree= maps.get("treeNodes").toString();
//			System.err.println(maps);
//			
//			//得到key
//		
//			List<TreeNode> treeNode=JSONObject.parseArray(tree, TreeNode.class);	
//			
//			for (TreeNode treeNode2 : treeNode) {
//				System.out.println(treeNode);
//			}
			
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
