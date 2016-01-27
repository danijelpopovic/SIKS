package services;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.ModelZcSoftvera;

public class ModelZcSoftveraService {
	protected EntityManager em;

	public ModelZcSoftveraService(EntityManager em) {
		this.em = em;
	}

	public ModelZcSoftvera createModelZcSoftvera(int id, int oznaka,
			String naziv, String skraceniNaziv, String opis) {
		ModelZcSoftvera emp = new ModelZcSoftvera(id);
		emp.setNaziv(naziv);
		emp.setOpis(opis);
		emp.setOznaka(oznaka);
		emp.setSkraceniNaziv(skraceniNaziv);
		//emp.setStrukturaModela(strukturaModela);
		em.persist(emp);

		return emp;
	}

	public void removeProfessor(int id) {
		ModelZcSoftvera emp = findModelZcSoftvera(id);
		if (emp != null) {
			em.remove(emp);
		}
	}

	public ModelZcSoftvera findModelZcSoftvera(int id) {
		return em.find(ModelZcSoftvera.class, id);
	}

	@SuppressWarnings("unchecked")
	public Collection<ModelZcSoftvera> findAllModelZcSoftvera() {
		Query query = em.createQuery("SELECT e FROM ModelZcSoftvera e");
		return (Collection<ModelZcSoftvera>) query.getResultList();
	}
}
