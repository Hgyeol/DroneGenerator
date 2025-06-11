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
	
	public double getLastLat() {
		return lastLat;
	}

	public void setLastLat(double lastLat) {
		this.lastLat = lastLat;
	}

	public double getLastLng() {
		return lastLng;
	}

	public void setLastLng(double lastLng) {
		this.lastLng = lastLng;
	}
	
	public String getStartAddress() {
		return startAddress;
	}

	public DroneInfo() {}
	
	public DroneInfo(String id) throws InvalidKeyException, NoSuchAlgorithmException, Exception {
		this.id = id;
		publicIP = PublicIP.getPublicIP();
		GeoLocation geoLocation = new GeoLocation();
		Map<String, Double> location = geoLocation.run(publicIP);
		lastLng = startLng = location.get("lng");
		lastLat = startLat = location.get("lat");
		VWorld.locationToAddress(startLng, startLat);
	}
}
