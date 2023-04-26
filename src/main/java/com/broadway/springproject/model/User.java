package com.broadway.springproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="user_tbl")
public class User {
	@Id
	@GeneratedValue
	private int id;
	private String fname;
	private String lname;
	@Column(unique = true)
	private String username;
	private String password;
	

}
