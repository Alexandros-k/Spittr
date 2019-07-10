package Model;

public class Spittle {

int id;
	
	Spitter spitter;

	String post;	

	public Spittle(Spitter spitter, String post) {
		super();
		this.spitter = spitter;
		this.post = post;
	}

	public Spittle(int id, Spitter spitter, String post) {
		super();
		this.id = id;
		this.spitter = spitter;
		this.post = post;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Spitter getSpitter() {
		return spitter;
	}

	public void setSpitter(Spitter spitter) {
		this.spitter = spitter;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}	
	
}
