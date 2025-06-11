package drone.mapping;

import java.util.ArrayList;

import drone.domain.DroneInfo;

public interface DroneInfoMapper {
	
	DroneInfo findById(String id);
	
	ArrayList<DroneInfo> findAll();
	
	int save(DroneInfo droneInfo);
	
	int updateById(String id, double lastLat, double lastLng);
	
	int deleteById(String id);
}
