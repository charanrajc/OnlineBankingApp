package com.onlinebank.forms;

public class Customer {
	
	private String USERNAME ;
	private String PASSWORD;
	private String SEC_QUESTION;
	private String ANSWER;
	private String ADDRESS;
	private String EMAIL_ADDRESS;
	private String MOBILE_NUMBER;
	
	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getSEC_QUESTION() {
		return SEC_QUESTION;
	}
	public void setSEC_QUESTION(String sEC_QUESTION) {
		SEC_QUESTION = sEC_QUESTION;
	}
	public String getANSWER() {
		return ANSWER;
	}
	public void setANSWER(String aNSWER) {
		ANSWER = aNSWER;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public String getEMAIL_ADDRESS() {
		return EMAIL_ADDRESS;
	}
	public void setEMAIL_ADDRESS(String eMAIL_ADDRESS) {
		EMAIL_ADDRESS = eMAIL_ADDRESS;
	}
	public String getMOBILE_NUMBER() {
		return MOBILE_NUMBER;
	}
	public void setMOBILE_NUMBER(String mOBILE_NUMBER) {
		MOBILE_NUMBER = mOBILE_NUMBER;
	}
	
}
