package drone;

import java.io.IOException;

public class DroneInfo {
	private String droneId;
	private double maxArea;
	private String publicIP;
	private double startLat;
	private double startLng;
	
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
	
	public DroneInfo() throws IOException {
		this.publicIP = PublicIP.getPublicIP();
		
	}
	
	public DroneInfo(String droneId, double maxArea) {
		this.droneId = droneId;
		this.maxArea = maxArea;
	}
}
