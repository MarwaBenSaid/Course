package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employe implements Serializable {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String login;
private String password;
private String email;
private Boolean isActif;
private String ladate ;
private float salaire ;
@Enumerated(EnumType.STRING)
//@NotNull
private Role role;

public Employe() {
	super();
}


public Employe(String login, String password, String email, Boolean isActif, String ladate, Role role) {
	super();
	this.login = login;
	this.password = password;
	this.email = email;
	this.isActif = isActif;
	this.ladate = ladate;
	this.role = role;
}


public Employe(String login, String password, String email, Boolean isActif, String ladate, float salaire, Role role) {
	super();
	this.login = login;
	this.password = password;
	this.email = email;
	this.isActif = isActif;
	this.ladate = ladate;
	this.salaire = salaire;
	this.role = role;
}


public Employe(String login, String password, String email, Role role, Boolean isActif) {
	super();
	this.login = login;
	this.password = password;
	this.email = email;
	this.isActif = isActif;
	this.role = role;
}
public Employe(Integer employeIdToBeUpdated,String login, String password, String email, Boolean isActif,  Role role) {
	super();
	this.id = employeIdToBeUpdated;
	this.login = login;
	this.password = password;
	this.email = email;
	this.isActif = isActif;
	this.role = role;
}

public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Boolean getIsActif() {
	return isActif;
}
public void setIsActif(Boolean isActif) {
	this.isActif = isActif;
}

public String getLadate() {
	return ladate;
}

public void setLadate(String ladate) {
	this.ladate = ladate;
}

public float getSalaire() {
	return salaire;
}

public void setSalaire(float salaire) {
	this.salaire = salaire;
}

}
