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
		em.getTransaction().begin();
		Korak emp = new Korak(id);
		
		emp.setNaziv(naziv);		
		emp.setFaza(faza);
		emp.setPozicija(0);
		em.persist(emp);
		em.getTransaction().commit();
		return emp;
	}
	
	public Korak updateKorak(int id, String naziv, Faza faza, int pozicija) {
		em.getTransaction().begin();
		Korak emp = em.find(Korak.class, id);
		emp.setNaziv(naziv);		
		emp.setFaza(faza);
		emp.setPozicija(pozicija);
		em.persist(emp);
		em.getTransaction().commit();
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
	
	public Korak findKorakByNaziv(String naziv) {
		Query query = em.createQuery("SELECT k FROM Korak k WHERE k.naziv= :nazivKoraka", Korak.class);
		query.setParameter("nazivKoraka", naziv);
		return (Korak) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public Collection<Korak> findAllKoraci() {
		Query query = em.createQuery("SELECT k FROM Korak k");
		return (Collection<Korak>) query.getResultList();
	}
}
