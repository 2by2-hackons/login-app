package com.loginapp.auth.model;

import jakarta.persistence.*;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String username;
  @Column
  private String password;

public Object getPassword() {
	// TODO Auto-generated method stub
	return password;
}

public String getUsername() {
	// TODO Auto-generated method stub
	return username;
}
public void setUsername(String username) {
    this.username = username;
}
public void setPassword(String password) {
    this.password = password;
}

}
