package com.ibm.dst.frame.ssm.common.util;

import java.util.ResourceBundle;

public class PropertiesUtil {

    private static PropertiesUtil propertiesUtil = null;
    
    private PropertiesUtil() {
        
    }
    
    public static PropertiesUtil getInstance() {
        if(null == propertiesUtil) {
            propertiesUtil = new PropertiesUtil();
        }
        return propertiesUtil;
    }
    
    public String getFilePath(String proPath, String nameKey) {
        String propValue = "";
        
        ResourceBundle bundle = ResourceBundle.getBundle(proPath);
        propValue = bundle.getString(nameKey);
        
        return propValue;
    }
}
