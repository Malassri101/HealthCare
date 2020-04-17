package com.HelthCare.HealthCare;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class UserRepository {
	Connection con = null;
	
	List<user> users;
	public UserRepository() {
		
		String url = "Jdbc:mysql://localhost:3306/healthcare";
		String username = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
		users = new ArrayList<>();
		
		user u1 = new user();
		u1.setU_id(0001);
		u1.setU_fname("Supun");
		u1.setU_lname("Madhawa");
		u1.setU_age(24);
		u1.setU_address("Kuliyapitiya");
		u1.setU_sex("Male");
		u1.setU_email("madhawa@gmail.com");
		u1.setU_username("Madhawa");
		u1.setU_password("madhawa123");
		u1.setU_type("admin");
		u1.setU_contact(07600000000);
		
		user u2 = new user();
		u2.setU_id(0002);
		u2.setU_fname("Sahan");
		u2.setU_lname("Malssri");
		u2.setU_age(23);
		u2.setU_address("Kolonnawa");
		u2.setU_sex("Male");
		u2.setU_email("sahan@gmail.com");
		u2.setU_username("Sahan");
		u2.setU_password("sahan123");
		u2.setU_type("patient");
		u2.setU_contact(07700000000);
		
		user u3 = new user();
		u3.setU_id(0003);
		u3.setU_fname("Kasun");
		u3.setU_lname("Thilina");
		u3.setU_age(24);
		u3.setU_address("Horana");
		u3.setU_sex("Male");
		u3.setU_email("kasun@gmail.com");
		u3.setU_username("Kasun");
		u3.setU_password("kasun123");
		u3.setU_type("patient");
		u3.setU_contact(07700000000);
		
		users.add(u1);
		users.add(u2);
		users.add(u3);
		
	}
	
	public List<user> getallUsers(){
		List<user> users = new ArrayList<>();
		String sql = "select * from users";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				user u = new user();
				
				u.setU_id(rs.getInt(1));
				u.setU_fname(rs.getString(2));
				u.setU_lname(rs.getString(3));
				u.setU_age(rs.getInt(4));
				u.setU_address(rs.getString(5));
				u.setU_sex(rs.getString(6));
				u.setU_email(rs.getString(7));
				u.setU_username(rs.getString(8));
				u.setU_password(rs.getString(9));
				u.setU_type(rs.getString(10));
				u.setU_contact(rs.getInt(11));
				
				users.add(u);
				
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return users;
	}
	public user createUser(user u4) {
		String insertSql = "INSERT INTO `users`(`u_id`, `u_fname`, `u_lname`, `u_age`, `u_address`, `u_sex`, `u_email`, `u_username`, `u_password`, `u_type`, `u_contact`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(insertSql);
			st.setInt(1, u4.u_id);
			st.setString(2, u4.u_fname);
			st.setString(3, u4.u_lname);
			st.setInt(4, u4.u_age);
			st.setString(5, u4.u_address);
			st.setString(6, u4.u_sex);
			st.setString(7, u4.u_email);
			st.setString(8, u4.u_username);
			st.setString(9, u4.u_password);
			st.setString(10, u4.u_type);
			st.setInt(11, u4.u_contact);
			
			st.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
		users.add(u4);
		System.out.println(users);
		return u4;
		
	}
	
	public void updateUser(user u5) {
		String sql = "UPDATE users SET u_fname = ? WHERE u_id = ?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,u5.getU_fname());
			st.setInt(2,u5.getU_id());
			
			st.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
