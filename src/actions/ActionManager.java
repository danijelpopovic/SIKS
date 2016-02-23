package actions;
import actions.*;

public class ActionManager {

	private AddNewFaza addNewFaza;
	private AddNewKorak addNewKorak;
	private AddNewModel addNewModel;
	private SubmitAddFaza submitAddFaza;
	private Set set;
	private SetSubmit setSubmit;
	private SetCancel setCancel;
	private KorakTable korakTable;
	private KorakTableSubmit korakTableSubmit;
	private DefineStructGet defineStructGet;
	private DefineStructSubmit defineStructSubmit;
	
	public ActionManager(){
		initialiseActions();
	}
	
	private void initialiseActions() {
		
		addNewFaza = new AddNewFaza();
		addNewKorak = new AddNewKorak();
		addNewModel = new AddNewModel();
		submitAddFaza = new SubmitAddFaza();
		set = new Set();
		setSubmit = new SetSubmit();
		setCancel = new SetCancel();
		korakTable= new KorakTable();
		korakTableSubmit = new KorakTableSubmit();
		defineStructGet = new DefineStructGet();
		defineStructSubmit = new DefineStructSubmit();
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

	public Set getSet() {
		return set;
	}

	public void setSet(Set set) {
		this.set = set;
	}

	public SetSubmit getSetSubmit() {
		return setSubmit;
	}

	public void setSetSubmit(SetSubmit setSubmit) {
		this.setSubmit = setSubmit;
	}

	public SetCancel getSetCancel() {
		return setCancel;
	}

	public void setSetCancel(SetCancel setCancel) {
		this.setCancel = setCancel;
	}

	public KorakTable getKorakTable() {
		return korakTable;
	}

	public void setKorakTable(KorakTable korakTable) {
		this.korakTable = korakTable;
	}

	public KorakTableSubmit getKorakTableSubmit() {
		return korakTableSubmit;
	}

	public void setKorakTableSubmit(KorakTableSubmit korakTableSubmit) {
		this.korakTableSubmit = korakTableSubmit;
	}

	public DefineStructGet getDefineStructGet() {
		return defineStructGet;
	}

	public void setDefineStructGet(DefineStructGet defineStructGet) {
		this.defineStructGet = defineStructGet;
	}

	public DefineStructSubmit getDefineStructSubmit() {
		return defineStructSubmit;
	}

	public void setDefineStructSubmit(DefineStructSubmit defineStructSubmit) {
		this.defineStructSubmit = defineStructSubmit;
	}
	
	
	
}
