package services;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.mapping.List;

import model.Faza;
import model.Korak;
import model.ModelZCSoftvera;
import model.StrukturaModela;

public class FazaService {
	protected EntityManager em;

	public FazaService(EntityManager em) {
		this.em = em;
	}

	public Faza createFaza(int id, String naziv) {
		em.getTransaction().begin();
		Faza emp = new Faza(id);
		emp.setNazivFaze(naziv);
		em.persist(emp);
		em.getTransaction().commit();
		return emp;
	}
	
	public Faza createFaza(int id, String naziv, int modelId) {
				
		
		em.getTransaction().begin();
		Faza faza = new Faza(id);
		faza.setNazivFaze(naziv);
		em.persist(faza);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		Korak korak = new Korak(0);
		korak.setNaziv("Korak 1");
		korak.setFaza(faza);
		em.persist(korak);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		ModelZCSoftvera model = em.find(ModelZCSoftvera.class, modelId);
		StrukturaModela struktura = new StrukturaModela(0);
		struktura.setNivo(1);
		struktura.setPolozajUNivou(0);
		struktura.setStruktureModela(new HashSet<StrukturaModela>());
		struktura.setModel(model);
		struktura.setKorak(korak);
		em.persist(struktura);
		
		em.getTransaction().commit();
		
		
		
		return faza;
	}

	public void removeFaza(int id) {
		Faza emp = findFaza(id);
		if (emp != null) {
			em.remove(emp);
		}
	}

	public Faza findFaza(int id) {
		return em.find(Faza.class, id);
	}

	@SuppressWarnings("unchecked")
	public Collection<Faza> findAllFaze() {
		Query query = em.createQuery("SELECT e FROM Faza e");
		return (Collection<Faza>) query.getResultList();
	}

}
