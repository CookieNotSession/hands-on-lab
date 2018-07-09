package com.test.inv.http.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserData {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long uid;
    
	private String name;
	private String age;
	
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserData [uid=" + uid + ", name=" + name + ", age=" + age + "]";
	}

	
}	