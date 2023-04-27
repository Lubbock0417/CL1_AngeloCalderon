package main;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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
		doc2.setNomDoctor("Pedro");
		doc2.setEspecialidadDoctor("Urologo");
		em.persist(doc2);
		
		Doctore doc3 = new Doctore();
		doc3.setNomDoctor("Luis");
		doc3.setEspecialidadDoctor("Cardiologo");
		em.persist(doc3);
		em.getTransaction().commit();
		
		
		
		Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 3) {
            System.out.println("Menú:");
            System.out.println("1. Ingresar Cita");
            System.out.println("2. Mostrar Citas del doctor");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                	// Código para ingresar cita
                	System.out.print("Ingrese el número de cita: ");
                	String numCita = scanner.next();
                	System.out.print("Ingrese la fecha de la cita (YYYY-MM-DD): ");
                	String fechaCita = scanner.next();
                	System.out.print("Ingrese el nombre del paciente: ");
                	String nomPaciente = scanner.next();
                	System.out.print("Ingrese el ID del doctor: ");
                	int idDoctor = scanner.nextInt();
                	
                	Doctore doctor = em.find(Doctore.class, idDoctor);

                	if (doctor != null) {
                	    Cita cita1 = new Cita();
                	    cita1.setNumCita(numCita);
                	    cita1.setFechaCita(fechaCita);
                	    cita1.setNomPacienteCita(nomPaciente);
                	    cita1.setDoctore(doctor);

                	    em.getTransaction().begin();
                	    em.persist(cita1);
                	    em.getTransaction().commit();
                	} else {
                	    System.out.println("Doctor no encontrado");
                	}
    				break;
                case 2:
                	System.out.print("Ingrese el nombre del doctor: ");
                	String nomDoctor = scanner.next();

                	TypedQuery<Cita> query = em.createQuery("SELECT c FROM Cita c JOIN c.doctore d WHERE d.nomDoctor = :nomDoctor", Cita.class);
                	query.setParameter("nomDoctor", nomDoctor);
                	List<Cita> citas = query.getResultList();
                	for (Cita cita : citas) {
                	    System.out.println("Cita: " + cita.getNumCita() + " - Fecha: " + cita.getFechaCita() + " - Paciente: " + cita.getNomPacienteCita());
                	}
                	em.close();
    
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 3);
		
	}
}
