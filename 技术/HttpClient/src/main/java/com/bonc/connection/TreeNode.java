package com.bonc.connection;



public class TreeNode {

	private int id;//id
    private int pId;//父id
    private String name;//名称： 集群名、用户名、数据库名、表名
    private int isParent;//是不是父节点
    private String icon;//图标的路径
    private boolean chkDisabled;//是否可用
    private int type;//1-集群；2-数据库；3-用户；4-表
	public TreeNode() {
		super();
	}
	public TreeNode(int id, int pId, String name, int type) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIsParent() {
		return isParent;
	}
	public void setIsParent(int isParent) {
		this.isParent = isParent;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public boolean isChkDisabled() {
		return chkDisabled;
	}
	public void setChkDisabled(boolean chkDisabled) {
		this.chkDisabled = chkDisabled;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "TreeNode [id=" + id + ", pId=" + pId + ", name=" + name + ", isParent=" + isParent + ", icon=" + icon
				+ ", chkDisabled=" + chkDisabled + ", type=" + type + "]";
	}
	
}
