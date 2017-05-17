package fi.bfk.kysely.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.bfk.kysely.bean.PerusKysely;

public class PerusKyselyRowMapper implements RowMapper<PerusKysely>  {

	public PerusKysely mapRow(ResultSet rs, int rowNum) throws SQLException {
		PerusKysely ky = new PerusKysely();
		ky.setId(rs.getInt("id"));
		ky.setNimi(rs.getString("nimi"));
		ky.setId(rs.getInt("id"));
		
		return ky;
	}

}