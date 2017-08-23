package com.jk.model;

/**
 * 远端方法的url和module信息
 */
public class ModuleModel {
    /**
     * 唯一id
     */
    private String uuid;
    /**
     * 模块id
     */
    private String moduleId;
    /**
     * 模块名字
     */
    private String moduleName;
    /**
     * 远端服务器ip
     */
    private String deployIP;
    /**
     * 远端服务器端口
     */
    private String deployPort;
    /**
     * 调用的url
     */
    private String intereractiveUrl;
    /**
     * 依赖，可有可无
     */
    private String depends;

    public ModuleModel(String uuid, String moduleId, String moduleName, String deployIP, String deployPort, String intereractiveUrl, String depends) {
        this.uuid = uuid;
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.deployIP = deployIP;
        this.deployPort = deployPort;
        this.intereractiveUrl = intereractiveUrl;
        this.depends = depends;
    }

    public ModuleModel() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getDeployIP() {
        return deployIP;
    }

    public void setDeployIP(String deployIP) {
        this.deployIP = deployIP;
    }

    public String getDeployPort() {
        return deployPort;
    }

    public void setDeployPort(String deployPort) {
        this.deployPort = deployPort;
    }

    public String getIntereractiveUrl() {
        return intereractiveUrl;
    }

    public void setIntereractiveUrl(String intereractiveUrl) {
        this.intereractiveUrl = intereractiveUrl;
    }

    public String getDepends() {
        return depends;
    }

    public void setDepends(String depends) {
        this.depends = depends;
    }
}
