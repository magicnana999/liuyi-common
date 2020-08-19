package com.creolophus.liuyi.common.json;

import java.util.Date;


/**
* @author magicnana
* @date 2019-07-25
*/

public class Client  {

	private String clientKey ;
	private Integer clientType ;
	private Integer h5Require ;
	private Integer state ;
	private String description ;
	private Date createTime ;
	private Date updateTime ;

	public Client() {
	}

	public String getClientKey(){
		return  clientKey;
	}
	public void setClientKey(String clientKey ){
		this.clientKey = clientKey;
	}

	public Integer getClientType(){
		return  clientType;
	}
	public void setClientType(Integer clientType ){
		this.clientType = clientType;
	}

	public Date getCreateTime(){
		return  createTime;
	}

	public void setCreateTime(Date createTime ){
		this.createTime = createTime;
	}

	public String getDescription(){
		return  description;
	}

	public void setDescription(String description ){
		this.description = description;
	}

	public Integer getH5Require(){
		return  h5Require;
	}

	public void setH5Require(Integer h5Require ){
		this.h5Require = h5Require;
	}

	public Integer getState(){
		return  state;
	}

	public void setState(Integer state ){
		this.state = state;
	}

	public Date getUpdateTime(){
		return  updateTime;
	}

	public void setUpdateTime(Date updateTime ){
		this.updateTime = updateTime;
	}

	public String h5RequireDesc(){
		return H5Require.YES.getValue()==this.getH5Require()?"必填":"可选";
	}

	@Override
	public String toString() {
		return clientKey;
	}

	public enum ClientType {
		IOS(1),
		ANDROID(2),
		WEB(3),
		;

		int value;

		ClientType(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}

		public static boolean isAndroid(int value){
			if(value == ANDROID.getValue()){
				return true;
			}else{
				return false;
			}
		}

		public static boolean isIOS(int value){
			if(value == IOS.getValue()){
				return true;
			}else{
				return false;
			}
		}

		public static ClientType valueOf(Integer value) {

			if(value==null){
				return null;
			}

			for (ClientType state : ClientType.values()) {
				if(state.getValue() == value) {
					return state;
				}
			} return null;
		}
	}

	public enum H5Require {
		NO(0),
		YES(1),
		;

		int value;
		String desc;

		H5Require(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}

		public static H5Require valueOf(Integer value) {

			if(value==null){
				return null;
			}


			for (H5Require state : H5Require.values()) {
				if(state.getValue() == value) {
					return state;
				}
			} return null;
		}
	}
}
