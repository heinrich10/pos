package com.app.erp.model;

import java.io.Serializable;
import java.util.List;

public class TranList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4912898556302380600L;
	
	private List<Tran> tranList;
	
	public TranList(){
		
	}
	
	public TranList(List<Tran> tranList){
		this.setTranList(tranList);
	}

	public List<Tran> getTranList() {
		return tranList;
	}

	public void setTranList(List<Tran> tranList) {
		this.tranList = tranList;
	}
	
	

}
