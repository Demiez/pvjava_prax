package com.petrenko.lab0302.console;

import com.petrenko.lab0302.framework.State;

public class MainMenu extends State {

	public MainMenu() {
		super("MainMenu");
	}

	@Override
	protected void initialize() {
		startPrint();
		printOp("RegisterMenu", "REGISTER");
		printOp("LoginMenu", "LOGIN");
		printOp(null, "EXIT");
		endPrint();
	}

	@Override
	protected void update() {
		inputOp();
	}

	@Override
	protected void exit() {
	}

}
