import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.SpitterDAO;
import Model.Spitter;



public class Main {

	public static void main(String[] args) {
		
	SpitterDAO spDAO = new SpitterDAO();
	Spitter spitter1 = new Spitter("Alex","kon","user4","pass3","alex@kon.com");
	Spitter spitter2 = new Spitter("George","red","user5","pass5","George@kon.com");
	Spitter spitter3 = new Spitter("Helen","ren","user6","pass3","alex@kon.com");
	
	//spDAO.createAccount(spitter);
	
	//spDAO.deleteAccount(spitter);
	
	//spDAO.updateAccount(spitter1,spitter2.getUsername());
	
	spDAO.viewAccount(spitter1);
	}
	
}
