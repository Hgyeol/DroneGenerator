package drone;

public interface DroneInfoMapper {
	void save(DroneInfo droneInfo);
	
	DroneInfo findById(String id);
}
