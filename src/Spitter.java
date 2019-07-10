import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Spitter {
	int id;
	
	String firstname;
	
	String lastname;
	
	String username;
	
	String password;
	
	String email;
	
	public Spitter() {
		super();
	}	

	

	public Spitter(String firstname, String lastname, String username, String password, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
	}	

	public Spitter(int id, String firstname, String lastname, String username, String password, String email) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}


	public void createAccount(){
		
		String querry =	"INSERT INTO spitter(firstname,lastname,username,password,email) VALUES ("+"\""+this.getFirstname()+"\""+ ","+"\"" +this.getLastname()+"\""+
		","+"\""+this.getUsername()+"\""+","+"\"" +this.getPassword()+"\""+","+"\"" +this.getEmail()+"\""+ ")";
			createConnection(querry);
		}
	
	public void deleteAccount(){}// a delete query which will  delete an account based on username and be passed to the createConnection method which is also responsible to execute query
	
	public void updateAccount(){}// a update query which will update an account based on username and be passed to the createConnection method which is also responsible to execute query
	
	public void viewAccount(){}// a view query which will retrieve an account based on username and be passed to the createConnection method which is also responsible to execute query
	
	public void createConnection(String query) {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spittr", "root", "root");
			System.out.println("Connected database successfully...");
			Statement stmt = con.createStatement();			
		
			stmt.executeUpdate(query);
			System.out.println("Spitter successfully added");
			
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
	
	
	Boolean isUsernameUnique(){
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
			if(usernameFromDB.equals(this.getUsername())) {
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
