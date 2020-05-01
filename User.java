package webadv.s99201105.p02;

import java.io.Serializable;

public class User implements Serializable{
	//属性用户名
	private String name;
	//密码
	private String password;
	public String getName() {
		
	    return name;
	 }
	public void setName(String name) {
	    this.name = name;
	 }
	public String getPassword() {
	    return password;
	 }
	public void setPassword(String password) {
	    this.password = password;
	 }
	public User() {
		
	}	
	public User(String name,String password) {
		super();
		this.name=name;
		this.password=password;
	}
	
}
