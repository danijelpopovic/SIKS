package services;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Faza;
import model.Korak;

public class KorakService {
	protected EntityManager em;

	public KorakService(EntityManager em) {
		this.em = em;
	}

	public Korak createKorak(int id, String naziv, Faza faza) {
		Korak emp = new Korak(id);
		
		emp.setNaziv(naziv);		
		emp.setFaza(faza);
		em.persist(emp);

		return emp;
	}

	public void removeKorak(int id) {
		Korak emp = findKorak(id);
		if (emp != null) {
			em.remove(emp);
		}
	}

	public Korak findKorak(int id) {
		return em.find(Korak.class, id);
	}

	@SuppressWarnings("unchecked")
	public Collection<Korak> findAllKoraci() {
		Query query = em.createQuery("SELECT k FROM Koraci k");
		return (Collection<Korak>) query.getResultList();
	}
}
