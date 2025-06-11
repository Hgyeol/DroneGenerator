package drone.controller;

import java.util.ArrayList;
import java.util.Scanner;

import annotation.HangyeolController;
import annotation.HangyeolMapping;
import drone.domain.DroneInfo;
import drone.service.DroneServiceImpl;

// Controller 에서 View 역할도 같이하는 듯 

@HangyeolController
public class DroneController {

	Scanner sc = new Scanner(System.in);
	private static final DroneServiceImpl droneServiceImpl = new DroneServiceImpl();
	
	@HangyeolMapping(value="1")
	public void getAllDroneInfo() {
		ArrayList<DroneInfo> allDroneInfo = droneServiceImpl.findAll();
		for(DroneInfo droneInfo : allDroneInfo) {
			System.out.printf("Id : %s, Address : %s\n", droneInfo.getId(), droneInfo.getStartAddress());
		}
	}
	
	@HangyeolMapping(value="2")
	public void addDroneInfo() {
		System.out.print("생성할 드론 아이디 >> ");
		String id = sc.nextLine();
		droneServiceImpl.save(id);
	}
	
	@HangyeolMapping(value="3")
	public void generateLocation() {
		System.out.print("좌표 생성할 드론 아이디 >> ");
		String id = sc.nextLine();
		DroneInfo findDroneInfo = droneServiceImpl.findById(id);
		droneServiceImpl.generateDroneLocation(findDroneInfo);
	}
}
