package com.rwt.helper;

import com.rwt.util.PropsUtil;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public final class DataBaseHelper {
    private  static final Logger logger=LoggerFactory.getLogger(DataBaseHelper.class);
    private static  final String Driver;
    private  static final String URL;
    private static  final String Username;
    private  static final String Password;
    private  static  final Properties properties;
    private  static final QueryRunner QUERY_RUNNER=new QueryRunner();
    private static final ThreadLocal<Connection> CONNECTION_THREAD_LOCAL=new ThreadLocal<Connection>();
    private static final BasicDataSource dataSource;

    static{
        properties=PropsUtil.loadProps("databaseconfig.properties");
        Driver=PropsUtil.getString(properties,"jdbc.driver");
        URL=PropsUtil.getString(properties,"jdbc.url");
        Username=PropsUtil.getString(properties,"jdbc.username");
        Password=PropsUtil.getString(properties,"jdbc.password");
        logger.info("Driver:{}",Driver);
        logger.info("URL:{}",URL);
        logger.info("Username:{}",Username);
        logger.info("Password:{}",Password);
        dataSource=new BasicDataSource();
        dataSource.setDriverClassName(Driver);
        dataSource.setUrl(URL);
        dataSource.setUsername(Username);
        dataSource.setPassword(Password);


        /*try {
            Class.forName(Driver);
        } catch (ClassNotFoundException e) {
            logger.error("can not load jdbc driver",e);
        }*/
    }
    /*
    * 获取数据库连接
    * */
    public static Connection getConnection(){
        /*Connection connection=null;
        try {
            DriverManager.getConnection(URL,Username,Password);
        } catch (SQLException e) {
            logger.error("get database connection failure",e);
        }
        return connection;*/
        Connection connection=CONNECTION_THREAD_LOCAL.get();
        if(connection==null){
            try {
                //connection=DriverManager.getConnection(URL,Username,Password);
                connection=dataSource.getConnection();
            } catch (SQLException e) {
                logger.error("get database connection failure",e);
                throw new RuntimeException(e);
            }
            CONNECTION_THREAD_LOCAL.set(connection);
        }
        return connection;
    }
    /*
    * 查询实体列表
    * */
    public static <T> List<T> queryList(Class<T> entityClass,String sql){

          List<T> list=null;
        try {
            list=QUERY_RUNNER.query(getConnection(),sql,new BeanListHandler<T>(entityClass));
        } catch (SQLException e) {
            logger.error("query entityList failure",e);
            throw new RuntimeException(e);
        }finally {

        }
        return list;
    }
    /*
    * 查询实体
    * */
    public static <T> T queryObject(Class<T> entityClass ,String sql){
        T entity=null;
        try {
            entity = QUERY_RUNNER.query(getConnection(), sql, new BeanHandler<T>(entityClass));
        } catch (SQLException e) {
            logger.error("query entity failure",e);
            throw new RuntimeException(e);
        }
       return entity;

    }
    /*
    * 关闭数据库连接
    * */
    public static void closeConnection(Connection connection){

        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("close database connection failure",e);
            }
        }
    }
    /*
    * 从Threadloacals中关闭连接
    * */
    public static void closeConnection(){
        Connection connection=CONNECTION_THREAD_LOCAL.get();
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("close database connection failure",e);
                throw new  RuntimeException(e);
            }finally {
                CONNECTION_THREAD_LOCAL.remove();
            }
        }
    }


}
