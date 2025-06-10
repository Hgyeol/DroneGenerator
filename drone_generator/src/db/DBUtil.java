package db;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import drone.domain.DroneInfo;
import drone.mapping.DroneInfoMapper;

public class DBUtil {
	public static SqlSessionFactory sqlSessionFactory;
	
	public void init() {
		try {
			String resource = "db/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//			SqlSession session = sqlSessionFactory.openSession();
//			DroneInfoMapper mapper = session.getMapper(DroneInfoMapper.class);	
		} catch(Exception e) {
			System.out.println("MyBatis 설정 파일 가져오는 중 문제 발생");
			e.printStackTrace();
		}
	}
	
	public SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}
}