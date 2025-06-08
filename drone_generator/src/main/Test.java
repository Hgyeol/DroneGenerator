package main;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import drone.GeoLocation;
import drone.PublicIP;
import drone.VWorld;

public class Test {
	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, Exception {
		String publicIP = PublicIP.getPublicIP();
		System.out.println(publicIP);
		GeoLocation geoLocation = new GeoLocation();
		Map<String, Double> location = geoLocation.run(publicIP);
		double startLng = location.get("lng");
		double startLat = location.get("lat");
		System.out.println(startLng);
		System.out.println(startLat);
//		double lng = 127.101313354;
//		double lat = 37.402352535;
//		
		System.out.println(VWorld.locationToAddress(startLng, startLat));
	}
}
