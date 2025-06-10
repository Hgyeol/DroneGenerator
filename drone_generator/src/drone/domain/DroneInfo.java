package drone.domain;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import drone.GeoLocation;
import drone.PublicIP;
import drone.VWorld;

public class DroneInfo {
	private String id;
	private double maxArea;
	private String publicIP;
	private double startLat;
	private double startLng;
	private double lastLat;
	private double lastLng;
	private String startAddress;
	
	public void generateLocation() {
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getMaxArea() {
		return maxArea;
	}
	public void setMaxArea(double maxArea) {
		this.maxArea = maxArea;
	}
	
	public DroneInfo() throws InvalidKeyException, NoSuchAlgorithmException, Exception {
		publicIP = PublicIP.getPublicIP();
		GeoLocation geoLocation = new GeoLocation();
		Map<String, Double> location = geoLocation.run(publicIP);
		lastLng = startLng = location.get("lng");
		lastLat = startLat = location.get("lat");
		VWorld.locationToAddress(startLng, startLat);
	}
}
