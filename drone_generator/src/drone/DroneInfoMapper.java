package drone;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DroneInfoMapper {
	void save(DroneInfo droneInfo);
}
