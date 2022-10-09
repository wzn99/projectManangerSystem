package com.dao.base;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDao<T> {
	public final String DRIVER = "com.mysql.cj.jdbc.Driver";
	//改成你的URL
	public final String URL = "jdbc:mysql://localhost:3306/test_schema?useSSL=false&serverTimezone=UTC";
	public final String USER = "root";
	public final String PWD = "1111";    //改成你的密码

	protected Connection conn;
	protected PreparedStatement psmt;
	protected ResultSet rs;

	//T的Class对象
	private Class<T> entityClass;

	public BaseDao() {
		Type genericType = getClass().getGenericSuperclass();
		//ParameterizedType 参数化类型
		Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
		//获取到的<T>中的T的真实的类型
		Type actualType = actualTypeArguments[0];
		try {
			entityClass = (Class<T>) Class.forName(actualType.getTypeName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected Connection getConn() {
		try {
			//1.加载驱动
			Class.forName(DRIVER);
			//2.通过驱动管理器获取连接对象
			return DriverManager.getConnection(URL, USER, PWD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected void close(ResultSet rs, PreparedStatement psmt, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//给预处理命令对象设置参数
	private void setParams(PreparedStatement psmt, Object... params) throws SQLException {
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				psmt.setObject(i + 1, params[i]);
			}
		}
	}

	//执行更新(包括插入)，返回影响行数
	protected int executeUpdate(String sql, Object... params) {
		boolean insertFlag = false;
		insertFlag = sql.trim().toUpperCase().startsWith("INSERT");
		try {
			conn = getConn();
			if (insertFlag) {
				psmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			} else {
				psmt = conn.prepareStatement(sql);
			}
			setParams(psmt, params);
			int count = psmt.executeUpdate();

			if (insertFlag) {
				rs = psmt.getGeneratedKeys();
				if (rs.next()) {
					return ((Long) rs.getLong(1)).intValue();
				}
			}

			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, psmt, conn);
		}
		return 0;
	}

	//通过反射技术给obj对象的property属性赋propertyValue值
	private void setValue(Object obj, String property, Object propertyValue) {
		Class clazz = obj.getClass();
		try {
			//获取property这个字符串对应的属性名 ， 比如 "fid"  去找 obj对象中的 fid 属性
			Field field = clazz.getDeclaredField(property);
			field.setAccessible(true);
			field.set(obj, propertyValue);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	//执行复杂查询，返回例如统计结果
	protected Object[] executeComplexQuery(String sql, Object... params) {
		try {
			conn = getConn();
			psmt = conn.prepareStatement(sql);
			setParams(psmt, params);
			rs = psmt.executeQuery();

			//通过rs可以获取结果集的元数据
			//元数据：描述结果集数据的数据 , 简单讲，就是这个结果集有哪些列，什么类型等等

			ResultSetMetaData rsmd = rs.getMetaData();
			//获取结果集的列数
			int columnCount = rsmd.getColumnCount();
			Object[] columnValueArr = new Object[columnCount];
			//6.解析rs
			if (rs.next()) {
				for (int i = 0; i < columnCount; i++) {
					Object columnValue = rs.getObject(i + 1);     //33    苹果      5
					columnValueArr[i] = columnValue;
				}
				return columnValueArr;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, psmt, conn);
		}
		return null;
	}

	//执行查询，返回单个实体对象
	protected T load(String sql, Object... params) {
		try {
			conn = getConn();
			psmt = conn.prepareStatement(sql);
			setParams(psmt, params);
			rs = psmt.executeQuery();

			//通过rs可以获取结果集的元数据
			//元数据：描述结果集数据的数据 , 简单讲，就是这个结果集有哪些列，什么类型等等

			ResultSetMetaData rsmd = rs.getMetaData();
			//获取结果集的列数
			int columnCount = rsmd.getColumnCount();
			//6.解析rs
			if (rs.next()) {
				T entity = entityClass.newInstance();

				for (int i = 0; i < columnCount; i++) {
					String columnName = rsmd.getColumnName(i + 1);            //fid   fname   price
					Object columnValue = rs.getObject(i + 1);     //33    苹果      5
					setValue(entity, columnName, columnValue);
				}
				return entity;
			}
		} catch (SQLException | IllegalAccessException | InstantiationException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			close(rs, psmt, conn);
		}
		return null;
	}


	//执行查询，返回List
	protected List<T> executeQuery(String sql, Object... params) {
		List<T> list = new ArrayList<>();
		try {
			conn = getConn();
			psmt = conn.prepareStatement(sql);
			setParams(psmt, params);
			rs = psmt.executeQuery();

			//通过rs可以获取结果集的元数据
			//元数据：描述结果集数据的数据 , 简单讲，就是这个结果集有哪些列，什么类型等等

			ResultSetMetaData rsmd = rs.getMetaData();
			//获取结果集的列数
			int columnCount = rsmd.getColumnCount();
			//6.解析rs
			while (rs.next()) {
				T entity = entityClass.newInstance();

				for (int i = 0; i < columnCount; i++) {
					String columnName = rsmd.getColumnName(i + 1);            //fid   fname   price
					Object columnValue = rs.getObject(i + 1);     //33    苹果      5
					setValue(entity, columnName, columnValue);
				}
				list.add(entity);
			}
		} catch (SQLException | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		} finally {
			close(rs, psmt, conn);
		}
		return list;
	}
}
