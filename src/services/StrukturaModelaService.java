package services;

import java.util.Collection;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Korak;
import model.ModelZCSoftvera;
import model.StrukturaModela;


public class StrukturaModelaService {
	protected EntityManager em;

	public StrukturaModelaService(EntityManager em) {
		this.em = em;
	}

	public StrukturaModela createStrukturaModela(int id, int nivo,
			int polozaj, ModelZCSoftvera model, Korak korak) {
		StrukturaModela emp = new StrukturaModela(id);
		emp.setNivo(nivo);
		emp.setPolozajUNivou(polozaj);
		emp.setModel(model);
		emp.setKorak(korak);

		em.persist(emp);

		return emp;
	}
	
	public StrukturaModela createPovezanaStrukturaModela(int id, int nivo,
			int polozaj, ModelZCSoftvera model, Korak korak, Set<StrukturaModela> struktureModela) {
		StrukturaModela emp = new StrukturaModela(id);
		emp.setNivo(nivo);
		emp.setPolozajUNivou(polozaj);
		emp.setModel(model);
		emp.setKorak(korak);
		emp.setStruktureModela(struktureModela);

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
