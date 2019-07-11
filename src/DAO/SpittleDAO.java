package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Model.Spitter;
import Model.Spittle;


public class SpittleDAO {	

	public void createSpittle(Spitter spitter) {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spittr", "root", "root");
			System.out.println("Connected database successfully...");
			Statement stmt = con.createStatement();
			String query = "INSERT INTO spittle(username,post) VALUES (" + "\""
					+ spitter.getUsername() + "\"" + "," + "\""
					+ spitter.getSpittle().getPost() + "\"" + ")";
			stmt.executeUpdate(query);
			System.out.println("Post is saved");
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
	
	public void viewSpittles(Spitter spitter) {
		Connection con = null;
		Spittle spittle = null;
		Set<Spittle> spittleSet = new HashSet();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spittr", "root", "root");
			System.out.println("Connected database successfully...");
			Statement stmt = con.createStatement();

			String query = "Select * From spittle where username =" + "\"" + spitter.getUsername() + "\"";

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				spittle = new Spittle();
				 spittle.setId(rs.getInt(1));
				 spittle.setUsername(rs.getString(2));
				 spittle.setPost(rs.getString(3));
				 
				spittleSet.add(spittle);
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

		for (Spittle spittle1 : spittleSet) {
			System.out.println(spittle1.getId()+" "+spittle1.getPost());
		}

	}	

	//delete 
	public void deleteSpittle(Integer spittleId) {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spittr", "root", "root");
			System.out.println("Connected database successfully...");
			Statement stmt = con.createStatement();
			String query =	"DELETE From spittle where id = "+spittleId;
			stmt.executeUpdate(query);
			System.out.println("delete spittle is successful");
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

	//updateSpittle works by passing new post and the id for the post that you want to be updated
	public void editSpittle(String newPost,Integer spittleId){
		Connection con = null;
		Spittle newSp = new Spittle();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spittr", "root", "root");
			System.out.println("Connected database successfully...");
			Statement stmt = con.createStatement();
			
			
						
			String query ="UPDATE spittle SET post ="+"\""+ newPost+ "\""+
			"where id="+spittleId;					
			stmt.executeUpdate(query);
			System.out.println("update spittle is successful");
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
}
