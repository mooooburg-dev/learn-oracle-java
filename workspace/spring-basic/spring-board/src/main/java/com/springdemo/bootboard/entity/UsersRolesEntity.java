package com.springdemo.bootboard.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tbl_users_roles")
@Data
public class UsersRolesEntity implements Serializable {
	
	@Id
	private String user_name;
	@Id
	private String role_name;
	
}
