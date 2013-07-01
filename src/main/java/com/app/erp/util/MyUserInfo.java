package com.app.erp.util;


import com.jcraft.jsch.UIKeyboardInteractive;
import com.jcraft.jsch.UserInfo;

public class MyUserInfo implements UserInfo, UIKeyboardInteractive {
	
	
	@Override
	public String[] promptKeyboardInteractive(String arg0, String arg1,
			String arg2, String[] arg3, boolean[] arg4) {
		// TODO Auto-generated method stub
		return null;
		
	}

	@Override
	public String getPassphrase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
		
	}

	@Override
	public boolean promptPassphrase(String arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean promptPassword(String arg0) {
		// TODO Auto-generated method stub
		 return false;
	}

	@Override
	public boolean promptYesNo(String arg0) {
		// TODO Auto-generated method stub
		//return true for the mean time
		return true;
	}

	@Override
	public void showMessage(String arg0) {
		// TODO Auto-generated method stub
		
	}

}
