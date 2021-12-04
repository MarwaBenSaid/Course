package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Employe;

public interface IEmployeService {
	public Employe getEmployeByEmailAndPassword(String login, String password) ;
	public void ajouterEmploye(Employe e);
	public void updateEmploye(Employe e);
	public void deleteEmploye(int employeid);
	public List<Employe> getAllEmployes() ;

	

	
	

}
