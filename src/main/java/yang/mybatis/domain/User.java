package yang.mybatis.domain;

public class User {
	private int id;
	private String user_name;
	private int age;
	private String password;
	
	public User(){}
	public User(String name,int id, int age,String password) {
		super();
		this.id = id;
		this.user_name = name;
		this.age = age;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String name) {
		this.user_name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + user_name + ", age=" + age + "]";
	}



}
