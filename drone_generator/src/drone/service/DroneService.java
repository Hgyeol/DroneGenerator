package drone.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSessionFactory;

import db.DBUtil;
import drone.domain.DroneInfo;

public interface DroneService {
	
	void generateDroneLocation(DroneInfo findDroneInfo);
	
	void save(String id);
	
	void deleteById(String id);
	
	DroneInfo findById(String id);
	
	ArrayList<DroneInfo> findAll();
	
	
}
