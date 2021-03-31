package com.petrenko.lab0302.console;

import com.petrenko.lab0302.entity.Invoice;
import com.petrenko.lab0302.entity.Item;
import com.petrenko.lab0302.entity.User;
import com.petrenko.lab0302.framework.State;
import com.petrenko.lab0302.utility.ConsoleExtras;

public class ShowPurchases extends State {

	public ShowPurchases() {
		super("ShowPurchases");
	}

	@Override
	protected void initialize() {
		User user = (User) controller.persistData.get("user");
		startPrint();
		if(user.purchases.isEmpty()) {
			print("No Purchases");
		}
		else {
			boolean first = true;
			for(Invoice invoice : user.purchases) {
				if(!first)
					printSeparator();
				else
					first = false;
				print("Customer:", invoice.custName);
				print("Date:", invoice.date.toString());
				print("Invoice Number:", Integer.toString(invoice.invoiceNum));
				print("");
				print("Item", "Item Code", "Price");
				for(Item item : invoice.items)
					print(item.name, item.code, "$" + ConsoleExtras.parseAmount(item.price));
				
			}
		}
		endPrint();
	}

	@Override
	protected void update() {
		pause();
		changeState("UserMenu");
	}

	@Override
	protected void exit() {
		// TODO Auto-generated method stub

	}

}
