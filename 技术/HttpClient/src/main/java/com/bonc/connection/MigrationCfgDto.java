package com.bonc.connection;



import java.util.Arrays;
import java.util.List;

/**
 * 接收迁移web数据的实体类,迁移配置
 * @author wht
 *
 */
public class MigrationCfgDto {
	private String clusterId;
	private boolean lock;
	private boolean migrationType;  //迁移的类型
	private boolean whetherCrossHadoop;//是否迁移hadoop集群
	private boolean whetherKerbersAuthentication;//是否kerbers认证
	private String targetXcloudRoot;//目标集群的根目录
	private String dbName;//目标集群的名称
	private String zookeeper;//  目标集群zookeeper地址
	private String namenode;//  目标集群hdfs namenode服务地址
	private String user;//  目标集群hdfs supergroup user
	private String kerb_keytab_file;//   目标集群kerb_keytab_file配置项的值
	private String kerb_principal;//  目标集群kerb_principal配置项的值
	private String hdfs_site_file;//hdfs_site_file文件的保存路径
	private String core_site_file;//core_site_file文件的保存路径
	private String target_host_address;//目标集群存放kerbers认证文件的主机地址
	private String target_host_username;//目标集群存放kerbers认证文件的主机连接用户名
	private String target_host_password;//目标集群存放kerbers认证文件的主机连接密码
	private String kerb_debug_file;//   目标集群kerb_debug_file配置项的值
	private Db[] dbs;   //接收前台json串，对象选择
	private boolean increase;   //增量迁移(0代表是，1代表否)
	private boolean confirmRollback;   //是否回滚
	private boolean confirmContinue;   //是否回滚
	private boolean mandatory;   //是否强制执行(0代表是，1代表否)
	private boolean tolerance;   //是否容错执行(0代表是，1代表否)
	private boolean cover;		//是否覆盖迁移(0代表是，1代表否)
	private boolean openRetainInfo;   //是否开启留存信息选项
	private int concurrency; //指定并发数
	
	public MigrationCfgDto() {
		super();
	}

	
	public MigrationCfgDto(String clusterId, boolean migrationType, boolean whetherCrossHadoop,
			boolean whetherKerbersAuthentication, String targetXcloudRoot, String dbName, String zookeeper,
			String namenode, String user, String kerb_keytab_file, String kerb_principal, String hdfs_site_file,
			String core_site_file, String target_host_address, String target_host_username, String target_host_password,
			String kerb_debug_file, Db[] dbs, boolean increase, boolean confirmRollback, boolean confirmContinue,
			boolean mandatory, boolean tolerance, boolean cover, boolean openRetainInfo, int concurrency,
			boolean lock) {
		super();
		this.clusterId = clusterId;
		this.migrationType = migrationType;
		this.whetherCrossHadoop = whetherCrossHadoop;
		this.whetherKerbersAuthentication = whetherKerbersAuthentication;
		this.targetXcloudRoot = targetXcloudRoot;
		this.dbName = dbName;
		this.zookeeper = zookeeper;
		this.namenode = namenode;
		this.user = user;
		this.kerb_keytab_file = kerb_keytab_file;
		this.kerb_principal = kerb_principal;
		this.hdfs_site_file = hdfs_site_file;
		this.core_site_file = core_site_file;
		this.target_host_address = target_host_address;
		this.target_host_username = target_host_username;
		this.target_host_password = target_host_password;
		this.kerb_debug_file = kerb_debug_file;
		this.dbs = dbs;
		this.increase = increase;
		this.confirmRollback = confirmRollback;
		this.confirmContinue = confirmContinue;
		this.mandatory = mandatory;
		this.tolerance = tolerance;
		this.cover = cover;
		this.openRetainInfo = openRetainInfo;
		this.concurrency = concurrency;
		this.lock = lock;
	}


	public boolean isMigrationType() {
		return migrationType;
	}


	public void setMigrationType(boolean migrationType) {
		this.migrationType = migrationType;
	}


	public boolean isConfirmRollback() {
		return confirmRollback;
	}


	public void setConfirmRollback(boolean confirmRollback) {
		this.confirmRollback = confirmRollback;
	}


	public boolean isConfirmContinue() {
		return confirmContinue;
	}


	public void setConfirmContinue(boolean confirmContinue) {
		this.confirmContinue = confirmContinue;
	}


	public String getClusterId() {
		return clusterId;
	}

	public void setClusterId(String clusterId) {
		this.clusterId = clusterId;
	}

	public boolean isWhetherCrossHadoop() {
		return whetherCrossHadoop;
	}

	public void setWhetherCrossHadoop(boolean whetherCrossHadoop) {
		this.whetherCrossHadoop = whetherCrossHadoop;
	}

	public boolean isWhetherKerbersAuthentication() {
		return whetherKerbersAuthentication;
	}

	public void setWhetherKerbersAuthentication(boolean whetherKerbersAuthentication) {
		this.whetherKerbersAuthentication = whetherKerbersAuthentication;
	}

	public String getTargetXcloudRoot() {
		return targetXcloudRoot;
	}

	public void setTargetXcloudRoot(String targetXcloudRoot) {
		this.targetXcloudRoot = targetXcloudRoot;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getZookeeper() {
		return zookeeper;
	}

	public void setZookeeper(String zookeeper) {
		this.zookeeper = zookeeper;
	}

	public String getNamenode() {
		return namenode;
	}

	public void setNamenode(String namenode) {
		this.namenode = namenode;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getKerb_keytab_file() {
		return kerb_keytab_file;
	}

	public void setKerb_keytab_file(String kerb_keytab_file) {
		this.kerb_keytab_file = kerb_keytab_file;
	}

	public String getKerb_principal() {
		return kerb_principal;
	}

	public void setKerb_principal(String kerb_principal) {
		this.kerb_principal = kerb_principal;
	}

	public String getHdfs_site_file() {
		return hdfs_site_file;
	}

	public void setHdfs_site_file(String hdfs_site_file) {
		this.hdfs_site_file = hdfs_site_file;
	}

	public String getCore_site_file() {
		return core_site_file;
	}

	public void setCore_site_file(String core_site_file) {
		this.core_site_file = core_site_file;
	}

	public String getTarget_host_address() {
		return target_host_address;
	}

	public void setTarget_host_address(String target_host_address) {
		this.target_host_address = target_host_address;
	}

	public String getTarget_host_username() {
		return target_host_username;
	}

	public void setTarget_host_username(String target_host_username) {
		this.target_host_username = target_host_username;
	}

	public String getTarget_host_password() {
		return target_host_password;
	}

	public void setTarget_host_password(String target_host_password) {
		this.target_host_password = target_host_password;
	}

	public String getKerb_debug_file() {
		return kerb_debug_file;
	}

	public void setKerb_debug_file(String kerb_debug_file) {
		this.kerb_debug_file = kerb_debug_file;
	}

	public Db[] getDbs() {
		return dbs;
	}

	public void setDbs(Db[] dbs) {
		this.dbs = dbs;
	}

	public boolean isIncrease() {
		return increase;
	}

	public void setIncrease(boolean increase) {
		this.increase = increase;
	}

	public boolean isMandatory() {
		return mandatory;
	}

	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	public boolean isTolerance() {
		return tolerance;
	}

	public void setTolerance(boolean tolerance) {
		this.tolerance = tolerance;
	}

	public boolean isCover() {
		return cover;
	}

	public void setCover(boolean cover) {
		this.cover = cover;
	}

	public boolean isOpenRetainInfo() {
		return openRetainInfo;
	}

	public void setOpenRetainInfo(boolean openRetainInfo) {
		this.openRetainInfo = openRetainInfo;
	}

	public int getConcurrency() {
		return concurrency;
	}

	public void setConcurrency(int concurrency) {
		this.concurrency = concurrency;
	}


	public boolean isLock() {
		return lock;
	}


	public void setLock(boolean lock) {
		this.lock = lock;
	}

}
