# CCOC-CorkCityBikes
This was a group project that myself, and two other college colleagues worked on as an assignment.

Algorithm

OUTPUT “Enter Email”
INPUT “Email”
OUTPUT “Enter PIN”
INPUT “PIN”
OUTPUT “What number bike is being returned”
INPUT “Bike number” 
OUTPUT “Lock the bike in the bank”
INPUT “Yes or no”
If ‘Y’OUTPUT “Bike is now locking”
If ‘N’ OUTPUT “Please place the bike back into the bank”
OUTPUT “Cost of renting bike will be deducted from credit card”
INPUT “Enter your credit card details”
OUTPUT “Enter number of minutes how long bike was rented”
INPUT “Minutes used” 
INPUT calculated fee from minutes used
OUTPUT “Fee owed” 
OUTPUT “Is the bike damaged”
INPUT “Yes or no”
IF ‘Y’ OUTPUT “Enter the bike number”
INPUT “Bike number”
OUTPUT “What is the fault with the bike”
INPUT “Bike damage”
OUTPUT “Bike is permanently locked”
IF ‘N’ OUTPUT “Thank you for using cork city bikes”
OUTPUT “Would you like to view the maintenance log?”
If ‘Y’ OUTPUT “Enter your username”
INPUT “Correct Username”
OUTPUT “Enter PIN”
INPUT “Correct PIN”



Data Dictionary

Email	String
PIN	INT
Number	INT
Minutes	INT
Fee	Double
Locked	Char
Subscription 	Char
Damage	String
Maintenance Pin	String
Credit Card	INT
Username	String
Maintenance Log	Char
Damage 1	Char


Testing 1
do {
System.out.println("Is the bike ready to be locked within the bank?");
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
Results 1
Is the bike ready to be locked within the bank?
n
Please place bike into bank where it can be locked!
Is the bike ready to be locked within the bank?
Y
The bike is now locking





Testing 2
System.out.println("Is there any damage done to the bike?:\t");
Damage1 = sc.next().charAt(0);
switch (Damage1) {
case 'y' : {
System.out.println("Enter the number of the bike that is damaged:\t");
Number = sc.nextInt();
System.out.println("What is the fault with the bike");
Damage = sc.next();
String errorBike = sc.nextLine();
SkillsDemo3.appendToMaintenanceLog(errorBike);
System.out.println("This bike is now permanently locked!");
}
case 'n' : {
System.out.println("Thank you for using Cork City Bikes!");
}
}
Results 2
Is there any damage done to the bike?:	
y
Enter the number of the bike that is damaged:	
4
What is the fault with the bike
broken wheel
This bike is now permanently locked!

Testing 3
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

Results 3
Would you like to view the maintenance log?:	y
Enter Username:	maintene
Enter Username:	That username is not valid!
maintenance
Enter PIN:	23232
Enter PIN:	That Pin is not valid!
m13310n
bike number 3 has faulty spokes
//SkillsDemo3.printFile("FAQ.txt");
//SkillsDemo3.printFile("MaintenanceLog.txt")
wheel


My code
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


