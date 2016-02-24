package services;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.ModelZCSoftvera;

public class ModelZCSoftveraService {
	protected EntityManager em;

	public ModelZCSoftveraService(EntityManager em) {
		this.em = em;
	}

	public ModelZCSoftvera createModelZcSoftvera(int id,
			String naziv, String skraceniNaziv, String opis) {
		em.getTransaction().begin();
		ModelZCSoftvera emp = new ModelZCSoftvera(id);
		emp.setNaziv(naziv);
		emp.setOpis(opis);
		emp.setSkraceniNaziv(skraceniNaziv);
		
		em.persist(emp);
		em.getTransaction().commit();

		return emp;
	}

	public ModelZCSoftvera findModelZcSoftvera(int id) {
		return em.find(ModelZCSoftvera.class, id);
	}

	@SuppressWarnings("unchecked")
	public Collection<ModelZCSoftvera> findAllModelZcSoftvera() {
		Query query = em.createQuery("SELECT e FROM ModelZCSoftvera e");
		return (Collection<ModelZCSoftvera>) query.getResultList();
	}
}
