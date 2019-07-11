package Model;

public class Spittle {

int id;
	
private	String username;

private String post;	

	
	
	

	public Spittle() {
		
	}




	public Spittle(String post) {		
		this.post = post;
	}




	public Spittle(int id, String username, String post) {		
		this.id = id;
		this.username = username;
		this.post = post;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}	
	
}
