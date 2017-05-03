package fi.bfk.kysely.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fi.bfk.kysely.bean.Kysymys;
import fi.bfk.kysely.dao.KysymysRowMapper;
import fi.bfk.kysely.dao.KysymystaEiLoydyPoikkeus;
import fi.bfk.kysely.bean.Vastaus;
import fi.bfk.kysely.bean.VastausKysymykseen;
import fi.bfk.kysely.dao.VastausRowMapper;
import fi.bfk.kysely.dao.VastausKysymykseenRowMapper;

@Repository
public class KysymysDAO {
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void talleta(Kysymys k) {
		final String sql = "INSERT INTO Kysymys(kysymys) VALUES(?)";

		// anonyymi sisäluokka tarvitsee vakioina välitettävät arvot,
		// jotta roskien keruu onnistuu tämän metodin suorituksen päättyessä.
		final String kysymys = k.getKysymys();

		// jdbc pistää generoidun id:n tänne talteen
		KeyHolder idHolder = new GeneratedKeyHolder();

		// suoritetaan päivitys itse määritellyllä PreparedStatementCreatorilla
		// ja KeyHolderilla
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "id" });
				ps.setString(1, kysymys);
				return ps;
			}
		}, idHolder);

		// tallennetaan id takaisin beaniin, koska
		// kutsujalla pitäisi olla viittaus samaiseen olioon
		k.setId(idHolder.getKey().intValue());

	}
	
	public Kysymys etsi(int id) {
		String sql = "SELECT kysymys, id FROM Kysymys WHERE id = ?";
		Object[] parametrit = new Object[] { id };
		RowMapper<Kysymys> mapper = new KysymysRowMapper();

		Kysymys k;
		try {
			k = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new KysymystaEiLoydyPoikkeus(e);
		}
		return k;

	}

	public List<Kysymys> haeKaikki() {

		String sql = "SELECT id, kysymys FROM Kysymys";
		RowMapper<Kysymys> mapper = new KysymysRowMapper();
		List<Kysymys> kysymykset = jdbcTemplate.query(sql, mapper);

		return kysymykset;
	}
	
	//Vastaus osio:
	
	public void talletaVastaus(VastausKysymykseen vk) {
		final String sql = "INSERT INTO Vastaus(vastaus, kysymys_id) VALUES(?, ?)";

		// anonyymi sisäluokka tarvitsee vakioina välitettävät arvot,
		// jotta roskien keruu onnistuu tämän metodin suorituksen päättyessä.
		final String vastaus = vk.getVastaus();
		final int kysymys_id = vk.getKysymys_id();

		// jdbc pistää generoidun id:n tänne talteen
		KeyHolder idHolder = new GeneratedKeyHolder();

		// suoritetaan päivitys itse määritellyllä PreparedStatementCreatorilla
		// ja KeyHolderilla
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "id" });
				ps.setString(1, vastaus);
				ps.setInt(2, kysymys_id);
				return ps;
			}
		}, idHolder);

		// tallennetaan id takaisin beaniin, koska
		// kutsujalla pitäisi olla viittaus samaiseen olioon
		v.setId(idHolder.getKey().intValue());

	}
	
	public Vastaus etsiVastaus(int id) {
		String sql = "SELECT vastaus, id FROM Vastaus WHERE id = ?";
		Object[] parametrit = new Object[] { id };
		RowMapper<Vastaus> mapper = new VastausRowMapper();

		Vastaus v;
		try {
			v = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new KysymystaEiLoydyPoikkeus(e);
		}
		return v;

	}

	public List<VastausKysymykseen> haeKaikkiVastaukset() {

		String sql = "SELECT vastaus, Vastaus.id, kysymys, kysymys_id FROM Vastaus JOIN  Kysymys ON Vastaus.kysymys_id=Kysymys.id";
		RowMapper<VastausKysymykseen> mapper = new VastausKysymykseenRowMapper();
		List<VastausKysymykseen> vastaukset = jdbcTemplate.query(sql, mapper);

		return vastaukset;
	}
}
//Testikommentti
