package services;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Faze;

public class FazeService {
	protected EntityManager em;

	public FazeService(EntityManager em) {
		this.em = em;
	}

	public Faze createFaze(int id, int oznaka, String naziv) {
		Faze emp = new Faze(id);
		
		emp.setOznaka(oznaka);
		emp.setNazivFaze(naziv);

		// emp.setKoraci(koraci);
		em.persist(emp);

		return emp;
	}

	public void removeFaze(int id) {
		Faze emp = findFaze(id);
		if (emp != null) {
			em.remove(emp);
		}
	}

	public Faze findFaze(int id) {
		return em.find(Faze.class, id);
	}

	@SuppressWarnings("unchecked")
	public Collection<Faze> findAllFaze() {
		Query query = em.createQuery("SELECT e FROM Faze e");
		return (Collection<Faze>) query.getResultList();
	}

}
