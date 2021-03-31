package com.petrenko.lab0302.console;

import com.petrenko.lab0302.dao.UserDao;
import com.petrenko.lab0302.entity.User;
import com.petrenko.lab0302.framework.State;

public class LoginMenu extends State {

	public LoginMenu() {
		super("LoginMenu");
	}

	@Override
	protected void initialize() {
		controller.persistData.remove("user");
		
		startPrint();
		print("Please input your login information now");
		endPrint();
	}

	@Override
	protected void update() {
		User user = UserDao.getUser(getString("Username"), getString("Password"));
		if(user != null) {
			controller.persistData.put("user", user);
			changeState("UserMenu");
			return;
		}
		startPrint();
		print("Invalid Credentials, do you wish to:");
		printOp("LoginMenu", "RETRY");
		printOp("MainMenu", "RETURN TO MAIN MENU");
		endPrint();
		inputOp();

	}

	@Override
	protected void exit() {
	}

}
