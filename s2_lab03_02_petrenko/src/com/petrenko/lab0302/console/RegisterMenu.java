package com.petrenko.lab0302.console;

import com.petrenko.lab0302.dao.UserDao;
import com.petrenko.lab0302.entity.User;
import com.petrenko.lab0302.framework.State;

public class RegisterMenu extends State {
	
	User user;

	public RegisterMenu() {
		super("RegisterMenu");
	}

	@Override
	protected void initialize() {
		startPrint();
		print("Please input your registration information now");
		endPrint();
		user = new User();
	}

	@Override
	protected void update() {
		user.name = getString("Username");
		if(UserDao.userExists(user.name)) {
			startPrint();
			print("Username already in use, do you wish to:");
			printOp("RegisterMenu", "RETRY");
			printOp("MainMenu", "RETURN TO MAIN MENU");
			endPrint();
			inputOp();
			return;
		}

		while(!(user.email = getString("Email")).matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
			System.out.println("Please input a valid email");
		}

		while(!(user.password = getString("Password")).equals(getString("Confirm Password"))) {
			System.out.println("Passwords don't match, please input them again");
		}
			UserDao.addUser(user);
			changeState("MainMenu");
	}

	@Override
	protected void exit() {
		user = null;
	}

}
