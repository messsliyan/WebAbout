package com.bonc.connection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

public class Test02 {
	public static String post(String url, Map<String,Object> params){
		BufferedReader in = null;
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpPost request = new HttpPost(url);
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			for (Iterator<String> iter = params.keySet().iterator(); iter.hasNext();) {
				String key = (String) iter.next();
				String value = String.valueOf(params.get(key));
				nvps.add(new BasicNameValuePair(key, value));
			}
			request.setEntity(new UrlEncodedFormEntity(nvps, StandardCharsets.UTF_8));
			HttpResponse response = client.execute(request);
			int code = response.getStatusLine().getStatusCode();
			if(code == HttpStatus.SC_OK) {
				in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8));
				StringBuffer sb = new StringBuffer("");
				String line = "";
				String NL = System.getProperty("line.separator");
				while ((line = in.readLine()) != null) {
					sb.append(line + NL);
				}
				in.close();
				return sb.toString();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * admin/permissions/getAllRole?pageNumber=0&pageSize=10&searchRoleName=
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("str", "^(?![a-zA-z]+$)(?!\\d+$)(?![!@#$%^&*]+$)(?![a-zA-z\\d]+$)(?![a-zA-z!@#$%^&*]+$)(?![\\d!@#$%^&*]+$)[a-zA-Z\\d!@#$%^&*]+$");
		//params.put("password", "admin");
		System.out.println(post("http://localhost:8080/DBService/getString", params));
		//^(?![a-zA-z]+$)(?!\d+$)(?![!@#$%^&amp;*]+$)(?![a-zA-z\d]+$)(?![a-zA-z!@#$%^&amp;*]+$)(?![\d!@#$%^&amp;*]+$)[a-zA-Z\d!@#$%^&amp;*]+$
		//^(?![a-zA-z]+$)(?!\d+$)(?![!@#$%^&*]+$)(?![a-zA-z\d]+$)(?![a-zA-z!@#$%^&*]+$)(?![\d!@#$%^&*]+$)[a-zA-Z\d!@#$%^&*]+$
		//^(?![a-zA-z]+$)(?!\d+$)(?![!@#$%^&*]+$)(?![a-zA-z\d]+$)(?![a-zA-z!@#$%^&*]+$)(?![\d!@#$%^&*]+$)[a-zA-Z\d!@#$%^&*]+$
		//^(?![a-zA-z]+$)(?!\d+$)(?![!@#$%^&*]+$)(?![a-zA-z\d]+$)(?![a-zA-z!@#$%^&*]+$)(?![\d!@#$%^&*]+$)[a-zA-Z\d!@#$%^&*]+$
		//^(?![a-zA-z]+$)(?!\d+$)(?![!@#$%^&amp;*]+$)(?![a-zA-z\d]+$)(?![a-zA-z!@#$%^&amp;*]+$)(?![\d!@#$%^&amp;*]+$)[a-zA-Z\d!@#$%^&amp;*]+$
		//^(?![a-zA-z]+$)(?!\d+$)(?![!@#$%^&amp;*]+$)(?![a-zA-z\d]+$)(?![a-zA-z!@#$%^&amp;*]+$)(?![\d!@#$%^&amp;*]+$)[a-zA-Z\d!@#$%^&amp;*]+$
	}
}
