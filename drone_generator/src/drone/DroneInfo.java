package drone;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class DroneInfo {
	private String droneId;
	private double maxArea;
	private String publicIP;
	private double startLat;
	private double startLng;
	private String startAddress;
	
	public void generateLocation() {
		
	}
	
	public String getDroneId() {
		return droneId;
	}
	public void setDroneId(String droneId) {
		this.droneId = droneId;
	}
	public double getMaxArea() {
		return maxArea;
	}
	public void setMaxArea(double maxArea) {
		this.maxArea = maxArea;
	}
	
	@Override
	public String toString() {
		return droneId + " : " + maxArea; 
	}
	
	public DroneInfo() throws InvalidKeyException, NoSuchAlgorithmException, Exception {
		publicIP = PublicIP.getPublicIP();
		GeoLocation geoLocation = new GeoLocation("111", "111");
		Map<String, Double> location = geoLocation.run(publicIP);
		startLng = location.get("lng");
		startLat = location.get("lat");
	}
}
