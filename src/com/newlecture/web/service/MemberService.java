package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.entity.Member;

public class MemberService {

	public List<Member> getList() {
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String dbid = "NEWLEC";
		String dbpwd = "11111";
		String sql = "SELECT * FROM MEMBER WHERE pwd='111'";
		
		List<Member> list = new ArrayList<>();
		//DriverManager;//Class.forName~~
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,dbid,dbpwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nicname = rs.getString("nicname");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				Member m = new Member();
				m.setId(id);
				m.setNicname(nicname);
				m.setPwd(pwd);
				m.setName(name);
				
				list.add(m);
			}
			
			rs.close();
			st.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return list;
	}
	
}
