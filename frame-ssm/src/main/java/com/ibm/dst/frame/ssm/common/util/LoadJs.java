package com.ibm.dst.frame.ssm.common.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class LoadJs {

    public static void main(String[] args) throws IOException {
	try {
	    ScriptEngineManager sem = new ScriptEngineManager();
	    ScriptEngine engine = sem.getEngineByExtension("js");
	    
	    //ResourceBundle bundle = ResourceBundle.getBundle("com.greenbird.system-config");
	    //String rootPath = bundle.getString("JsFileRootPath");
	    //String filePath = bundle.getString("testJsFilePath");
	    System.getProperties().load(new FileReader(new File("com/supersystem/manager/property/common/system-config.properties")));
	    String rootPath = System.getProperties().getProperty("JsFileRootPath");
	    String filePath = System.getProperties().getProperty("testJsFilePath");
	    
	    engine.eval(new FileReader(new File(rootPath + filePath)));
	    Invocable inv = (Invocable) engine;
	    String str = String.valueOf(inv.invokeFunction("sayHello",new Object[]{new String("Tom")}));
	    System.out.println(str);
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (ScriptException e) {
	    e.printStackTrace();
	} catch (NoSuchMethodException e) {
	    e.printStackTrace();
	}
    }

}
