import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.SpitterDAO;
import DAO.SpittleDAO;
import Model.Spitter;



public class Main {

	public static void main(String[] args) {
		
	SpitterDAO sptrDAO = new SpitterDAO();
	SpittleDAO sptlDAO = new SpittleDAO();
	Spitter spitter1 = new Spitter("Alex","kon","user4","pass3","Alex@kon.com");
	Spitter spitter2 = new Spitter("George","red","user5","pass5","George@kon.com");
	Spitter spitter3 = new Spitter("Helen","ren","user6","pass6","Helen@kon.com");
	
	String spittle1 ="Hello World";
	
	//sptrDAO.createAccount(spitter);
	
	//sptrDAO.deleteAccount(spitter);
	
	//sptrDAO.updateAccount(spitter2.getUsername(),spitter1);
	
	//sptrDAO.viewAccount(spitter1);	
	
	//spitter1.createNewSpittle("delete me");	
	
	//sptlDAO.createSpittle(spitter1);
	//sptlDAO.viewSpittles(spitter1);
	//sptlDAO.deleteSpittle(3);
	String newPost= "hello world2";
	sptlDAO.editSpittle(newPost,1);
	}
	
}
