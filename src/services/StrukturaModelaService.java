package services;

import java.util.Collection;

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

	public StrukturaModela createStrukturaModela(int id, ModelZCSoftvera model,
			Korak korak, Korak prethodni_korak, Korak sledeci_korak) {
		StrukturaModela emp = new StrukturaModela(id);
		emp.setModel(model);
		emp.setKorak(korak);
		emp.setPrethodni_korak(prethodni_korak);
		emp.setSledeci_korak(sledeci_korak);		

		em.persist(emp);

		return emp;
	}
	
	public StrukturaModela createStrukturaModelaSamoPrethodni(int id, ModelZCSoftvera model,
			Korak korak, Korak prethodni_korak) {
		StrukturaModela emp = new StrukturaModela(id);
		emp.setModel(model);
		emp.setKorak(korak);
		emp.setPrethodni_korak(prethodni_korak);		

		em.persist(emp);

		return emp;
	}
	
	public StrukturaModela createStrukturaModelaSamoSledeci(int id, ModelZCSoftvera model,
			Korak korak, Korak sledeci_korak) {
		StrukturaModela emp = new StrukturaModela(id);
		emp.setModel(model);
		emp.setKorak(korak);
		emp.setSledeci_korak(sledeci_korak);		

		em.persist(emp);

		return emp;
	}
	
	public StrukturaModela createStrukturaModelaSamoKorak(int id, ModelZCSoftvera model,
			Korak korak) {
		StrukturaModela emp = new StrukturaModela(id);
		emp.setModel(model);
		emp.setKorak(korak);		

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
