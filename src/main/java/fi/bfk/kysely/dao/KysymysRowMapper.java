package fi.bfk.kysely.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.bfk.kysely.bean.Kysymys;

	public class KysymysRowMapper implements RowMapper<Kysymys>  {

		public Kysymys mapRow(ResultSet rs, int rowNum) throws SQLException {
			Kysymys k = new Kysymys();
			k.setId(rs.getInt("id"));
			k.setKysymys(rs.getString("kysymys"));
			k.setKysely_id(rs.getInt("kysely_id"));
			return k;
		}

	}