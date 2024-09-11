
/*Skills Demo 3 group assignment with Mathew King, Samuel Lotty and Oleksiy borshchevskyy.
 * Registration section by Mathew King.
 * April 2022
 */
 


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.time.LocalDate;


public class BikeHire {

	static String email,PIN, ccNumber, ccCCV, usern, MPIN, Username, Damage;
	static byte ccExpMonth,ccExpYear,day,month,menuChoice;
	static short year;
	static float subCost,topup;
	static char Locked,subscription,Log,Damage1;
	static double Fee;
	static Scanner menusc = new Scanner(System.in);
	static Scanner sc = new Scanner(System.in);
	static boolean validMenuChoice = false;
	static int i,Number,Minutes, CreditCard;
	static DecimalFormat Money = new DecimalFormat ("€###,##0.00");
	
	
	
	
	public static void main(String[] args) {
	
	
	


		
		
		do {
				try {
					System.out.println("\t\t\t\t\tMENU");
					System.out.println("For new user registration press 1\nUser Login press 2\nFor Bike Hire press 3\nFor Bike Return press 4\nFor Maintenance press 5");
					menuChoice = menusc.nextByte();
					validMenuChoice = true;
					if (menuChoice == 1) {
						Registration();
					} else if (menuChoice == 2) {
						Login();
					} else if (menuChoice == 3) {
						Rentingabike();
						
					} else if (menuChoice == 4) {
						ReturningBike();
					} else if (menuChoice == 5) {
						Maintenance();
					}
				} catch (Exception e) {
					System.err.println("Enter a number between 1 - 5");
					menusc.next();
					}
			
		
		
		} while (!validMenuChoice || menuChoice != 1 || menuChoice != 2 || menuChoice != 3 || menuChoice != 4 || menuChoice != 5);
	



	
		
		
	}



	private static void ReturningBike() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Email:\t");
		email = sc.next();
		System.out.print("Enter PIN:\t");
		PIN = sc.next();
		SkillsDemo3.checkLoginCredentials(email, PIN);
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
	
		
	}



	private static void Maintenance() {
		Scanner sc = new Scanner(System.in);
		
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
	
public static void Rentingabike() throws Exception {
	
		System.out.println("Hello and welcome to the Cork City Bikes");
		System.out.println("If unsure that to do please enter 1 for help and 2 for FAQ, otherwise press 3 to continue");
		i = sc.nextInt();
		
	
		// Declaring loop variable
		if (i == 1)
			help();
		// Declaring loop variable
		if (i == 2)
			FAQ();
		
		if (i == 3) {
		System.out.println("Please enter your username");
		usern = sc.nextLine();
		System.out.println("Please enter your PIN");
		PIN = sc.nextLine();
		}
		
	}

	public static void LoginReg() {
	
		
	}

	 public static void help() throws Exception
	    {
	    {
	/*location is from Oleksiy's computer */ 
	        // Passing the path to the file as a parameter
	        FileReader fr = new FileReader(
	        "C:\\Users\\razor\\OneDrive - Cork College of Commerce\\Java Progarming\\Assignment 3 Skills Demonstration\\Assignment 3\\help.txt");
	 
	        // Declaring loop variable
	        
	        // Holds true till there is nothing to read
	        while ((i = fr.read()) != -1)
	 
	            // Print all the content of a file
	            System.out.print((char)i);
	    }
	        
	    }
		
	
	
	public static void FAQ () throws Exception {
		/* location is from Oleksiy's computer */
			
		// Passing the path to the file as a parameter
			FileReader fr = new FileReader("C:\\Users\\razor\\OneDrive - Cork College of Commerce\\Java Progarming\\Assignment 3 Skills Demonstration\\Assignment 3\\FAQ.txt");
		
			// Holds true till there is nothing to read
			while ((i = fr.read()) != -1)
 
            // Print all the content of a file
            System.out.print((char)i);
        }
	
		



	private static void Login() {
		do {
			System.out.println("Please enter your email address.");
			email = sc.next();
			System.out.println("Please enter your 4 digit PIN.");
			PIN = sc.next();
			System.out.println();
			
			
				
			}while(!SkillsDemo3.checkLoginCredentials(email, PIN));
		
	}



	private static void Registration() {
/* Using RegEx to compile and match patterns 
*/

		String emailRegex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		String pinRegex = "^([0-9]{4})$";
		String mobRegex = "^([0-9]{10})$";
		String ccRegex = "^([0-9]{16})$";
		String ccvRegex = "^([0-9]{3})$";
		boolean validDay = false, validMonth = false,validYear = false, validTopup = false ;
		byte subscription, age, termsAccept;
		String firstName, surname, gender, mobile, address;
		Scanner login = new Scanner(System.in);
		DecimalFormat money = new DecimalFormat("#,##0.00");
		LocalDate today = LocalDate.now();
		

/* New user must choose between an annual pass or a 3-day pass
*/
 
		do {

			System.out.println("Please choose which subscription you would like\n\nFor a €30 annual subscription Press 1"
					+ "\n\nFor a €5 3-Day pass Press 2");
			subscription = login.nextByte();
			if (!(subscription == 1 || subscription == 2)) 
			{
				System.err.println("Enter either 1 or 2");
			}

		} while (!(subscription == 1 || subscription == 2));

		if (subscription == 1) {
			subCost = 30.00f;
		}
		else if (subscription == 2) {
			subCost = 5.00f;
		}
/* Gathering personal details about the user
*/
		do {
			System.out.println("Please enter your first name");
			firstName = login.next();
			if (!firstName.matches("^[a-zA-Z]+$"))
			{
				System.err.println("Only letters are permitted");
			}
		} while (!firstName.matches("[a-zA-Z]+"));

		do {
			System.out.println("Please enter your surname");
			surname = login.next();
			if (!surname.matches("^[a-zA-Z]+$")) {
				System.err.println("Only letters are permitted");
			} 
		} while (!surname.matches("^[a-zA-Z]+$"));   

		do {
			do {
				try {
					System.out.println("Date of Birth\n\nPlease enter the day (2 digits)");
					day = login.nextByte();
					validDay = true;
					if (day > 31){
						System.err.println("Enter a number between 1 - 31");
					}

				} catch (Exception e) {
					System.err.println("Enter a number between 1 and 31");
					login.next();
				}	
			} while (!validDay || day > 31);

			do {
				try {
					System.out.println("Please enter the month (2 digits)");
					month = login.nextByte();
					validMonth = true;
					if (month > 12){
						System.err.println("Enter a number between 1 - 12");
					}
				} catch (Exception e) {
					System.err.println("Enter a number between 1 - 12");
					login.next();
				}
			} while (!validMonth || month > 12);
			
			do {
				try {
					System.out.println("Please enter the year (4 Digits)");
					year = login.nextShort();
					validYear = true;
					if (year > 2022 || year < 1922){
						System.err.println("That is not a valid year");
					}
				} catch (Exception e) {
					System.err.println("Enter a valid year");
					login.next();
				}
			} while (year > 2022 || year < 1922 || !validYear);
			age = SkillsDemo3.getAge((byte) day, (byte) month, (short) year);
			if (age <14) {
				System.err.println("People under 14 are not able to hire a bike\n");
			}
		} while (age < 14);

		do {
			System.out.println("Please enter your gender");
			gender = login.next();
			if (!(gender.equalsIgnoreCase("Male")|| (gender.equalsIgnoreCase("Female")))) {
				System.err.println("Please enter male or female");
			}
		} while (!(gender.equalsIgnoreCase("Male")|| gender.equalsIgnoreCase("Female")));
		
		do {
			System.out.println("Please enter your email address");
			email = login.next();
			if (!email.matches(emailRegex)) {
				System.err.println("Please enter a valid email address");
			}
		} while (!email.matches(emailRegex));

		do {
			System.out.println("Please enter your mobile number");
			mobile = login.nextLine();
			if (!mobile.matches(mobRegex)){
				System.err.println("Please enter a valid mobile number");
			}

		} while (!mobile.matches(mobRegex));  

			System.out.println("Please enter your address");
			address = login.nextLine();
		
		do {
			System.out.println("Please enter a 4 digit PIN ");
			PIN = login.next();
			if (!PIN.matches(pinRegex)) {
				System.err.println("Please enter a 4 digit number");
			}
		} while (!PIN.matches(pinRegex));
		
/* User email and PIN are appended to Login.txt to be used as user name and user password for future bike hires */
		
		SkillsDemo3.appendToLoginFile(email, PIN);
/* New users must enter a valid credit card for processing payment of subscription fee and initial top-up amount */
		do {
			System.out.println("Please enter your credit card number");
			ccNumber = login.next();

			if (!ccNumber.matches(ccRegex)) 
			{
				System.err.println("Please enter a valid Credit Card number");
			} 
		} while (!ccNumber.matches(ccRegex));

		do {
			do {
				System.out.println("Enter the expiry month (2 digits)");
				ccExpMonth = login.nextByte();
				if (ccExpMonth > 12) {
					System.err.println("Enter a valid month");

				}
			} while (ccExpMonth > 12);

			System.out.println("Enter expiry year");
			ccExpYear = login.nextByte(); 
			if (!(SkillsDemo3.checkExpiryDate((byte) ccExpMonth, (byte) ccExpYear)))
			{
				System.err.println("The Credit Card has expired");
			}
			else if (ccExpYear > 26) {
				System.err.println("The expiry date is not valid");
			}
/* The expiration date is checked against the checkExpiryDate method from SkillsDemo3.java to make sure the payment can be processed */
		} while (ccExpYear > 26 || !(SkillsDemo3.checkExpiryDate((byte) ccExpMonth, (byte) ccExpYear)));

		do {
			System.out.println("Enter the 3 digit security number");
			ccCCV= login.next();
			if (!ccCCV.matches(ccvRegex))
			{
				System.err.println("Please enter a valid 3 digit security number");
			}
		} while (!ccCCV.matches(ccvRegex)); 

		do {
			try {
				System.out.println("Please enter the amount that you wish to top-up.The minimum top-up amount is €10");
				topup = login.nextFloat();
				validTopup = true;
			} catch (Exception e) {
				System.err.println("Enter a valid number");
				login.next();
			} 
		} while (!validTopup);
		
		System.out.println("\n\n\nPlease read the Terms and Conditions\n\n");
		SkillsDemo3.printFile("TermsAndConditions.txt");
		
		/* User must accept the Terms and Conditions to proceed */
		
		do {
			System.out.println("\n\n\nDo you accept the Terms and Conditions?\nPress 1 for yes or press 2 for no");
			termsAccept = login.nextByte();
		} while (!(termsAccept == 1 || termsAccept == 2));

		if  (termsAccept == 2)
		{
			System.out.println("Thank you for your time and we hope you consider our service again in the future"
					+ "\nGoodbye."); 
			System.exit(0);
		}
		else if (termsAccept == 1)
		/* Once the Terms and conditions have been accepted a personal welcome message is displayed and a receipt with details, payment amount 
		and expiration date is printed */
		{ 
			System.out.println("Welcome to Cork City Bikes "+ firstName.toUpperCase());
		} 
		System.out.println("\n\t\t\t\tCORK CITY BIKES\n\n");
		System.out.println("NAME:\t\t\t"+ firstName.toUpperCase() +" "+surname.toUpperCase());
		System.out.println("AGE:\t\t\t"+ age);
		System.out.println("ADDRESS:\t\t"+ address.toUpperCase());
		System.out.println("EMAIL:\t\t\t"+email);
		System.out.println("CONTACT:\t\t"+mobile);
		System.out.println("CREDIT CARD:\t\txxxx xxxx xxxx "+ccNumber.charAt(12)+ccNumber.charAt(13)+ccNumber.charAt(14)+ccNumber.charAt(15));
		System.out.println("SUBSCRIPTION COST:\t€"+money.format(subCost));
		System.out.println("TOP-UP AMOUNT:\t\t€"+money.format(topup));
		System.out.println("TOTAL CHARGE:\t\t€"+money.format(topup+subCost));  
		if (subscription == 1) {
		System.out.println("SUBSCRIPTION EXPIRY:\t"+ today.plusYears(1));
		}
		else if (subscription == 2) {
			System.out.println("SUBSCRIPTION EXPIRY:\t"+ today.plusDays(3));
		}
		login.close();     
		
	}

} 
