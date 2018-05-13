package com.u2.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.UrlSkipHandler;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;
import com.u2.common.GlobalHandler;
import com.u2.common.IfLoginInterceptor;
import com.u2.wise.LoginController;
import com.u2.wise.MainController;
import com.u2.wise.model.Student;
import com.u2.wise.student.StudentController;

public class MainConfig extends JFinalConfig{

	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
		PropKit.use("config.properties");
		me.setDevMode(PropKit.getBoolean("devMode"));
		me.setBaseUploadPath("upload/");
		me.setMaxPostSize(1024*1024*10);
	}

	@Override
	public void configEngine(Engine me) {
		// TODO Auto-generated method stub
	}

	@Override
	public void configHandler(Handlers handler) {
		// TODO Auto-generated method stub
		handler.add(new UrlSkipHandler("/|/admin/friendchat/.*|/ca/.*|/se/.*|.*.htm|.*.html|.*.js|.*.css|.*.json|.*.png|.*.gif|.*.jpg|.*.jpeg|.*.bmp|.*.ico|.*.exe|.*.txt|.*.zip|.*.rar|.*.7z|.*.tff|.*.woff|.*.ttf|.*.map", false));
		handler.add(new GlobalHandler());
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		 me.add(new IfLoginInterceptor());//判断是否登录拦截器
	}

	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub
		DruidPlugin dp =new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password"));
		me.add(dp);
		
		ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
		me.add(arp);
		arp.addMapping("t_student",Student.class);
	}

	@Override
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		me.setBaseViewPath("/");
		me.add("/login", LoginController.class);
		me.add("/student", StudentController.class);
		me.add("/main", MainController.class);
	}

}
