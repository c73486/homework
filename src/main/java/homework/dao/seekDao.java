
package homework.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import homework.model.seek;

public class seekDao implements implSeek {
	String name = new String();

	public seekDao(String name2) {
		name = name2;
	}

	@Override
	public List<seek> selectAll() {
		Connection con = DbConnection.getDB();
		//String SQL="select * from seek";
		List<seek> l = new ArrayList();
		try {
			PreparedStatement ps = con.prepareStatement("select * from seek where name LIKE '%" + name + "%'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {			
				seek s = new seek();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPrice(rs.getInt("price"));
				s.setRemain(rs.getInt("remain"));
				l.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

}
