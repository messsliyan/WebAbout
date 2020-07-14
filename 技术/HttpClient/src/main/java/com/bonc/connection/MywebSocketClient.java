package com.bonc.connection;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.plaf.multi.MultiButtonUI;

import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import com.alibaba.fastjson.JSON;

public class MywebSocketClient {
	
	  private  WebSocketClient client;
	  private  String webSokcetSessionId;
	  
	  private   String msgString = "";
	public MywebSocketClient(String clientUrl) {
		super();
		try {
			URI url=new URI("ws://172.16.125.80:8080/DBService/csInstallWebSocket");
		} catch (URISyntaxException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		 try {
	            client = new WebSocketClient(new URI("ws://172.16.125.80:8080/DBService/csInstallWebSocket"),new Draft_6455()) {
	                @Override
	                public void onOpen(ServerHandshake serverHandshake) {
	                	System.out.println("握手成功");
	                	
	                	
	                }
	 
	                @Override
	                public void onMessage(String msg) {               	
	                
//	                	System.out.println(msg);
	             	 
	                	Map maps = (Map)JSON.parse(msg);  
	                	
	                	webSokcetSessionId=(String) maps.get("webSokcetSessionId");
	            		
	                	
	                	 
	                	 if (!"".equals( maps.get("message"))|| maps.get("message")!=null) {
	                		  msgString+=(String) maps.get("message");

						} 
	                	              	
	                	if(msg.equals("over")){
	                		 client.close();
	                	 }
	                	 
	                }
	 
	                @Override
	                public void onClose(int i, String s, boolean b) {
//	                	 logger.info("链接已关闭");
	                	System.out.println("链接已关闭");
	                }
	 
	                @Override
	                public void onError(Exception e){
	                    e.printStackTrace();
//	                    logger.info("发生错误已关闭");
	                    System.out.println("发生错误已关闭");
	                }
	            };
	        } catch (URISyntaxException e) {
	            e.printStackTrace();
	        }
	 
	        client.connect();
//	        System.out.println(client.getDraft());
	       while(!client.getReadyState().equals(WebSocket.READYSTATE.OPEN)){
//	    	   logger.info("正在连接...");
	    	   System.out.println("正在连接...");
	        }
	       //连接成功,发送信息
////		client.send("test");
//			int i=1000;
//			while(flag) {
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				if(!webSokcetSessionId.equals("")) {
//					flag = false;
//				}
//			}
	}
	//服务器已经发回了 webSokcetSessionId 可以进行获取数据了
	public  String getwebSokcetSessionId() throws InterruptedException {
//		System.out.println(client);
		if (client != null) {
			while (true) {
			Thread.sleep(1000);
//			System.out.println(webSokcetSessionId+"12");
			if(!webSokcetSessionId.equals("")) {
				return webSokcetSessionId;
			}
		}
		}
		return "";
		
		
	}
	
	//返回日志meg
	public  String getMsg() {
//		if (webSokcetSessionId ==null||"".equals(webSokcetSessionId)) {
//			return "";
//		}
		
		return msgString;
		
		
	}
	
	public void close() {
		if (client != null) {
			client.close();
		}
		
	}
	
	
	  public static void main(String[] args) {
			try {
				MywebSocketClient mywebSocketClient=new MywebSocketClient("ws://172.16.125.80:8080/DBService/csInstallWebSocket");
		   		
				Map<String, String> params = new HashMap<String, String>();
		   		params.put("clusterId", "4");	
		   		params.put("webSocketSessionId", mywebSocketClient.getwebSokcetSessionId());
		   		
		   		
//		   		HttpUtil.postRequest(url,"executePurge", params);
		   		String restule=HttpUtil.postRequest("http://"
		   				+ "172.16.125.80" + ":"
		   				+ "8080"
		   				+ "/DBService/xcloud/MigrationData","executePurge", params);
		   		
		   		//应该自己开一个线程来获取日志数据 不应该和进度条同步
		   		
		   		String meg="";
		   		while (true) {
		   			Thread.sleep(100);
		   			//新的日志字符串
		   			String Newmeg=mywebSocketClient.getMsg();
		
		   			if (Newmeg==null||Newmeg==""||meg.equals(Newmeg)) {
						continue;
					} 
		   			meg=Newmeg;
		   			System.out.println(meg);
		   			
				}
		   		
		   		
//		   		client.close();
		   		
		   	} catch (Exception e) {
		   		// TODO 自动生成的 catch 块
		   		e.printStackTrace();
		   	}

	    }
	
	  
}
