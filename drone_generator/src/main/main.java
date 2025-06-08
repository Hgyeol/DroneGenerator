package main;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import db.DBUtil;
import drone.DroneInfo;
import drone.DroneInfoMapper;
import test.Log4jTest;

public class main {
	
	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, Exception {
		PropertyConfigurator.configure("./resources/log4j.properties");
		Logger logger = Logger.getLogger(main.class);
		DBUtil db = new DBUtil();
		
		db.init();
		SqlSession session;
		DroneInfoMapper droneInfoMapper;
		
		DroneInfo droneInfo;
		
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
					session = db.getSession();
					droneInfoMapper = session.getMapper(DroneInfoMapper.class);
					
					droneInfo = new DroneInfo();
					sc.nextLine();
					System.out.print("드론 아이디 : ");
					droneInfo.setId(sc.nextLine());
					System.out.print("드론 최대 범위 : ");
					droneInfo.setMaxArea(sc.nextDouble());
					
					droneInfoMapper.save(droneInfo);
					session.commit();
					session.close();
					
					logger.info(droneInfo.getId() + " 드론이 정상적으로 DB에 저장이 되었습니다.");
					break;
				case 3:
					session = db.getSession();
					droneInfoMapper = session.getMapper(DroneInfoMapper.class);
				
					System.out.print("드론 아이디 : ");
					String droneId = sc.nextLine();
				
					droneInfo = droneInfoMapper.findById(droneId);
					break;
				case 4:
					System.out.println("프로그램 종료");
					return;
			}
			
		}
	}
}
