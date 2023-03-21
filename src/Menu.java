import java.io.IOException;
import java.security.KeyStore.Entry;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;


public class Menu extends Demo {
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

	
	HashMap<Integer, Integer> data = new HashMap<Integer,Integer>();
	public void getLogin()throws IOException {
		int x=1;
		do {
			try {
				data.put(123456, 123);
				data.put(212212, 212);
				System.out.println("Welcome to Atm");
				System.out.println("Enter the number");
				setCustomerNumber(menuInput.nextInt());
				System.out.println("enter the pin number");
				setPinNumber(menuInput.nextInt());
				
			}catch(Exception e) {
				System.out.println("Invalid character , enter only number"+"\n");
				x=2;
				
			}
			for(java.util.Map.Entry<Integer, Integer> entry:data.entrySet()) {
				if(entry.getKey()==getCustomerNumber()&&entry.getValue()==getPinNumber()) {
					getAccountType();
				}
			}
			System.out.println("wrong customer number or id"+"\n");
		}while(x==1);
		
	}
	int selection;
	public void getAccountType() {
		System.out.println("Select the account we want to access");
		System.out.println("Type1: checking account");
		System.out.println("Type2: saving Acoount");
		System.out.println("Type3:Exit");
		System.out.println("Choice:");
		selection  = menuInput.nextInt();
		switch (selection) {
		case 1:
			getCheckingBalance();
			break;
		case 2:
			getSavingBalance();
			break;
		case 3:
			System.out.println("Thank you");
			break;
		default:
			System.out.println("Invalid choice"+"\n");
			getAccountType();
		}
	}
	public void getChecking() {
		System.out.println("Checking Account");
		System.out.println("Type1: View Balance");
		System.out.println("Type2: withdraw funds");
		System.out.println("Type3: Deposit funds");
		System.out.println("Type4: Exist");
		System.out.println("Choice:"+"\n");
		selection  = menuInput.nextInt();
		switch (selection) {
		case 1:
			System.out.println("Checking Account Balance"+moneyFormat.format(getCheckingBalance()));
			getAccountType();
			break;
		case 2:
			getCheckingWithdrawalInput();
			getAccountType();
			break;
		case 3:
			getCheckingDepositInput();
			getAccountType();
			break;
		default:
			System.out.println("Invalid choice"+"\n");
			getChecking();
		}
		
	}
	public void getSaving() {	
	System.out.println("Saving Account");
	System.out.println("Type1: View Balance");
	System.out.println("Type2: withdraw funds");
	System.out.println("Type3: Deposit funds");
	System.out.println("Type4: Exist");
	System.out.println("Choice:"+"\n");
	selection  = menuInput.nextInt();
	switch (selection) {
	case 1:
		System.out.println("Saving Account Balance"+moneyFormat.format(getSavingBalance()));
		getAccountType();
		break;
	case 2:
		getSavingWithdrawInput();
		getAccountType();
		break;
	case 3:
		getSavingDepositInput();
		getAccountType();
		break;
	default:
		System.out.println("Invalid choice"+"\n");
		getSaving();
	}
		
	}
	
	

}
