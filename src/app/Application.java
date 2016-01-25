package app;

import gui.MainFrame;
import db.DBConnection;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnection.getConnection();
		
		try
        {
			MainFrame mf = MainFrame.getInstance();
    		mf.setVisible(true);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
	}

}
