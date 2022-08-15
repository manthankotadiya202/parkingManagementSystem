import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Manthan
 *
 */
public class PassCollection {
     // Declare a variable.
	String licensePlateNumber;
	String passCode;
	String category;
     // Create a constractor. 
	public PassCollection(String licensePlateNumber, String passCode, String category) {
		this.licensePlateNumber = licensePlateNumber;
		this.passCode = passCode;
		this.category = category;
	}
     // Create a array list method.
	public static ArrayList<PassCollection> purchaseNewPass() {
		String passcode = null;
		ArrayList<PassCollection> dataList = new ArrayList<PassCollection>();
		while (true) {
            // Create a menu list for pass system.
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your license plate number");
			String licensePlateNumber = sc.nextLine();
			System.out.println(" we have Three kind of passes available ");
			System.out.println("Enter 1 - To collect Weekly Pass");
			System.out.println("Enter 2 - To collect Monthly Pass");
			System.out.println("Enter 3 - To collect Yearly Pass");
			System.out.println("Enter 4 - To Exit");
			String aToZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
			String choice = sc.nextLine();
			String category = null;
			switch (choice) {
			case "1": {
               // Create a passcode for weekly base
				passcode = generateRandom(aToZ);
				category = "Weekly";
				PassCollection passInfo = new PassCollection(licensePlateNumber, passcode, category);
				dataList.add(passInfo);
				AddDataInFile(licensePlateNumber, passcode, category, dataList);
				break;
			}
			case "2": {
				//Create a passcode for monthly base.
				passcode = generateRandom(aToZ);
				category = "Monthly";
				PassCollection passInfo = new PassCollection(licensePlateNumber, passcode, category);
				dataList.add(passInfo);
				AddDataInFile(licensePlateNumber, passcode, category, dataList);
				break;

			}
			case "3": {
				// Create a passcode for yearly base.
				passcode = generateRandom(aToZ);
				category = "Yearly";
				PassCollection passInfo = new PassCollection(licensePlateNumber, passcode, category);
				dataList.add(passInfo);
				AddDataInFile(licensePlateNumber, passcode, category, dataList);
				break;
			}
			case "4": {

				break;
			}
			}

			for (PassCollection dataList1 : dataList) {
				System.out.println(dataList1.getLicensePlateNumber() + "	" + dataList1.getPassCode() + "	"
						+ dataList1.getCategory());

			}

			return dataList;
		}
	}

	// getter setter methods
	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}

	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPassCode() {
		return passCode;
	}

	public void setPassCode(String passCode) {
		this.passCode = passCode;
	}

	//Create a method for generating random passcode.
	private static String generateRandom(String aToZ) {
		Random rand = new Random();
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			int randIndex = rand.nextInt(aToZ.length());
			res.append(aToZ.charAt(randIndex));
		}
		return res.toString();
	}
    //  Create a method for add data into file.
	public static void AddDataInFile(String licensePlateNumber, String passCode, String category,
			ArrayList<PassCollection> dataList) {
		try {
			//record all passcode into file. 
			FileWriter myWriter = new FileWriter("passesRecord.txt", true);
			for (PassCollection dataList1 : dataList) {
				myWriter.append(dataList1.getLicensePlateNumber() + "   " + dataList1.getPassCode() + "    "
						+ dataList1.getCategory());
				myWriter.append("\n");
			}
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
