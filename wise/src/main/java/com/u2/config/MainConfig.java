package com.u2.config;

import java.sql.Connection;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.UrlSkipHandler;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;
import com.u2.common.FieldDirective;
import com.u2.common.GlobalHandler;
import com.u2.common.IfLoginInterceptor;
import com.u2.wise.controller.LoginController;
import com.u2.wise.controller.MainController;
import com.u2.wise.controller.StudentController2;
import com.u2.wise.model.Student;
import com.u2.wise.model._MappingKit;

public class MainConfig extends JFinalConfig {

	private WallFilter wallFilter;

	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
		PropKit.use("config.properties");
		me.setDevMode(PropKit.getBoolean("devMode"));
		me.setBaseUploadPath("upload/");
		me.setMaxPostSize(1024 * 1024 * 10);
	}

	@Override
	public void configEngine(Engine me) {
		// TODO Auto-generated method stub
	}

	@Override
	public void configHandler(Handlers handler) {
		// TODO Auto-generated method stub
		handler.add(new UrlSkipHandler(
				"/|/admin/friendchat/.*|/ca/.*|/se/.*|.*.htm|.*.html|.*.js|.*.css|.*.json|.*.png|.*.gif|.*.jpg|.*.jpeg|.*.bmp|.*.ico|.*.exe|.*.txt|.*.zip|.*.rar|.*.7z|.*.tff|.*.woff|.*.ttf|.*.map",
				false));
		handler.add(new GlobalHandler());
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		me.add(new IfLoginInterceptor());// 判断是否登录拦截器
	}

	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub
		DruidPlugin dp = new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password"));
		wallFilter = new WallFilter(); // 加强数据库安全
		wallFilter.setDbType("mysql");
		dp.addFilter(wallFilter);
		dp.addFilter(new StatFilter());
		me.add(dp);

		ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
		arp.setTransactionLevel(Connection.TRANSACTION_READ_COMMITTED);
		arp.setShowSql(true);
		arp.setDialect(new MysqlDialect());
		arp.setBaseSqlTemplatePath(PathKit.getRootClassPath() + "/sql");
		arp.addSqlTemplate("all_sqls.sql");
		_MappingKit.mapping(arp);
		arp.getEngine().addDirective("field", FieldDirective.class);
		me.add(arp);

	}

	@Override
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		me.setBaseViewPath("/");
		me.add("/login", LoginController.class);
		me.add("/student", StudentController2.class);
		me.add("/main", MainController.class);
	}

}
