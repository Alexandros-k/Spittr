import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class Main {

	public static void main(String[] args) {
		
	Spitter spitter = new Spitter("Alex","kon","user4","pass3","alex@kon.com");
	
	spitter.createAccount();	
		
	}
	
}
