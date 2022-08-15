// import classes
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Manthan 
 * Create a parking management system
 *
 */
public class ParkingManagement {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// Declare variables 
		String numberPlateNumebr;
		String nameOfDriver;
		String mobileNumber;
		int parkingNum;
		String monthly_pass;
		String entry_code;
		int hours;
		double total_charge = 0;
		double totalMoneyCollection = 0;
		double totalCarCount = 0;
        // Create a scanner class object
		Scanner input = new Scanner(System.in);
		// Print Welcome message
		System.out.println("Welcome to the Car Parking Management System!");
         // Ask user for praking space
		System.out.print("Please enter the number of parking spaces: ");
		int numSpaces = input.nextInt();

		int[] parkingSpaces = new int[numSpaces + 1];

		for (int i = 1; i <= numSpaces; i++) {
			parkingSpaces[i] = 0;
		}

		int menuChoice = 0;
		// Declare array list for store a data
		ArrayList<DriverDetails> dataList = new ArrayList<DriverDetails>();
		ArrayList<DriverDetails> allDataList = new ArrayList<DriverDetails>();
		ArrayList<PassCollection> passesList = new ArrayList<PassCollection>();
		
         // Using data object print date
		SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String statDate = formatterDate.format(date);
		System.out.println(statDate);

		while (true) {
			//menu function
			System.out.println("\nMenu:");
			System.out.println("1. Park a car");
			System.out.println("2. Remove a car");
			System.out.println("3. Display parking status");
			System.out.println("4. Display Driver details");
			System.out.println("5. Show Total Collection");
			System.out.println("6. Purchase New Passes weekly, monthly and yearly");
			System.out.println("7. Contact US");
			System.out.println("8. Exit");
			System.out.print("Enter your choice: ");
			
			menuChoice = input.nextInt();

			if (menuChoice == 1) {
                   // Check a parking is not full 
				if (dataList.size() == numSpaces) {
					System.out.println("Parking is Full.\nWait for someone Exit.");
				} else {
                    //Create a scanner class object.
					Scanner sc = new Scanner(System.in);
                    // Ask Driver details and store into variable 
					System.out.println("Enter Driver Name");
					nameOfDriver = sc.nextLine();

					System.out.println("Enter Vehicle Registration Plate ");
					numberPlateNumebr = sc.nextLine();

					System.out.println("Enter Driver Mobile Number");
					mobileNumber = sc.nextLine();
					System.out.println("Do You have a monthly pass?");
					monthly_pass = sc.nextLine();
					//Ask for monthly pass
					if (monthly_pass.equals("yes")) {
						System.out.println("Please enter entrycode");
						entry_code = sc.nextLine();
						String finalpasscode = null ;
						PassCollection pass = new PassCollection(monthly_pass, entry_code, statDate);
						
						// Check pass satatus
						for (PassCollection passList : passesList)
						{
							if(passList.getPassCode().equals(entry_code))
							{
								if(passList.getLicensePlateNumber().equals(numberPlateNumebr))
								{	
									finalpasscode = passList.getPassCode();
								}
							}
						}

						while (!entry_code.equals(finalpasscode)) {
							
							
							for (PassCollection passList : passesList)
							{
								if(passList.getPassCode().equals(entry_code))
								{
									if(passList.getLicensePlateNumber().equals(numberPlateNumebr))
									{	
										finalpasscode = passList.getPassCode();
									}
								}
							}

							System.out.println("Wrong code. Please try again.");
                               // Ask for helpline
							System.out.println(" You want to contact Helpline Yes or no?");
							Scanner sc1 = new Scanner(System.in);
							String contactHelpLineOrNot = sc1.nextLine();
							if (contactHelpLineOrNot.equals("yes") || contactHelpLineOrNot.equals("Yes")) {
								System.out.println("You have to pay for park your car");
								System.out.println("How many hours you want to park your car?");
								hours = sc.nextInt();
								total_charge = totalCharge(hours);
								break;
							} else {
								System.out.println("Please enter entrycode");
								entry_code = sc.nextLine();
								for (PassCollection passList : passesList)
								{
									if(passList.getPassCode().equals(entry_code))
									{
										if(passList.getLicensePlateNumber().equals(numberPlateNumebr))
										{	
											finalpasscode = passList.getPassCode();
										}
									}
								}
							}
						}

						while (entry_code.equals(finalpasscode)) {
							System.out.println("You are free to Park your car.");
							total_charge = 0;
							break;
						}
					} else {
						System.out.println("You have to pay for park your car");
						System.out.println("How many hours you want to park your car?");
						hours = sc.nextInt();
						total_charge = hours * 10;   // count charges form hours.

					}

					Random rand = new Random(); // Create a random class object.
					int upperBound = numSpaces;

					int int_random = (int) Math.floor(Math.random() * (upperBound) + 1);

					while (parkingSpaces[int_random] == 1) {
						int_random = (int) Math.floor(Math.random() * (upperBound) + 1);

					}

					parkingNum = int_random;
					// Create a object from DriverDetails class
					DriverDetails driverInfo = new DriverDetails(nameOfDriver, numberPlateNumebr, mobileNumber,
							parkingNum, total_charge);
                     // Add data into a datalist
					dataList.add(driverInfo);
					allDataList.add(driverInfo);
					totalMoneyCollection = totalMoneyCollection + totalMoneyCollection(driverInfo.getTotal_charge());
					totalCarCount = totalCarCount + totalCarCount(1);
                    // Check parkig space is occupied or not  and Allocate a parking space.
					if (parkingSpaces[int_random] == 0) {
						parkingSpaces[int_random] = 1;
						System.out.println("Parking space " + int_random + " is now occupied.");
					} else {
						System.out.println("Parking space " + int_random + " is already occupied.");
					}

				}
			} else if (menuChoice == 2) {
				// Remove car using license plate number and mobile number
				if (dataList.isEmpty()) {
					System.out.println("Parking is empty. \n wait for someone parked.");

				} else {
					String enteredNumberPlateNumebr;
					String enteredMobileNumber;

					Scanner sc = new Scanner(System.in);
					// Ask user to license plate number and mobile number.
					System.out.println("Enter the license plate Number: ");
					enteredNumberPlateNumebr = sc.nextLine();
					System.out.println("Enter the MobileNumber: ");
					enteredMobileNumber = sc.nextLine();
					int spaceNum = findSpaceNumber(enteredNumberPlateNumebr, enteredMobileNumber, dataList);

					if (spaceNum >= 1 && spaceNum <= numSpaces) {
						if (parkingSpaces[spaceNum] == 0) {
							System.out.println("Parking space " + spaceNum + " is already unoccupied.");
						} else {
							parkingSpaces[spaceNum] = 0;
							System.out.println("Parking space " + spaceNum + " is now unoccupied.");
							Iterator<DriverDetails> itr = dataList.iterator();
							while (itr.hasNext()) {
								DriverDetails number = itr.next();
								if (number.getParkingNum() == spaceNum) {
									itr.remove();
									System.out.println("Driver Details are removed");
								}
							}
						}
					} else {
						System.out.println("Invalid parking space.");
					}
				}
			} else if (menuChoice == 3) {
				// Check a current parking status.
				System.out.println("\nCurrent Parking Status:");

				for (int i = 1; i <= numSpaces; i++) {
					System.out.println(
							"Parking space " + (i) + ": " + (parkingSpaces[i] == 1 ? "Occupied" : "Unoccupied"));
				}
			} else if (menuChoice == 4) {
				if (dataList.isEmpty()) {
					System.out.println("Parking is empty. \n wait for someone parked.");
				} else {
					for (DriverDetails dataList1 : dataList) {
						// Display a driver details.
						System.out.println("-------------------------------------\n" + "Driver Name: "
								+ dataList1.getNameOfDriver() + "\nCar NumberPlate: " + dataList1.getNumberPlateNumebr()
								+ "\nDriver Contact NUmber: " + dataList1.getMobileNumber()
								+ "\nParking Number Occupied:" + dataList1.getParkingNum() + "\nTotal Charges:"
								+ dataList1.getTotal_charge());
					}
				}
			} else if (menuChoice == 5) {
                //Show total collation.
				totalMoneyCollection(totalMoneyCollection);
				totalCarCount(totalCarCount);
				System.out.println("totalMoneyCollection = " + totalMoneyCollection);
				System.out.println("totalCarCount = " + totalCarCount);
			}
			else if(menuChoice == 6)
			{
				// pass list show.
				passesList = PassCollection.purchaseNewPass();
			}
			else if (menuChoice == 7) {
				// Contact us if any query.
				System.out.println("Any Concern Contact Us on our canadian branch: +1 (647) 864-9365");

			} else if (menuChoice == 8) {
				// Add Data into file.
				System.out.println("\nThank you for using the Car Parking Management System!");

				Date endDat = new Date();
				String endDate = formatterDate.format(endDat);
				System.out.println(endDate);

				AddDataInFile(totalMoneyCollection, totalCarCount, allDataList, date, endDat);

				break;
			}

		}

	}
    // Create a method for count totalcharges 
	public static double totalCharge(int hours) {
		return hours * 10;
	}
    // Create a method for totalmoney collection .
	public static double totalMoneyCollection(double totalMoneyCollection) {

		double totalMoneyCollect = 0;
		totalMoneyCollect = totalMoneyCollect + totalMoneyCollection;
		return totalMoneyCollect;
	}
   // Create a method for count a car.
	public static double totalCarCount(double totalCarCount) {

		double totalCarCountNew = 0;
		totalCarCountNew = totalCarCountNew + totalCarCount;
		return totalCarCountNew;
	}
	// Create a method for find space number.
  static int findSpaceNumber(String enteredNumberPlateNumebr, String enteredMobileNumber,
			ArrayList<DriverDetails> dataList) {

		int spaceNumber = 0;
		for (DriverDetails dataList1 : dataList) {
			if ((dataList1.getNumberPlateNumebr()).equals(enteredNumberPlateNumebr)
					&& (dataList1.getMobileNumber()).equals(enteredMobileNumber)) {
				spaceNumber = dataList1.getParkingNum();
			}
		}
		return spaceNumber;

	}
     //  	Add data on file.
	public static void AddDataInFile(double totalMoneyCollection, double totalCarCount,
			ArrayList<DriverDetails> dataList, Date statDate, Date endDate) {
		// use of try catch for exception.
		try {
			SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			String path = formatterDate.format(statDate) + " To " + formatterDate.format(endDate) + ".txt";
			FileWriter myWriter = new FileWriter(path);
			myWriter.write("Report : " + statDate + " To " + endDate);
			myWriter.write("\n-------------------Total Money Collection Of The Day is = " + totalMoneyCollection
					+ "---------------------\n");
			myWriter.write("-------------------Total Number of  Cars Parked is = " + totalCarCount
					+ "-----------------------------\n");
			myWriter.write("Details Of Parked cars details\n");
			for (DriverDetails dataList1 : dataList) { 
				// write a data into file.
				myWriter.write("-------------------------------------\n" + "Driver Name: " + dataList1.getNameOfDriver()
						+ "\nCar NumberPlate: " + dataList1.getNumberPlateNumebr() + "\nDriver Contact NUmber: "
						+ dataList1.getMobileNumber() + "\nParking Number Occupied:" + dataList1.getParkingNum()
						+ "\nTotal Charges:" + dataList1.getTotal_charge() + "\n");
			}
			myWriter.close(); // close file.
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}