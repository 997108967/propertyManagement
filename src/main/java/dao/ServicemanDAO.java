package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Serviceman;
import entity.User;
import util.DBUtils;

public class ServicemanDAO {
	/**
	 * 维修完成，修改完成进度
	 * @param name
	 * @throws SQLException 
	 */
	public void maintenanceCompleted(String name) throws SQLException {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConn();
			stat = conn.prepareStatement("update serviceman set schedule='修理完毕' where name=?");
			stat.setString(1, name);
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	/**
	 * 根据指定用户名插入数据
	 * @param name
	 * @param username
	 * @param phoneNumber
	 * @param fault
	 * @throws SQLException 
	 */
	public void insertInfoByUsername(String name,String username,String phoneNumber,String fault) throws SQLException {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConn();
			stat= conn.prepareStatement("update serviceman set project=?,schedule='正在修理',username=?,userPhone=? where name=?");
			stat.setString(1, fault);
			stat.setString(2, username);
			stat.setString(3, phoneNumber);
			stat.setString(4, name);
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, stat, rs);
		}
		
	}
	
	/**
	 * 查询需要故障维修的用户
	 * @throws SQLException 
	 */
	public List<User> findFaultUser() throws SQLException{
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConn();
			stat = conn.prepareStatement("select * from userInfo where fault is not null and repair =?");
			stat.setString(1, "未接单");
			rs = stat.executeQuery();
			List<User> users = new ArrayList<User>();
			while(rs.next()) {
				String fault = rs.getString("fault");
				String username = rs.getString("username");
				String phoneNumber = rs.getString("phoneNumber");
				User user = new User();
				user.setFault(fault);
				user.setPhoneNumber(phoneNumber);
				user.setUsername(username);
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, stat, rs);
		}
	}
	
	
	/**
	 * 插入用户信息
	 * 写错了， 应该写在用户DAO里！！！！！！！！！！！！！！！！
	 * @throws SQLException 
	 */
	public void insertUserInfo(Serviceman serviceman) throws SQLException {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConn();
			stat = conn.prepareStatement("insert into serviceman(name,password,phone) values(?,?,?)");
			stat.setString(1, serviceman.getName());
			stat.setString(2, serviceman.getPassword());
			stat.setString(3, serviceman.getPhone());
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, stat, rs);
		}
	}
	
	
	
	
	
		
	/**
	 * 根据用户名查询指定用户信息
	 * @return
	 * @throws SQLException 
	 */
	public Serviceman findUserInfo(String username) throws SQLException {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConn();
			stat = conn.prepareStatement("select * from serviceman where name=?");
			stat.setString(1, username);
			rs = stat.executeQuery();
			Serviceman serviceman = null;
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String phone = rs.getString("phone");
				String project = rs.getString("project");
				String schedule = rs.getString("schedule");
				String username1 = rs.getString("username");
				String userPhone = rs.getString("userPhone");
				serviceman = new Serviceman();
				serviceman.setId(id);
				serviceman.setName(name);
				serviceman.setPassword(password);
				serviceman.setPhone(phone);
				serviceman.setProject(project);
				serviceman.setSchedule(schedule);
				serviceman.setUsername(username1);
				serviceman.setUserPhone(userPhone);
			}
			return serviceman;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * 根据用户名查找符合条件的用户信息
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public List<Serviceman> findByUsername(String name) throws SQLException {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConn();
			stat = conn.prepareStatement("select username,userPhone,project from serviceman where name=? and schedule='正在修理'");
			stat.setString(1, name);
			rs = stat.executeQuery();
			List<Serviceman> servicemans = new ArrayList<Serviceman>();
			while(rs.next()) {
				String username = rs.getString("username");
				String userPhone = rs.getString("userPhone");
				String project = rs.getString("project");
				Serviceman serviceman = new Serviceman();
				serviceman.setUsername(username);
				serviceman.setUserPhone(userPhone);
				serviceman.setProject(project);
				servicemans.add(serviceman);
			}
			return servicemans;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, stat, rs);
		}
		
	}
}
