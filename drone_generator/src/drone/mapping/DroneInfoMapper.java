package drone.mapping;

import drone.domain.DroneInfo;

public interface DroneInfoMapper {
	void save(DroneInfo droneInfo);
	
	DroneInfo findById(String id);
}
