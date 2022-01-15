package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.bean.DanhMuc;

public class DanhMucDao {
	public static ArrayList<DanhMuc> getDM() {
		Connection conn = DBConnection.getConnect();
		ArrayList<DanhMuc> DanhMuc = new ArrayList<>();
		
		try {
			ResultSet rs = conn.prepareStatement("select * from danhmuc order by maDM desc").executeQuery();
			while(rs.next()) {
				DanhMuc danhMuc = new DanhMuc();
				danhMuc.setMaDM(rs.getInt("maDM"));
				danhMuc.setTenDM(rs.getString("tenDM"));
				
				DanhMuc.add(danhMuc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return DanhMuc;
	}
	
	public static boolean addCatalog(DanhMuc catalog) {
		Connection conn = DBConnection.getConnect();
		try {
			String sql ="insert into danhmuc('tenDM') values ('"+catalog.getTenDM()+"')";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();	
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false ;
		}
		
	}
	public static void main(String[] args) {
			System.out.println("size của mảng:"+getDM().size());
		}
}
