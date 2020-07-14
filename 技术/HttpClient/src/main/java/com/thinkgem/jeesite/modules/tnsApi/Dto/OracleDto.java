package com.thinkgem.jeesite.modules.tnsApi.Dto;

import java.util.List;

/**
 * oracle的tns配置的中转对象
 * @author hongtao
 *
 */
public class OracleDto {
	private String serviceName;
	private String content;
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
