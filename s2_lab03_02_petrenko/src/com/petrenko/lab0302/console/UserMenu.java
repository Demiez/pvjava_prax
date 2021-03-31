package com.petrenko.lab0302.console;

import com.petrenko.lab0302.framework.State;

public class UserMenu extends State {

	public UserMenu() {
		super("UserMenu");
	}

	@Override
	protected void initialize() {
		startPrint();
		printOp("MainMenu", "LOGOUT");
		printOp("BuyMenu", "MAKE PURCHASE");
		printOp("ReturnMenu", "RETURN ITEM");
		printOp("ShowPurchases", "PURCHASE HISTORY");
		printOp("ShowUser", "ACCOUNT DETAILS");
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
