package services;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.StrukturaModela;

public class StrukturaModelaService {
	protected EntityManager em;

	public StrukturaModelaService(EntityManager em) {
		this.em = em;
	}

	public StrukturaModela createStrukturaModela(int id, double nivo,
			double polozaj) {
		StrukturaModela emp = new StrukturaModela(id);
		emp.setNivo(nivo);
		emp.setPolozajUNivou(polozaj);

		em.persist(emp);

		return emp;
	}

	public void removeStrukturaModela(int id) {
		StrukturaModela emp = findStrukturaModela(id);
		if (emp != null) {
			em.remove(emp);
		}
	}

	public StrukturaModela findStrukturaModela(int id) {
		return em.find(StrukturaModela.class, id);
	}

	@SuppressWarnings("unchecked")
	public Collection<StrukturaModela> findAllStrukturaModela() {
		Query query = em.createQuery("SELECT e FROM StrukturaModela e");
		return (Collection<StrukturaModela>) query.getResultList();
	}

}
