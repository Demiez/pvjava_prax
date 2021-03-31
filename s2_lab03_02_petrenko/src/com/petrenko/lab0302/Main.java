package com.petrenko.lab0302;

import com.petrenko.lab0302.dao.DaoManager;
import com.petrenko.lab0302.framework.StateController;
import com.petrenko.lab0302.console.BuyMenu;
import com.petrenko.lab0302.console.LoginMenu;
import com.petrenko.lab0302.console.MainMenu;
import com.petrenko.lab0302.console.RegisterMenu;
import com.petrenko.lab0302.console.ReturnMenu;
import com.petrenko.lab0302.console.ShowUser;
import com.petrenko.lab0302.console.ShowPurchases;
import com.petrenko.lab0302.console.UserMenu;

public class Main {

	public static void main(String[] args) {
		StateController controller = new StateController();
		
		// Ініціналізація бази даних
		DaoManager.initializeRemote();
//		DaoManager.initializeLocal();
		
		// Дадаємо стейти
		controller.addState(new MainMenu());
		controller.addState(new BuyMenu());
		controller.addState(new LoginMenu());
		controller.addState(new RegisterMenu());
		controller.addState(new ReturnMenu());
		controller.addState(new UserMenu());
		controller.addState(new ShowUser());
		controller.addState(new ShowPurchases());
		
		// Запускаємо
		controller.run("MainMenu");
	}

}
