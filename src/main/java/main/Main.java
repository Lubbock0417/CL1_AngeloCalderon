package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import db.Conn;
import model.Doctore;
import model.Cita;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = Conn.getInstancia().getFactory().createEntityManager();
			
		em.getTransaction().begin();
		Doctore doc1 = new Doctore();
		doc1.setNomDoctor("Angelo");
		doc1.setEspecialidadDoctor("Odontologo");
		em.persist(doc1);
		
		Doctore doc2 = new Doctore();
		doc1.setNomDoctor("Pedro");
		doc1.setEspecialidadDoctor("Urologo");
		em.persist(doc2);
		
		Doctore doc3 = new Doctore();
		doc1.setNomDoctor("Luis");
		doc1.setEspecialidadDoctor("Cardiologo");
		em.persist(doc3);
		em.getTransaction().commit();
		
	}
}
