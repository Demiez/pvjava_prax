package com.petrenko.lab0302.console;

import com.petrenko.lab0302.entity.User;
import com.petrenko.lab0302.framework.State;

public class ShowUser extends State {

	public ShowUser() {
		super("ShowUser");
	}

	@Override
	protected void initialize() {
		User user = (User) controller.persistData.get("user");
		startPrint();
		print("Name", user.name);
		print("Email", user.email);
		print("Server-side password", user.password);
		endPrint();
	}

	@Override
	protected void update() {
		pause();
		changeState("UserMenu");
	}

	@Override
	protected void exit() {

	}

}
