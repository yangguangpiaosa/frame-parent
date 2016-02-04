package com.ibm.dst.frame.jfinal.common.config;

import com.ibm.dst.frame.jfinal.common.controller.InitController;
import com.ibm.dst.frame.jfinal.common.interceptor.GlobalInterceptor;
import com.ibm.dst.frame.jfinal.user.model.User;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;

public class Config extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
		me.setDevMode(true);
	}

	@Override
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		me.add("/", InitController.class);
		me.add(new FrontRoutes());
		me.add(new AdminRoutes());
	}

	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub
		/*loadPropertyFile("database.properties");
		C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbcurl"), getProperty("username"), getProperty("password"));
		me.add(c3p0Plugin);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
		arp.addMapping("user", User.class);*/
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		me.add(new GlobalInterceptor());
	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub

	}

}
