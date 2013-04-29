package tcc.tcc1;

public class Contact {
     
    
    int _id;
    String _sex;
    String _age;
    int _result;
    String _diag;
    
     
    
    public Contact(){
         
    }

    
	public Contact(int _id, String _sex, String _age, int _result, String _diag) {
		super();
		this._id = _id;
		this._sex = _sex;
		this._age = _age;
		this._result = _result;
		this._diag = _diag;
	}
	

	/**
	 * @param _sex
	 * @param _age
	 * @param _result
	 * @param _diag
	 */
	public Contact(String _sex, String _age, int _result, String _diag) {
		super();
		this._sex = _sex;
		this._age = _age;
		this._result = _result;
		this._diag = _diag;
	}


	/**
	 * @return the _id
	 */
	public int get_id() {
		return _id;
	}



	/**
	 * @param _id the _id to set
	 */
	public void set_id(int _id) {
		this._id = _id;
	}



	/**
	 * @return the _sex
	 */
	public String get_sex() {
		return _sex;
	}



	/**
	 * @param _sex the _sex to set
	 */
	public void set_sex(String _sex) {
		this._sex = _sex;
	}



	/**
	 * @return the _age
	 */
	public String get_age() {
		return _age;
	}



	/**
	 * @param _age the _age to set
	 */
	public void set_age(String _age) {
		this._age = _age;
	}



	/**
	 * @return the _result
	 */
	public int get_result() {
		return _result;
	}



	/**
	 * @param _result the _result to set
	 */
	public void set_result(int _result) {
		this._result = _result;
	}


	/**
	 * @return the _diag
	 */
	public String get_diag() {
		return _diag;
	}


	/**
	 * @param _diag the _diag to set
	 */
	public void set_diag(String _diag) {
		this._diag = _diag;
	}



	
    
}