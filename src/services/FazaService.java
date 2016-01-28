package services;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Faza;

public class FazaService {
	protected EntityManager em;

	public FazaService(EntityManager em) {
		this.em = em;
	}

	public Faza createFaza(int id, String naziv) {
		Faza emp = new Faza(id);
		
		emp.setNazivFaze(naziv);

		em.persist(emp);

		return emp;
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
		Query query = em.createQuery("SELECT e FROM Faze e");
		return (Collection<Faza>) query.getResultList();
	}

}
