package app;

import gui.MainFrame;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Faze;
import model.Koraci;
import model.ModelZcSoftvera;
import model.StrukturaModela;
import services.FazeService;
import services.KoraciService;
import services.ModelZcSoftveraService;
import services.StrukturaModelaService;
import util.JPAUtil;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			JPAUtil util = new JPAUtil();

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("SIKS");
			EntityManager em = emf.createEntityManager();
			
			ModelZcSoftveraService mzcss = new ModelZcSoftveraService(em);
			KoraciService ks = new KoraciService(em);
			FazeService fs = new FazeService(em);
			StrukturaModelaService sms = new StrukturaModelaService(em);

			em.getTransaction().begin();
			ModelZcSoftvera emp1 = mzcss.createModelZcSoftvera(0, 1, "Model", "mdl", "Test model");
			Koraci emp2 = ks.createKoraci(0, "Prvi korak");
			Faze emp3 = fs.createFaze(0, 3, "Prva faza");
			StrukturaModela emp4 = sms.createStrukturaModela(0, 4, 5);
			// service.removeProfessor(1);
			em.getTransaction().commit();
			System.out.println("Persisted " + emp1);
			System.out.println("Persisted " + emp2);
			System.out.println("Persisted " + emp3);
			System.out.println("Persisted " + emp4);

			util.checkData("select * from ModelZcSoftvera");
			util.checkData("select * from Koraci");
			util.checkData("select * from Faze");
			util.checkData("select * from StrukturaModela");

			em.close();
			emf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// DBConnection.getConnection();

		try {
			MainFrame mf = MainFrame.getInstance();
			mf.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
