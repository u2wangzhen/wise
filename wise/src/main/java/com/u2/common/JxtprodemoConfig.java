package com.u2.common;

import java.sql.Connection;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.json.MixedJsonFactory;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.druid.DruidStatViewHandler;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import com.u2.common.FieldDirective;
import com.u2.wise.SutraRoutes;
import com.u2.wise.model._MappingKit;

/**
 * JxtprodemoConfig
 */
public class JxtprodemoConfig extends JFinalConfig {
	
	private static Prop p = loadConfig();
	private WallFilter wallFilter;
	@SuppressWarnings("unused")
	private Engine engine;
	
	private static Prop loadConfig() {
		try {
			// 优先加载生产环境配置文件
			return PropKit.use("config_pro.properties");
		} catch (Exception e) {
			// 找不到生产环境配置文件，再去找开发环境配置文件
			return PropKit.use("config_dev.properties");
		}
	}
	
	/**
	 * 配置JFinal常量
	 */
	@Override
	public void configConstant(Constants me) {
		//读取数据库配置文件
		//设置当前是否为开发模式
		me.setDevMode(true);
		//设置默认上传文件保存路径 getFile等使用
		me.setBaseUploadPath("/upload/temp/");
		//设置上传最大限制尺寸
		//me.setMaxPostSize(1024*1024*10);
		//设置默认下载文件路径 renderFile使用
		me.setBaseDownloadPath("download");
		//设置默认视图类型
		me.setViewType(ViewType.JFINAL_TEMPLATE);
		//设置404渲染视图
		//me.setError404View("404.html");
		//设置json工厂
		me.setJsonFactory(MixedJsonFactory.me());
		
		//Global Pages
        me.setErrorView(400, "/html/errors/error_400.html");
        me.setError403View("/html/errors/error_403.html");
        me.setError404View("/html/errors/error_404.html");
        me.setError500View("/html/errors/error_500.html");
	}
	/**
	 * 配置JFinal路由映射
	 */
	@Override
	public void configRoute(Routes me) {
	    me.add(new SutraRoutes());
	}
	/**
	 * 配置JFinal插件
	 * 数据库连接池
	 * ORM
	 * 缓存等插件
	 * 自定义插件
	 */
	@Override
	public void configPlugin(Plugins me) {
		//配置数据库连接池插件
		DruidPlugin dbPlugin = getDruidPlugin();
        wallFilter = new WallFilter();              // 加强数据库安全
        wallFilter.setDbType("mysql");
        dbPlugin.addFilter(wallFilter);
        dbPlugin.addFilter(new StatFilter());    // 添加 StatFilter 才会有统计数据
        me.add(dbPlugin);

		//orm映射 配置ActiveRecord插件
		ActiveRecordPlugin arp=new ActiveRecordPlugin(dbPlugin);
		arp.setTransactionLevel(Connection.TRANSACTION_READ_COMMITTED);
        arp.setShowSql(true);
		arp.setDialect(new MysqlDialect());
       	arp.setBaseSqlTemplatePath(PathKit.getRootClassPath()+"/sql");
		arp.addSqlTemplate("all_sqls.sql");
        /********在此添加数据库 表-Model 映射*********/
        _MappingKit.mapping(arp);
        //添加到插件列表中
		arp.getEngine().addDirective("field", FieldDirective.class);
        me.add(arp);
	}
	/**
	 * 配置全局拦截器
	 */
	@Override
	public void configInterceptor(Interceptors me) {

	}
	/**
	 * 配置全局处理器
	 */
	@Override
	public void configHandler(Handlers me) {
		me.add(new ContextPathHandler());
	    me.add(new DruidStatViewHandler("/druid"));
	}
	
	/**
	 * 配置模板引擎 
	 */
	@Override
	public void configEngine(Engine me) {
		this.engine = me;
		me.addSharedFunction("/WEB-INF/pages/comm/layout_admin.html");
	}

	public static DruidPlugin getDruidPlugin() {
		return new DruidPlugin(p.get("jdbcUrl"), p.get("user"), p.get("password"));
	}
	
	@Override
	public void afterJFinalStart() {

	}
}