package drone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.Postgresql;

public class DroneInfo {
	private String droneId;
	private double maxArea;
	
	public static List<DroneInfo> findAll() {
		List<DroneInfo> droneList = new ArrayList<DroneInfo>();
		try {
			Postgresql psql = new Postgresql();
			Connection conn = psql.getConnection();
			String sql = "select * from drone_info";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				DroneInfo droneInfo = new DroneInfo(rs.getString("id"), rs.getDouble("max_area"));
				droneList.add(droneInfo);
			}
			return droneList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void save() {
		try {
			Postgresql psql = new Postgresql();
			Connection conn = psql.getConnection();
			String sql = "insert into drone_info (id, max_area) values(?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, droneId);
			pstmt.setDouble(2, maxArea);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void generateLocation() {
		
	}
	
	public String getDroneId() {
		return droneId;
	}
	public void setDroneId(String droneId) {
		this.droneId = droneId;
	}
	public double getMaxArea() {
		return maxArea;
	}
	public void setMaxArea(double maxArea) {
		this.maxArea = maxArea;
	}
	
	@Override
	public String toString() {
		return droneId + " : " + maxArea; 
	}
	
	public DroneInfo() {}
	
	public DroneInfo(String droneId, double maxArea) {
		this.droneId = droneId;
		this.maxArea = maxArea;
	}
}
