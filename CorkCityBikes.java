import java.util.Scanner;
import java.text.DecimalFormat;
public class CorkCityBikes {
	static DecimalFormat Money = new DecimalFormat ("€###,##0.00");
	static String Email,PIN,MPIN,Username,Damage;
	static int Number,Minutes, CreditCard;
	static double Fee;
	static char Locked,subscription,Log,Damage1;


	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		
		//Entering user name and pin
	
		System.out.print("Enter Email:\t");
		Email = sc.next();
		System.out.print("Enter PIN:\t");
		PIN = sc.next();
		SkillsDemo3.checkLoginCredentials(Email, PIN);
		System.out.println("What is the number of the bike being returned?");
		Number = sc.nextInt();
		
		//locking bike into hub
		
		do {
			System.out.println("Is the bike ready to be locked within the bank?");
			Locked = sc.next().charAt(Locked);
			switch (Locked) {
			case 'y': {
				System.out.println("The bike is now locking");
				break;
			}
			case 'n': {
				System.out.println("Please place bike into bank where it can be locked!");
				break;
			}
			}
		} while (Locked =='n');
		
		// Credit card info
		
		System.out.println("The cost of renting the bike will be calculated and deducted from your account,"
				+ "If you do not have enough money in your account it will debited from your credit card account!");
		
		System.out.println("Enter your credit card number:\t");
		CreditCard = sc.nextInt();
		
		
		//Calculating fees and hours
		
		System.out.println("Enter in minutes how long you rented a bike:\t");
		Minutes = sc.nextInt();
		if	(Minutes <=30) {
			Fee = 0;
		}
		else if (Minutes >=30 && Minutes <60) {
			Fee = 0.50;
		}
		else if (Minutes >=60 && Minutes <120) {
			Fee = 1.50;
		}
		else if (Minutes >=120 && Minutes <180) {
			Fee = 6.50;
		}
		else if (Minutes >180) {
			Fee = 6.50*(0.20*Minutes) ;
		}
		System.out.println("Your fee for renting the bike is:\t" + Fee) ;
		
		//Bike Maintenance
		
		System.out.println("Is there any damage done to the bike?:\t");
		Damage1 = sc.next().charAt(0);
		switch (Damage1) {
		case 'y' : {
			System.out.println("Enter the number of the bike that is damaged:\t");
			Number = sc.nextInt();
			System.out.println("What is the fault with the bike:\t");
			Damage = sc.next();
			String errorBike = sc.nextLine();
			SkillsDemo3.appendToMaintenanceLog(errorBike);
			System.out.println("This bike is now permanently locked!");
		}
		case 'n' : {
			System.out.println("Thank you for using Cork City Bikes!");
		}
		}
		
		// Maintenance Department
		
		System.out.print("Would you like to view the maintenance log?:\t");
		Log = sc.next().charAt(0);
		do {
			do {
				///switch (Log)  {
				//case 'y' :{
				System.out.print("Enter Username:\t");
				Username = sc.next();
				if (!Username.equals("maintenance"))
					System.err.println("That username is not valid!");
			} while (!Username.equals("maintenance"));
			do {
				System.out.print("Enter PIN:\t");
				MPIN = sc.next();
				if (!MPIN.equals("m13310n")) {
					System.err.println("That Pin is not valid!");
				}
				//case 'n' : {
			} while (!MPIN.equals("m13310n"));
		} while (!Username.equals("maintenance") && !MPIN.equals("m13310n"));
			
		if (Username.equals("maintenance") && MPIN.equals("m13310n"));
		SkillsDemo3.printFile("MaintenanceLog.txt");
		}
		
	}



