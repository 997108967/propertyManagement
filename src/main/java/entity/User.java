package entity;

public class User {
	private int id;
	private String username;
	private String password;
	private String address;
	private String idNumber;
	private String phoneNumber;
	private String fault;
	private String repair;
	private String repairman;
	private String waterRates;
	private String powerRates;
	private String burnerCost;
	private String propertyFee;
	private String secretProtection;
	private String secretProtectionValue;
	
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", address=" + address
				+ ", idNumber=" + idNumber + ", phoneNumber=" + phoneNumber + ", fault=" + fault + ", repair=" + repair
				+ ", repairman=" + repairman + ", waterRates=" + waterRates + ", powerRates=" + powerRates
				+ ", burnerCost=" + burnerCost + ", propertyFee=" + propertyFee + ", secretProtection="
				+ secretProtection + ", secretProtectionValue=" + secretProtectionValue + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFault() {
		return fault;
	}
	public void setFault(String fault) {
		this.fault = fault;
	}
	public String getRepair() {
		return repair;
	}
	public void setRepair(String repair) {
		this.repair = repair;
	}
	public String getRepairman() {
		return repairman;
	}
	public void setRepairman(String repairman) {
		this.repairman = repairman;
	}
	public String getWaterRates() {
		return waterRates;
	}
	public void setWaterRates(String waterRates) {
		this.waterRates = waterRates;
	}
	public String getPowerRates() {
		return powerRates;
	}
	public void setPowerRates(String powerRates) {
		this.powerRates = powerRates;
	}
	public String getBurnerCost() {
		return burnerCost;
	}
	public void setBurnerCost(String burnerCost) {
		this.burnerCost = burnerCost;
	}
	public String getPropertyFee() {
		return propertyFee;
	}
	public void setPropertyFee(String propertyFee) {
		this.propertyFee = propertyFee;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSecretProtection() {
		return secretProtection;
	}
	public void setSecretProtection(String secretProtection) {
		this.secretProtection = secretProtection;
	}
	public String getSecretProtectionValue() {
		return secretProtectionValue;
	}
	public void setSecretProtectionValue(String secretProtectionValue) {
		this.secretProtectionValue = secretProtectionValue;
	}
	
}
