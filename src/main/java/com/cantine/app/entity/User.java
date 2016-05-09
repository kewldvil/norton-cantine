package com.cantine.app.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name="TBL_USER")
@DynamicUpdate(value=true)
@SelectBeforeUpdate(value=true) 
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	private String name;
	private String username;
	private String password;
	private String userRole;
	private boolean isActive=true;


    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="userId")
	private List<Transaction> transaction;
	
	
}
