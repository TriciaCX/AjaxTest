package com.Tricia.ajaxServer;

public class ResultBean
{
	
	private String data;

	public ResultBean(String data){
	   this.setData(data);
	}

	public String getData(){
		return data;
	}

	public void setData(String data){
		this.data = data;
	}

}
