package services;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Koraci;

public class KoraciService {
	protected EntityManager em;

	public KoraciService(EntityManager em) {
		this.em = em;
	}

	public Koraci createKoraci(int id, String naziv) {
		Koraci emp = new Koraci(id);
		emp.setNaziv(naziv);
		
		//emp.setStrukturaModela(strukturaModela);
		em.persist(emp);

		return emp;
	}

	public void removeKoraci(int id) {
		Koraci emp = findKoraci(id);
		if (emp != null) {
			em.remove(emp);
		}
	}

	public Koraci findKoraci(int id) {
		return em.find(Koraci.class, id);
	}

	@SuppressWarnings("unchecked")
	public Collection<Koraci> findAllKoraci() {
		Query query = em.createQuery("SELECT e FROM Koraci e");
		return (Collection<Koraci>) query.getResultList();
	}
}
