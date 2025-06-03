package db;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtil {
	public void init() {
		try {
			String resource = "org/mybatis/example/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch(Exception e) {
			System.out.println("MyBatis 설정 파일 가져오는 중 문제 발생");
			e.printStackTrace();
		}
	}
}