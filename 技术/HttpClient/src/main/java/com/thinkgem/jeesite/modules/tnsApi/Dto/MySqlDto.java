package com.thinkgem.jeesite.modules.tnsApi.Dto;

/**
 * tns配置的mysql配置文件的中转对象
 * @author hongtao
 *
 */
public class MySqlDto {
	private String sid;
	private String schema;
	private String protocol;
	private String host;
	private String port;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSchema() {
		return schema;
	}
	public void setSchema(String schema) {
		this.schema = schema;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	
	
}
