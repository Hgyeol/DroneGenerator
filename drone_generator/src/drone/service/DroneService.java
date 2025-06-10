package drone.service;

import java.util.ArrayList;

import db.DBUtil;
import drone.domain.DroneInfo;

public interface DroneService {

	
	
	void generateDroneLocation(String id);
	
	void saveDroneInfo(DroneInfo droneInfo);
	
	void deleteDroneInfo(DroneInfo droneInfo);
	
	DroneInfo findById(String id);
	
	ArrayList<DroneInfo> findAll();
	
	
}
