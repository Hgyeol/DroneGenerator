package main;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.simple.parser.ParseException;

import drone.VWorld;

public class Test {
	public static void main(String[] args) throws MalformedURLException, IOException, ParseException {
		double lng = 127.101313354;
		double lat = 37.402352535;
		
		System.out.println(VWorld.locationToAddress(lng, lat));
	}
}
