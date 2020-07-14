package com.bonc.connection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
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
import com.thinkgem.jeesite.modules.tnsApi.Dto.HiveDto;
import com.thinkgem.jeesite.modules.tnsApi.Dto.MySqlDto;
import com.thinkgem.jeesite.modules.tnsApi.Dto.OracleDto;
import com.thinkgem.jeesite.modules.tnsApi.Dto.XcloudDto;

public class Test01 {
	
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
	
	public static void testMysql() {
		MySqlDto mySqlDto = new MySqlDto();
		mySqlDto.setSid("hongtao");
		mySqlDto.setProtocol("bbbbbbbbbbbbbbbb");
		mySqlDto.setHost("172.16.44.35");
		mySqlDto.setPort("12345");
		mySqlDto.setSchema("schme");
		
		JSONObject object = (JSONObject) JSONObject.toJSON(mySqlDto);
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("clusterId", "1");
		params.put("category", "MYSQL");
		params.put("mySql", object.toString());
		params.put("sid", "hongtao");
		/*try {
			System.out.println(post("http://172.16.44.36:9372/DBService/deleteTnsInfo", params));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
	
	public static void testHive() {
		HiveDto hiveDto = new HiveDto();
		hiveDto.setSid("hongtao");
		hiveDto.setAuthentication("test finish");
		hiveDto.setHost("172.16.44.36");
		hiveDto.setDatabase("o23456o");
		hiveDto.setPort("12345");
		
		JSONObject object = (JSONObject) JSONObject.toJSON(hiveDto);
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("clusterId", "27");
		params.put("category", "hive");
//		params.put("hive", object.toString());
		params.put("sid", "hongtao");
		try {//insertTnsInfo  deleteTnsInfo  updateTnsInfo
			System.out.println(post("http://localhost:8080/DBService/deleteTnsInfo", params));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void testXcloud() {
		XcloudDto xcloudDto = new XcloudDto();
		xcloudDto.setSid("hongtao");
		xcloudDto.setDatabase_name("taotaotaototaotoaot");
		xcloudDto.setHost("34.16adfg.44.36");
		xcloudDto.setPort("123sgf1");
		xcloudDto.setUser("longtsdfgao");
		xcloudDto.setPassword("00asdf00");
		
		JSONObject object = (JSONObject) JSONObject.toJSON(xcloudDto);
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("clusterId", "1");
		params.put("category", "xcloud");
//		params.put("xcloud", object.toString());
		params.put("sid", "hongtao");
		try {//insertTnsInfo  deleteTnsInfo  updateTnsInfo
			
//			System.out.println(post("http://172.16.12.163:9372/DBService/deleteTnsInfo", params));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void testOracle() {
		OracleDto oracleDto = new OracleDto();
		oracleDto.setServiceName("hongtao");
		oracleDto.setContent("  (DESCRIPTION ="+
    "aksfbdnf");
		JSONObject object = (JSONObject) JSONObject.toJSON(oracleDto);
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("clusterId", "27");
		params.put("category", "oracle");
//		params.put("oracle", object.toString());
		params.put("serviceName", "hongtao");
		try {//insertTnsInfo  deleteTnsInfo  updateTnsInfo
			System.out.println(post("http://172.16.14:9372/DBService/deleteTnsInfo", params));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void testMigraqtion() {
		Db[] dbs=new Db[] {};
		MigrationCfgDto migrationCfgDto=new MigrationCfgDto(
				"4",false,false,false,
				"", "", 
				"","", 
				"", "",
				"", "",
				 "", "",
				 "", "",
				 "",dbs,false,false,false,false,false,false,false,0,false
				);
		
		JSONObject object = (JSONObject) JSONObject.toJSON(migrationCfgDto);
		Map<String,Object> params = new HashMap<String, Object>();
		
		params.put("migrationCfgDto", object.toString());
		try {//insertTnsInfo  deleteTnsInfo  updateTnsInfo
			System.out.println(post("http://172.16.125.80:8080/DBService/xcloud/MigrationData/executeMigrationCS", params));	
//			System.out.println(post("http://172.16.44.34:9372/DBService/xcloud/MigrationData/executeMigration", params));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Map<String, Object> getMigration(String clusterId) {
		// TODO 自动生成的方法存根

//		Map<String, Object> rest = new HashMap<String, Object>();
//		try {
//			
			Map<String, Object> params = new HashMap<String, Object>();
		
			params.put("clusterId", clusterId);
			params.put("type", "集群");
//			params.put("migrationSize", newmigrationSize);
//			params.put("currentTime", newcurrentTime);
			System.out.println(post("http://172.16.125.80:8080/DBService/xcloud/MigrationData/getMigrationLog", params));	
//			String resultString = HttpUtil.postRequest("http://172.16.125.80:8080/DBService","xcloud/MigrationData/getMigrationInfo", params);
//			
//			if (resultString.contains(" timed out")) {
//			
//				throw new Exception("Proxy Server Connection timed out");
//			} else {
//				Map maps = (Map)JSON.parse(resultString);  
//
//				System.out.println(resultString);
//				
//
//			}	 
//		
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
		return null;
			
	}
	public static Map<String, Object> getMigrationInfo(String clusterId) {
		// TODO 自动生成的方法存根

		Map<String, Object> rest = new HashMap<String, Object>();
	
			
			Map<String, Object> params = new HashMap<String, Object>();
		
			params.put("clusterId", clusterId);
//			params.put("type", type);
//			params.put("currentTime", newcurrentTime);
		
			String i=post("http://172.16.125.80:8080/DBService/xcloud/MigrationData/getMigrationInfo", params);
			
			System.out.println(i);	
			
				

			return null;
			
	}
	public static Map<String, Object> checkXCloudLock(String clusterId) {
		// TODO 自动生成的方法存根

		Map<String, Object> rest = new HashMap<String, Object>();
	
			
			Map<String, Object> params = new HashMap<String, Object>();
		
			params.put("clusterId", clusterId);
//			params.put("type", type);
//			params.put("currentTime", newcurrentTime);
		
			String i=post("http://172.16.44.34:9372/DBService/xcloud/MigrationData/checkXCloudLock", params);
			
			System.out.println(i);	
			
				

			return null;
			
	}
	public static void main(String[] args) {
//		testMigraqtion();
////		boolean isPurgeEnd=false;
//		{
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO 自动生成的 catch 块
//				e.printStackTrace();
//			}
//			Map<String, Object>  rest=getMigration("4");
//			Map<String, Object>  rest2=getMigrationInfo("4");
//		} while(true);
		
//		for (int i = 0; i < 10; i++) {
//
		checkXCloudLock("4");
//		testMysql();
	}
}
