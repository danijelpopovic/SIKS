package actions;

public class ActionManager {

	private AddNewFaza addNewFaza;
	private AddNewKorak addNewKorak;
	private AddNewModel addNewModel;
	private SubmitAddFaza submitAddFaza;
	
	public ActionManager(){
		initialiseActions();
	}
	
	private void initialiseActions() {
		
		addNewFaza = new AddNewFaza();
		addNewKorak = new AddNewKorak();
		addNewModel = new AddNewModel();
		submitAddFaza = new SubmitAddFaza();
	}

	
	
	public AddNewFaza getAddNewFaza() {
		return addNewFaza;
	}

	public void setAddNewFaza(AddNewFaza addNewFaza) {
		this.addNewFaza = addNewFaza;
	}

	public AddNewKorak getAddNewKorak() {
		return addNewKorak;
	}

	public void setAddNewKorak(AddNewKorak addNewKorak) {
		this.addNewKorak = addNewKorak;
	}

	public AddNewModel getAddNewModel() {
		return addNewModel;
	}

	public void setAddNewModel(AddNewModel addNewModel) {
		this.addNewModel = addNewModel;
	}

	public SubmitAddFaza getSubmitAddFaza() {
		return submitAddFaza;
	}

	public void setSubmitAddFaza(SubmitAddFaza submitAddFaza) {
		this.submitAddFaza = submitAddFaza;
	}
	
	
	
}
