package in.lifelink.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.lifelink.dbutil.DBConnection;
import in.lifelink.pojo.*;

public class BloodDonorDao {
	public static boolean addDonor(BloodDonorPojo donorPojo) throws SQLException{
		Connection conn=DBConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement("Insert into blood_donors(name,blood_type,city,contact) Values(?,?,?,?)");
		ps.setString(1,donorPojo.getName());
		ps.setString(2,donorPojo.getBloodType());
		ps.setString(3,donorPojo.getCity());
		ps.setString(4,donorPojo.getContact());
		int result=ps.executeUpdate();
		ps.close();
		return result>0;		
	}
	public static List<BloodDonorPojo> getAllDonors() throws SQLException{
		Connection conn=DBConnection.getConnection();
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM blood_donors");
		List<BloodDonorPojo> res=new ArrayList<>();
		BloodDonorPojo donor;
		while(rs.next()) {
			donor=new BloodDonorPojo();
			donor.setDonorId(rs.getInt("donor_id"));
			donor.setName(rs.getString("name"));
			donor.setBloodType(rs.getString("blood_type"));
			donor.setCity(rs.getString("city"));
			donor.setContact(rs.getString("contact"));
			donor.setBloodUnit(rs.getInt("blood_unit"));
			res.add(donor);
			
		}
		st.close();
		rs.close();
		
		return res;
		
	}
}
