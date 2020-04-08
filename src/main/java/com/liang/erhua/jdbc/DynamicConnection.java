package com.liang.erhua.jdbc;

import com.liang.erhua.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.sql.*;
import java.util.*;

/**
 * @author: liangjia
 * @date: created in 16:28 2020年04月07日
 * @description: jdbc获取动态数据源
 * @modified by:
 * @version: 1.0
 */
public class DynamicConnection {
	private static final Logger logger =
			LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * 执行SQL并处理结果集
	 *
	 * @param params
	 * @return
	 */
	public static List<Map<String, Object>> getData(Map<String, Object> params) {
		List<Map<String, Object>> returnList = new ArrayList<>();
		try (Connection connection = getConnection(params);
			 PreparedStatement statement =
					 connection.prepareStatement(StringUtil.getString(params,
							 "executeSql"));
			 ResultSet resultSet = statement.executeQuery()) {
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			while (resultSet.next()) {
				int length = resultSetMetaData.getColumnCount();
				Map<String, Object> resultMap = new LinkedHashMap<>();
				for (int i = 0; i < length; i++) {
					String key = resultSetMetaData.getColumnLabel(i);
					switch (resultSetMetaData.getColumnType(i)) {
						case Types.VARCHAR:
							resultMap.put(key, resultSet.getString(i));
							break;
						case Types.DATE:
							resultMap.put(key, resultSet.getDate(i));
							break;
						case Types.BOOLEAN:
							resultMap.put(key, resultSet.getBoolean(i));
							break;
						case Types.DECIMAL:
							resultMap.put(key, resultSet.getBigDecimal(i));
							break;
						case Types.TIME:
							resultMap.put(key, resultSet.getTime(i));
							break;
						case Types.BLOB:
							resultMap.put(key, resultSet.getBlob(i));
							break;
						case Types.CLOB:
							resultMap.put(key, resultSet.getClob(i));
							break;
						default:
							resultMap.put(key, resultSet.getObject(i));
							break;
					}
				}
				returnList.add(resultMap);
			}
		} catch (Exception e) {
			logger.error("执行数据库查询失败", e);
		}
		return returnList;
	}

	/**
	 * 动态获取数据库连接
	 *
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection(Map<String, Object> params) throws Exception {
		// 1、注册驱动
		String dbDriver = StringUtil.getString(params, "dbDriver");
		Class.forName(dbDriver);
		String dbUrl = StringUtil.getString(params, "dbUrl");
		String dbUser = StringUtil.getString(params, "dbUser");
		String dbPwd = String.valueOf(params.get("dbPwd"));
		Properties properties = System.getProperties();
		properties.put("user", dbUser);
		properties.put("password", dbPwd);
		return DriverManager.getConnection(dbUrl, properties);
	}
}
