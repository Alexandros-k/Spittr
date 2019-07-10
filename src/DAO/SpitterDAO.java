package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Spitter;


public class SpitterDAO {
	
	
	public void createAccount(Spitter spitter) {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spittr", "root", "root");
			System.out.println("Connected database successfully...");
			Statement stmt = con.createStatement();
			String query = "INSERT INTO spitter(firstname,lastname,username,password,email) VALUES (" + "\""
					+ spitter.getFirstname() + "\"" + "," + "\"" + spitter.getLastname() + "\"" + "," + "\""
					+ spitter.getUsername() + "\"" + "," + "\"" + spitter.getPassword() + "\"" + "," + "\""
					+ spitter.getEmail() + "\"" + ")";
			stmt.executeUpdate(query);
			System.out.println("create Account is successful");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteAccount(Spitter spitter) {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spittr", "root", "root");
			System.out.println("Connected database successfully...");
			Statement stmt = con.createStatement();
			String query =	"DELETE From spitter\r\n" + 
					"where username = "+"\""+spitter.getUsername()+"\"";
			stmt.executeUpdate(query);
			System.out.println("delete Account is successful");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateAccount(Spitter spitter,String oldUsername){
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spittr", "root", "root");
			System.out.println("Connected database successfully...");
			Statement stmt = con.createStatement();
			
			
						
			String query ="UPDATE spitter SET firstname ="+"\""+ spitter.getFirstname()+ "\""+","+
											 "lastname = "+"\""+ spitter.getLastname()+ "\""+" ,"+										
											 "username = "+"\""+ spitter.getUsername()+ "\""+" ,"+		
											 "password = "+"\""+ spitter.getPassword()+ "\""+" ,"+		
											 "email = "+"\""+ spitter.getEmail()+ "\""+
											  "where username="+"\""+oldUsername+ "\"";
			
			
			stmt.executeUpdate(query);
			System.out.println("update Account is successful");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public void viewAccount(Spitter spitter) {
		Connection con = null;
		Spitter newSp = new Spitter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spittr", "root", "root");
			System.out.println("Connected database successfully...");
			Statement stmt = con.createStatement();
			
			
						
			String query ="Select * From spitter where username ="+"\""+spitter.getUsername()+ "\"";			
			
			ResultSet rs =  stmt.executeQuery(query);
			
			while(rs.next()) {
				newSp.setFirstname(rs.getString(2));
				newSp.setLastname(rs.getString(3));
				newSp.setUsername(rs.getString(4));
				newSp.setPassword(rs.getString(5));
				newSp.setEmail(rs.getString(6));
			}
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	System.out.println(newSp.getFirstname()+" "+newSp.getLastname()+" "+newSp.getUsername()+" "+newSp.getPassword());
		
	}
		
	public Boolean isUsernameUnique(Spitter spitter){
		Connection con = null;
		List<String> usernameList= new ArrayList();
		try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spittr", "root", "root");
		System.out.println("Connected database successfully...");
		Statement stmt = con.createStatement();		
		String query="select username From spitter";
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			usernameList.add(rs.getString(0));
		}
			
		for (String usernameFromDB : usernameList) {
			if(usernameFromDB.equals(spitter.getUsername())) {
				return false;
				}
		}
		
	} catch (Exception e) {
		System.out.println(e);
	} finally {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		return true;
	}
	
	
}

