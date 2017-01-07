package com.bolion.user.bean;

import com.bolion.common.Config;

public class UserInfo {
	
	
	private String  username="";
	
	private String  headimg="";
	
	private int  usersex;
	
	private String usersexname="";
	
	private String usertele="";
	
	private int userold;
	
	private String useroldname="";
	
	private int userbusiness;
	
	private int userprovince;
	
	private String userbusinessname="";
	
	private int userdistrict;
	
	private String usercompany="";
	
	
	private int usercity;
	
	private String userdistrictame="";
	
	private String cityname="";
	
	private int userteamtype=0;
	
	private String userteamtypename="";
	
	private String userteamimg="";
	
	private int isupdate=0;
	
	private int userverifystate;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHeadimg() {
		if(isupdate==1){
			return headimg;
		}
		 return Config.getWspath()+Config.getFilerootname()+ headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

	public int getUsersex() {
		return usersex;
	}

	public void setUsersex(int usersex) {
		this.usersex = usersex;
	}

	public String getUsersexname() {
		return usersexname;
	}

	public void setUsersexname(String usersexname) {
		this.usersexname = usersexname;
	}

	public String getUsertele() {
		return usertele;
	}

	public void setUsertele(String usertele) {
		this.usertele = usertele;
	}

	public int getUserold() {
		return userold;
	}

	public void setUserold(int userold) {
		this.userold = userold;
	}

	public String getUseroldname() {
		return useroldname;
	}

	public void setUseroldname(String useroldname) {
		this.useroldname = useroldname;
	}

	public int getUserbusiness() {
		return userbusiness;
	}

	public void setUserbusiness(int userbusiness) {
		this.userbusiness = userbusiness;
	}

	public String getUserbusinessname() {
		return userbusinessname;
	}

	public void setUserbusinessname(String userbusinessname) {
		this.userbusinessname = userbusinessname;
	}

	
	public String getUsercompany() {
		return usercompany;
	}

	public void setUsercompany(String usercompany) {
		this.usercompany = usercompany;
	}

	public int getUsercity() {
		return usercity;
	}

	public void setUsercity(int usercity) {
		this.usercity = usercity;
	}

	
	
	public int getUserdistrict() {
		return userdistrict;
	}

	public void setUserdistrict(int userdistrict) {
		this.userdistrict = userdistrict;
	}

	public String getUserdistrictame() {
		return userdistrictame;
	}

	public void setUserdistrictame(String userdistrictame) {
		this.userdistrictame = userdistrictame;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public int getUserteamtype() {
		return userteamtype;
	}

	public void setUserteamtype(int userteamtype) {
		this.userteamtype = userteamtype;
	}

	public String getUserteamtypename() {
		return userteamtypename;
	}

	public void setUserteamtypename(String userteamtypename) {
		this.userteamtypename = userteamtypename;
	}

	public String getUserteamimg() {
		if(isupdate==1){
			return userteamimg;
		}
		 return Config.getWspath()+Config.getFilerootname()+ userteamimg;
	}

	public void setUserteamimg(String userteamimg) {
		this.userteamimg = userteamimg;
	}

	public int getIsupdate() {
		return isupdate;
	}

	public void setIsupdate(int isupdate) {
		this.isupdate = isupdate;
	}

	public int getUserverifystate() {
		return userverifystate;
	}

	public void setUserverifystate(int userverifystate) {
		this.userverifystate = userverifystate;
	}

	public int getUserprovince() {
		return userprovince;
	}

	public void setUserprovince(int userprovince) {
		this.userprovince = userprovince;
	}
	
	
	
	
	
	

	
	
	
	

}
