package fi.bfk.kysely.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.bfk.kysely.bean.Vastaus;

public class VastausRowMapper implements RowMapper<Vastaus>  {

	public Vastaus mapRow(ResultSet rs, int rowNum) throws SQLException {
		Vastaus v = new Vastaus();
		v.setId(rs.getInt("id"));
		v.setVastaus(rs.getString("vastaus"));
		v.setKysymys_id(rs.getInt("kysymys_id"));
		
		return v;
	}

}
