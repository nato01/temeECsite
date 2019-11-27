package com.internousdev.radish.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.radish.dto.MCategoryDTO;
import com.internousdev.radish.util.DBConnector;

public class MCategoryDAO {
	public List<MCategoryDTO> getMCategoryList(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<MCategoryDTO> mCategoryDTO = new ArrayList<MCategoryDTO>();
		String sql = "select * from m_category";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				MCategoryDTO mdto = new MCategoryDTO();
				mdto.setId(resultSet.getInt("id"));
				mdto.setCategoryId(resultSet.getInt("category_id"));
				mdto.setCategoryName(resultSet.getString("category_name"));
				mdto.setCategoryDescription(resultSet.getString("category_description"));
				mCategoryDTO.add(mdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mCategoryDTO;
	}
}
