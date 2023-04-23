package com.broadway.springproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="department_tbl")
public class Department {
	@Id
	@GeneratedValue
	private int id;
	private String dpt_name;
	private String dbt_head;
	private String dpt_phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDpt_name() {
		return dpt_name;
	}
	public void setDpt_name(String dpt_name) {
		this.dpt_name = dpt_name;
	}
	public String getDbt_head() {
		return dbt_head;
	}
	public void setDbt_head(String dbt_head) {
		this.dbt_head = dbt_head;
	}
	public String getDpt_phone() {
		return dpt_phone;
	}
	public void setDpt_phone(String dpt_phone) {
		this.dpt_phone = dpt_phone;
	}

}
