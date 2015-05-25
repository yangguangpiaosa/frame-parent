package com.ibm.dst.frame.ssm.common.base.model;

public class OperateBean extends BaseModel {
	
	private static final long serialVersionUID = 6678323515186196516L;
    private String operateUser = null;
    private String operateInfo = null;
    private String operateClass = null;
    private String operateMethod = null;
    private String operateParamsDes = null;
    
    public String getOperateUser() {
        return operateUser;
    }
    public void setOperateUser(String operateUser) {
        this.operateUser = operateUser;
    }
    public String getOperateInfo() {
        return operateInfo;
    }
    public void setOperateInfo(String operateInfo) {
        this.operateInfo = operateInfo;
    }
    public String getOperateClass() {
        return operateClass;
    }
    public void setOperateClass(String operateClass) {
        this.operateClass = operateClass;
    }
    public String getOperateMethod() {
        return operateMethod;
    }
    public void setOperateMethod(String operateMethod) {
        this.operateMethod = operateMethod;
    }
    public String getOperateParamsDes() {
        return operateParamsDes;
    }
    public void setOperateParamsDes(String operateParamsDes) {
        this.operateParamsDes = operateParamsDes;
    }
    
}
