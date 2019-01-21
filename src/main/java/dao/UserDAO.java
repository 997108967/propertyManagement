package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import util.DBUtils;

public class UserDAO {
	
	/**
	 * 修改用户数据根据用户名
	 * @param password
	 * @param address
	 * @param phoneNumber
	 * @throws SQLException 
	 */
	public void updateUserData(User user) throws SQLException {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConn();
			stat = conn.prepareStatement("update userInfo set password=?,address=?,phoneNumber=? where username=?");
			stat.setString(1, user.getPassword());
			stat.setString(2, user.getAddress());
			stat.setString(3, user.getPhoneNumber());
			stat.setString(4, user.getUsername());
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
			
		}finally {
			DBUtils.close(conn, stat, rs);
		}
	}
	
	/**
	 * 根据用户给定字段模糊查询用户名
	 * @return
	 * @throws SQLException
	 */
	public List<User> fuzzyQueryByUsername(String key) throws SQLException{
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		key = "%"+key+"%";
		try {
			conn = DBUtils.getConn();
			stat = conn.prepareStatement("select * from userInfo where username like ?");
			stat.setString(1,key );
			rs = stat.executeQuery();
			List<User> users = new ArrayList<User>();
			while(rs.next()) {
				User user = new User();
				int id = rs.getInt("id");
				String name = rs.getString("username");
				String password = rs.getString("password");
				String address = rs.getString("address");
				String idNumber = rs.getString("idNumber");
				String phoneNumber = rs.getString("phoneNumber");
				String fault = rs.getString("fault");
				String repair = rs.getString("repair");
				String waterRates = rs.getString("waterRates");
				String powerRates = rs.getString("powerRates");
				String burnerCost = rs.getString("burnerCost");
				String propertyFee = rs.getString("propertyFee");
				
				user.setId(id);
				user.setUsername(name);
				user.setPassword(password);
				user.setAddress(address);
				user.setIdNumber(idNumber);
				user.setPhoneNumber(phoneNumber);
				user.setFault(fault);
				user.setRepair(repair);
				user.setWaterRates(waterRates);
				user.setPowerRates(powerRates);
				user.setBurnerCost(burnerCost);
				user.setPropertyFee(propertyFee);
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * 根据指定id删除用户
	 * @param id
	 * @throws SQLException
	 */
	public void delete(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConn();
			stat = conn.prepareStatement("delete from userInfo where id=?");
			stat.setInt(1, id);
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, stat, rs);
		}
	}
	
	/**
	 * 查询所有用户
	 * @return
	 * @throws SQLException 
	 */
	public List<User> listUser() throws SQLException{
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConn();
			stat = conn.prepareStatement("select * from userInfo");
			rs = stat.executeQuery();
			List<User> users = new ArrayList<User>();
			while(rs.next()) {
				User user = new User();
				int id = rs.getInt("id");
				String name = rs.getString("username");
				String password = rs.getString("password");
				String address = rs.getString("address");
				String idNumber = rs.getString("idNumber");
				String phoneNumber = rs.getString("phoneNumber");
				String fault = rs.getString("fault");
				String repair = rs.getString("repair");
				String waterRates = rs.getString("waterRates");
				String powerRates = rs.getString("powerRates");
				String burnerCost = rs.getString("burnerCost");
				String propertyFee = rs.getString("propertyFee");
				
				user.setId(id);
				user.setUsername(name);
				user.setPassword(password);
				user.setAddress(address);
				user.setIdNumber(idNumber);
				user.setPhoneNumber(phoneNumber);
				user.setFault(fault);
				user.setRepair(repair);
				user.setWaterRates(waterRates);
				user.setPowerRates(powerRates);
				user.setBurnerCost(burnerCost);
				user.setPropertyFee(propertyFee);
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	
	/**
	 * 维修完成，修改完成进度
	 * @param name
	 * @throws SQLException 
	 */
	public void maintenanceCompleted(String username) throws SQLException {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConn();
			stat = conn.prepareStatement("update userInfo set repair='修理完毕' where username=?");
			stat.setString(1, username);
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, stat, rs);
		}
	}
	
	
	
	
	/**
	 * 修改用户维修状态
	 * @param username
	 * @throws SQLException 
	 */
	public void modifyMaintenanceStatus(String username) throws SQLException {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConn();
			stat = conn.prepareStatement("update userInfo set repair = '正在维修' where username=?");
			stat.setString(1, username);
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, stat, rs);
		}
	}
	
	
	/**
	 * 根据密保问题，查找密保答案
	 * @throws SQLException 
	 */
	public String findTheSecretAnswer(String username,String securityQuestion) throws SQLException{
		
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConn();
			stat = conn.prepareStatement("select s.secretProtectionValue from userInfo u,secretProtection s where u.id=s.uid and username=? and secretProtection=? ");
			stat.setString(1, username);
			stat.setString(2, securityQuestion);
			rs = stat.executeQuery();
			String answer = null;
			while(rs.next()) {
				answer = rs.getString("secretProtectionValue");
			}
			return answer;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	
	
	
	/**
	 * 修改密码
	 * @throws SQLException 
	 */
	public void changePassword(String username,String newPassword) throws SQLException {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConn();
			stat = conn.prepareStatement("update userInfo set password=? where username=?");
			stat.setString(1, newPassword);
			stat.setString(2, username);
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, stat, rs);
		}
	}
	
	/**
	 * 缴费
	 * @throws SQLException 
	 */
	public void onlinePayment(String username,String payType,String money) throws SQLException {
		User user = find(username);
		
		String balance;
		double balance2;
		double money2 = Double.parseDouble(money);
		if(payType.equals("waterRates")) {
			balance = user.getWaterRates();
		}else if(payType.equals("powerRates")) {
			balance = user.getPowerRates();
		}else if(payType.equals("burnerCost")) {
			balance = user.getBurnerCost();
		}else {
			balance = user.getPropertyFee();
		}
		if(balance!=null) {
			balance2 = Double.parseDouble(balance);
		}else {
			balance2 = 0;
		}
		money = money2+balance2+"";
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			System.out.println(payType+":"+money+":"+username);
			stat = conn.prepareStatement("update userInfo set "+payType+"=? where username=?");
//			stat.setString(1, payType);
			stat.setString(1, money);
			stat.setString(2, username);
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, stat, rs);
		}
	}
	
	
	/**
	 * 修改故障内容(用户报修)
	 * @throws SQLException 
	 */
	public void updateFault(String username,String fault) throws SQLException {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			stat = conn.prepareStatement("update userInfo set fault=?,repair='未接单' where username=?");
			stat.setString(1, fault);
			stat.setString(2, username);
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, stat, rs);
		}
	}
	
	
	
	
	
	/**
	 * 查找用户
	 * @throws SQLException 
	 */
	public User find(String username) throws SQLException{
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			stat = conn.prepareStatement("select u.*,s.* from userInfo u,secretProtection s where u.id=s.uid and username=?");
			stat.setString(1, username);
			rs = stat.executeQuery();
			User user = new User();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("username");
				String password = rs.getString("password");
				String address = rs.getString("address");
				String idNumber = rs.getString("idNumber");
				String phoneNumber = rs.getString("phoneNumber");
				String fault = rs.getString("fault");
				String repair = rs.getString("repair");
				String repairman = rs.getString("repairman");
				String waterRates = rs.getString("waterRates");
				String powerRates = rs.getString("powerRates");
				String burnerCost = rs.getString("burnerCost");
				String propertyFee = rs.getString("propertyFee");
				String secretProtection = rs.getString("secretProtection");
				String secretProtectionValue = rs.getString("secretProtectionValue");
				
				user.setId(id);
				user.setUsername(name);
				user.setPassword(password);
				user.setAddress(address);
				user.setIdNumber(idNumber);
				user.setPhoneNumber(phoneNumber);
				user.setFault(fault);
				user.setRepair(repair);
				user.setRepairman(repairman);
				user.setWaterRates(waterRates);
				user.setPowerRates(powerRates);
				user.setBurnerCost(burnerCost);
				user.setPropertyFee(propertyFee);
				user.setSecretProtection(secretProtection);
				user.setSecretProtectionValue(secretProtectionValue);
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, stat, rs);
		}
	}
	
	
	/**
	 * 添加用户
	 * @param user
	 * @throws SQLException
	 */
	public void addUser(User user) throws SQLException {
		String username = user.getUsername();
		String password = user.getPassword();
		String address = user.getAddress();
		String idNumber = user.getIdNumber();
		String phoneNumber = user.getPhoneNumber();
		String secretProtection = user.getSecretProtection();
		String secretProtectionValue = user.getSecretProtectionValue();
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			stat = conn.prepareStatement("insert into userInfo(id,username,password,address,idNumber,phoneNumber) values(null,?,?,?,?,?)");
			rs = null;
			stat.setString(1, username);
			stat.setString(2, password);
			stat.setString(3, address);
			stat.setString(4, idNumber);
			stat.setString(5, phoneNumber);
			stat.executeUpdate();
			stat.close();
			stat = conn.prepareStatement("select id from userInfo where username=?");
			stat.setString(1, username);
			rs = stat.executeQuery();
			int id = 0;
			while(rs.next()) {
				id = rs.getInt("id");
			}
			stat.close();
			stat = conn.prepareStatement("insert into secretProtection values(?,?,?)");
			stat.setInt(1, id);
			stat.setString(2, secretProtection);
			stat.setString(3, secretProtectionValue);
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, stat, rs);
		}
	}
	
	/**
	 * 查找用户ID
	 * @throws SQLException 
	 */
	private int findId(String username) throws SQLException {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConn();
			stat = conn.prepareStatement("select id from userInfo where username=?");
			stat.setString(1, username);
			rs = stat.executeQuery();
			int id = 0 ;
			while(rs.next()) {
				id = rs.getInt("id");
			}
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, stat, rs);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
