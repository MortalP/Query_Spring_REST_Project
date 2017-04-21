package fi.bfk.kysely.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.bfk.kysely.bean.VastausKysymykseen;

public class VastausKysymykseenRowMapper   implements RowMapper<VastausKysymykseen>  {
	
	public VastausKysymykseen mapRow(ResultSet rs, int rowNum) throws SQLException {
		VastausKysymykseen vk = new VastausKysymykseen();
		vk.setId(rs.getInt("id"));
		vk.setVastaus(rs.getString("vastaus"));
		vk.setKysymys_id(rs.getInt("kysymys_id"));
		vk.setKysymys(rs.getString("kysymys"));
		
		return vk;
	}

}