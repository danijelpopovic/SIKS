package app;

import gui.MainFrame;
import util.DrawGraph;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*try {

			JPAUtil util = new JPAUtil();

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("SIKS");
			EntityManager em = emf.createEntityManager();
			
			ModelZCSoftveraService mzcss = new ModelZCSoftveraService(em);
			KorakService ks = new KorakService(em);
			FazaService fs = new FazaService(em);
			StrukturaModelaService sms = new StrukturaModelaService(em);

			em.getTransaction().begin();
			ModelZCSoftvera emp1 = mzcss.createModelZcSoftvera(0, "Model", "mdl", "Test model");
			Faza emp3 = fs.createFaza(0, "Prva faza");
			Korak emp2 = ks.createKorak(0, "Prvi korak", emp3);
			
			StrukturaModela emp4 = sms.createStrukturaModela(0, 4, 5, emp1, emp2);
			Set<StrukturaModela> strukture = new HashSet<StrukturaModela>();
			strukture.add(emp4);
			StrukturaModela emp5 = sms.createPovezanaStrukturaModela(0, 4, 5, emp1, emp2, strukture);
			// service.removeProfessor(1);
			em.getTransaction().commit();
			System.out.println("Persisted " + emp1);
			System.out.println("Persisted " + emp2);
			System.out.println("Persisted " + emp3);
			System.out.println("Persisted " + emp4);
			System.out.println("Persisted " + emp5);

			util.checkData("select * from ModelZcSoftvera");
			util.checkData("select * from Koraci");
			util.checkData("select * from Faze");
			util.checkData("select * from StrukturaModela");

			em.close();
			emf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		// DBConnection.getConnection();
		

		try {
			MainFrame mf = MainFrame.getInstance();
			
			mf.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
