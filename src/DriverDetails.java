/**
 * 
 */

/**
 * @author Manthan
 *
 */
public class DriverDetails {

	/**
	 * @param Declare a variables
	 */
	private String numberPlateNumebr;
	private String nameOfDriver;
	private String mobileNumber;
	private int parkingNum;
	private double total_charge;

	//Create a constructor
	public DriverDetails(String nameOfDriver, String numberPlateNumebr, String mobileNumber, int parkingNum,
			double total_charge2) {
		this.setNameOfDriver(nameOfDriver);
		this.setNumberPlateNumebr(numberPlateNumebr);
		this.setMobileNumber(mobileNumber);
		this.setParkingNum(parkingNum);
		this.setTotal_charge(total_charge2);

	}

	/**
	 * @return the numberPlateNumebr
	 */
	public String getNumberPlateNumebr() {
		return numberPlateNumebr;
	}

	/**
	 * @param numberPlateNumebr the numberPlateNumebr to set
	 */
	public void setNumberPlateNumebr(String numberPlateNumebr) {
		this.numberPlateNumebr = numberPlateNumebr;
	}

	/**
	 * @return the nameOfDriver
	 */
	public String getNameOfDriver() {
		return nameOfDriver;
	}

	/**
	 * @param nameOfDriver the nameOfDriver to set
	 */
	public void setNameOfDriver(String nameOfDriver) {
		this.nameOfDriver = nameOfDriver;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the parkingNum
	 */
	public int getParkingNum() {
		return parkingNum;
	}

	/**
	 * @param parkingNum the parkingNum to set
	 */
	public void setParkingNum(int parkingNum) {
		this.parkingNum = parkingNum;
	}

	/**
	 * @return the total_charge
	 */
	public double getTotal_charge() {
		return total_charge;
	}

	/**
	 * @param total_charge2 the total_charge to set
	 */
	public void setTotal_charge(double total_charge2) {
		this.total_charge = total_charge2;
	}
}
