package main;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import db.DBUtil;
import db.Postgresql;
import drone.DroneInfo;
import drone.DroneInfoMapper;

public class main {
	public static void main(String[] args) {
		
		DBUtil db = new DBUtil();
		
		db.init();
		
		DroneInfoMapper droneInfoMapper = db.getSession().getMapper(DroneInfoMapper.class);
		
		Scanner sc = new Scanner(System.in);
		int n;
		while(true) {
			System.out.println("=드론 제네레이터=");
			System.out.println("1. 드론 정보 리스트");
			System.out.println("2. 드론 등록");
			System.out.println("3. 드론 좌표 생성");
			System.out.println("4. 종료");
			System.out.print(">> ");
			
			n = sc.nextInt();
			
			switch(n) {
				case 1:
//					for(int i = 0; i < droneList.size(); i++) {
//						System.out.println(droneList.get(i));
//					}
					break;
				case 2:
					DroneInfo droneInfo = new DroneInfo();
					System.out.print("드론 아이디 : ");
					droneInfo.setDroneId(sc.nextLine());
					System.out.println("드론 최대 범위 : ");
					droneInfo.setMaxArea(sc.nextDouble());
					break;
				case 3:
					String droneId = sc.nextLine();
					
			}
			
		}
	}
}
