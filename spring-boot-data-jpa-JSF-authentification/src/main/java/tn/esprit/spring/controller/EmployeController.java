package tn.esprit.spring.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.service.IEmployeService;



@Scope(value = "session")
@Controller(value = "employeController")
@ELBeanName(value = "employeController")
@Join(path = "/", to = "/login.jsf")

public class EmployeController {
    
@Autowired
IEmployeService iEmployeService;

private String login; 
private String password; 
private Employe employe;
private Boolean loggedIn;
private Boolean isActif;
private String email;
private Role role;
private String ladate ;
private List<Employe> employes; 
private Integer employeIdToBeUpdated;


public EmployeController() {

super();
employe=new Employe();
loggedIn = false;

}
public String ajouterEmploye(){
String navigateTo="null";

if(!loggedIn) return "/login.xhtml";

iEmployeService.ajouterEmploye(new Employe(login, password, email, role,isActif));
navigateTo = "/welcome.xhtml?faces-redirect=true";
return navigateTo;

}

public String dologin() {

String navigateTo = "null";
Employe employe=iEmployeService.getEmployeByEmailAndPassword(login, password);
if (employe != null && employe.getRole() == Role.ADMINISTRATEUR) {
navigateTo = "/welcome.xhtml?faces-redirect=true";
loggedIn = true;
}
else
{
FacesMessage facesMessage =
                new FacesMessage("Login Failed: please check your username/password and try again.");
            FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
}
return navigateTo;
}
public void removeEmploye(int employeid)
{
iEmployeService.deleteEmploye(employeid);
}
public String doLogout()
{FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
return "/login.xhtml?faces-redirect=true";
}
public IEmployeService getiEmployeService() {
	return iEmployeService;
}
public void setiEmployeService(IEmployeService iEmployeService) {
	this.iEmployeService = iEmployeService;
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
public Employe getEmploye() {
	return employe;
}

public void setEmploye(Employe employe) {
	this.employe = employe;
}

public Boolean getLoggedIn() {
	return loggedIn;
}



public void setLoggedIn(Boolean loggedIn) {
	this.loggedIn = loggedIn;
}

public Boolean getIsActif() {
	return isActif;
}

public void setIsActif(Boolean isActif) {
	this.isActif = isActif;
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
public List<Employe> getEmployes() {
employes = iEmployeService.getAllEmployes();
return employes;
}
public void setEmployes(List<Employe> employes) {
	this.employes = employes;
}
public Integer getEmployeIdToBeUpdated() {
	return employeIdToBeUpdated;
}
public void setEmployeIdToBeUpdated(Integer employeIdToBeUpdated) {
	this.employeIdToBeUpdated = employeIdToBeUpdated;
}


public String getLadate() {
	return ladate;
}
public void setLadate(String ladate) {
	this.ladate = ladate;
}
public void modifier(Employe employe)
{
this.setEmail(employe.getEmail());
this.setIsActif(employe.getIsActif());
this.setLogin(employe.getLogin());
this.setPassword(employe.getPassword());
this.setRole(employe.getRole());
this.setEmployeIdToBeUpdated(employe.getId());
}
public void mettreAjourEmploye()
{ 
Employe e=new Employe(employeIdToBeUpdated, login,password, email, isActif, role);
iEmployeService.updateEmploye(e);}

    
}
