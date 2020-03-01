package com.springdemo.bootboard.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tbl_users")
@Data
public class UsersEntity {

	@Id
	private String userName;
	
	@Column
	private String passwd;
	
	@Column
	private boolean enabled = true;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_name")
	private Collection<UsersRolesEntity> usersRoles;
	
}
