package com.bonc.connection;

/**
 * 接收迁移web表数据的实体，迁移对象的选择
 * @author wht
 *
 */
public class Db {

	private int type;
	private String sourceDb;  //元数据库名
	private String targetDb;  //目标数据库名
	private String sourceUser;  //源用户名
	private String targetUser;  //目标用户名
	private String tableName;  //表名
	
	public Db() {
		super();
	}
	
	public Db(int type, String sourceDb, String targetDb, String sourceUser, String targetUser, String tableName) {
		super();
		this.type = type;
		this.sourceDb = sourceDb; 
		this.targetDb = targetDb;
		this.sourceUser = sourceUser;
		this.targetUser = targetUser;
		this.tableName = tableName;
	}

	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getSourceDb() {
		return sourceDb;
	}
	public void setSourceDb(String sourceDb) {
		this.sourceDb = sourceDb;
	}
	public String getTargetDb() {
		return targetDb;
	}
	public void setTargetDb(String targetDb) {
		this.targetDb = targetDb;
	}
	public String getSourceUser() {
		return sourceUser;
	}
	public void setSourceUser(String sourceUser) {
		this.sourceUser = sourceUser;
	}
	public String getTargetUser() {
		return targetUser;
	}
	public void setTargetUser(String targetUser) {
		this.targetUser = targetUser;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Override
	public String toString() {
		return "Db [type=" + type + ", sourceDb=" + sourceDb + ", targetDb=" + targetDb + ", sourceUser=" + sourceUser
				+ ", targetUser=" + targetUser + ", tableName=" + tableName + "]";
	}

}
