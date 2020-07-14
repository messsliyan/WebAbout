package com.bonc.connection;

import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.messaging.MappingFastJsonMessageConverter;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
 
 
public class WebsocketClient {
	
	public final static String url = "http://"
			+ "172.16.125.80" + ":"
			+ "8080"
			+ "/DBService/xcloud/MigrationData";
    public static WebSocketClient client;
    public static String msggood;
    public static void main(String[] args) {
    	
        try {
            client = new WebSocketClient(new URI("ws://172.16.125.80:8080/DBService/csInstallWebSocket"),new Draft_6455()) {
                @Override
                public void onOpen(ServerHandshake serverHandshake) {
                	System.out.println("握手成功");
                	
                	
                }
 
                @Override
                public void onMessage(String msg) {
                	
                
System.out.println(msg);
             	 
                	Map maps = (Map)JSON.parse(msg);  
                	
                	msggood=(String) maps.get("webSokcetSessionId");
            		
                	String msgString=(String) maps.get("message");
                	if (msgString!=null) {
						System.out.println(msgString);
					}
                	
                	
                	if(msg.equals("over")){
                		 client.close();
                	 }
                	 
                }
 
                @Override
                public void onClose(int i, String s, boolean b) {
//                	 logger.info("链接已关闭");
                	System.out.println("链接已关闭");
                }
 
                @Override
                public void onError(Exception e){
                    e.printStackTrace();
//                    logger.info("发生错误已关闭");
                    System.out.println("发生错误已关闭");
                }
            };
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
 
        client.connect();
//        System.out.println(client.getDraft());
       while(!client.getReadyState().equals(WebSocket.READYSTATE.OPEN)){
//    	   logger.info("正在连接...");
    	   System.out.println("正在连接...");
        }
       //连接成功,发送信息
//	client.send("test");
       
       boolean flag = true;
		int i=1000;
		while(flag) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!msggood.equals("")) {
				flag = false;
			}
		}
		
//		System.out.println("good");
   	try {

   		Map<String, String> params = new HashMap<String, String>();
   		params.put("clusterId", "4");
   		params.put("webSocketSessionId", msggood);
   		
//   		HttpUtil.postRequest(url,"executePurge", params);
   		String restule=HttpUtil.postRequest(url,"executePurge", params);
   		
//   		client.close();
   		
   	} catch (Exception e) {
   		// TODO 自动生成的 catch 块
   		e.printStackTrace();
   	}

    }
	
}

