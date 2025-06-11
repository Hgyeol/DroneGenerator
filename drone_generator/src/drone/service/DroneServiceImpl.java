package drone.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import db.DBUtil;
import drone.domain.DroneInfo;
import drone.mapping.DroneInfoMapper;
import exception.ExistException;
import exception.NotFoundException;

public class DroneServiceImpl implements DroneService{
	
	private SqlSessionFactory sqlSessionFactory;
	
	private final int generationTime = 1000;
	
	public DroneServiceImpl() {
		this.sqlSessionFactory = DBUtil.getSqlSessionFactory();
	}
	
	@Override
	public void generateDroneLocation(DroneInfo findDroneInfo) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			DroneInfoMapper droneInfoMapper = session.getMapper(DroneInfoMapper.class);
			
			String id = findDroneInfo.getId();
			double y = findDroneInfo.getLastLat();
			double x = findDroneInfo.getLastLng();
			double r = findDroneInfo.getMaxArea()/2;
			
			System.out.println("#########Service#########");
			for(int i = 0; i < 360; i += 10) {
				x = y + r * Math.sin(Math.toRadians(i));
				y =	x + r * Math.cos(Math.toRadians(i));
				
				System.out.println("x : " + x + ", y : " + y);
				droneInfoMapper.updateById(id, x, y);
				
				try {
					Thread.sleep(generationTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				// Test
				DroneInfo check = droneInfoMapper.findById(id);
				System.out.println("sx : " + check.getLastLng() + ", sy : " + check.getLastLat());
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

	@Override
	public void save(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			DroneInfoMapper droneInfoMapper = session.getMapper(DroneInfoMapper.class);
			DroneInfo existDroneInfo = findById(id);
			if(existDroneInfo != null) {
				throw new ExistException("이미 존재하는 아이디 입니다.");
			}
			DroneInfo newDroneInfo = new DroneInfo(id);
			
		} catch(Exception e) {
//			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteById(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			DroneInfoMapper droneInfoMapper = session.getMapper(DroneInfoMapper.class);
			droneInfoMapper.deleteById(id);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public DroneInfo findById(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			DroneInfoMapper droneInfoMapper = session.getMapper(DroneInfoMapper.class);
			DroneInfo droneInfo = droneInfoMapper.findById(id);
			
			if(droneInfo == null) {
				throw new NotFoundException("해당 드론을 찾을 수가 없습니다.");
			}
			
			return droneInfo;
		} catch(Exception e) {
			throw e;
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}

	@Override
	public ArrayList<DroneInfo> findAll() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			DroneInfoMapper droneInfoMapper = session.getMapper(DroneInfoMapper.class);
			ArrayList<DroneInfo> allDroneInfo = droneInfoMapper.findAll();
			
			return allDroneInfo;
		} catch(Exception e) {
			throw e;
		} finally {
			session.close();
		}
	}

}
