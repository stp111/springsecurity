package com.dcloud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dcloud.model.User;

public class UserDAO {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public User findById(int id) {
		
		logger.info("findById: {}",id);
		String strSQL = "select username, password, case status when 1 then 'true' else 'false' end as enabled from user where id = ?";
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(strSQL);
			ps.setInt(1, id);
			
			User user = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				String strName = rs.getString(1);
				String strPwd = rs.getString(2);
				user.setUserId(String.valueOf(id));
				user.setUserName(strName);
				user.setPassword(strPwd);
				return user;
			}
			
		} catch (Exception e) {
			logger.error(" Exception {} ", e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("finnally Exception {} ", e);
				}
			}
		}
		return null;
	}
	
	//
	public User findByName(String strName) {
		logger.info("find by name: {}",strName);
String strSQL = "select username, password, id, case status when 1 then 'true' else 'false' end as enabled from user where name = ?";
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(strSQL);
			ps.setString(1, strName);
			
			User user = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				String username = rs.getString(1);
				String strPwd = rs.getString(2);
				int id = rs.getInt(3);
				user.setUserId(String.valueOf(id));
				user.setUserName(username);
				user.setPassword(strPwd);
				return user;
			} else {
				logger.error("not user for {}",strName);
			}
			
			
		} catch (Exception e) {
			logger.error(" Exception {} ", e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("finnally Exception {} ", e);
				}
			}
		}
		return null;
	}
}
