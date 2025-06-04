package drone;

import java.util.ArrayList;
import java.util.List;

public class CircleGenerator {
	
	public static void main(String[] args) {
		double max = 36;
		double max_area = 20;
		List<DroneLocation> locations = new ArrayList<>();
		
		DroneLocation center = new DroneLocation(0,0);
		
		double x = 0, y = 0, r = max/2;
		
		for(int i = 0; i < 360; i += 10) {
			x = center.x + r * Math.cos(Math.toRadians(i));
			y = center.y + r * Math.sin(Math.toRadians(i));
			System.out.println("x : " + x + ", y : " + y);
			locations.add(new DroneLocation(x, y));
		}
		
		for(int i = 0; i < locations.size(); i++) {
			System.out.println(locations.get(i));
		}
	}
}
class DroneLocation {
	double x;
	double y;
	
	public DroneLocation(double x, double y) {
		this.x = x;
		this.y = y;
	}
}