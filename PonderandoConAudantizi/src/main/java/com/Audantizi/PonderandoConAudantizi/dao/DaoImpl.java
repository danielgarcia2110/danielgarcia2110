package com.Audantizi.PonderandoConAudantizi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Audantizi.PonderandoConAudantizi.dto.Diario;
import com.Audantizi.PonderandoConAudantizi.dto.Suscriptor;

@Repository
public class DaoImpl implements Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private Connection conexion;

	private void obtenerConexion() throws SQLException {
		conexion = jdbcTemplate.getDataSource().getConnection();
	}

	private void cerrarConexion() throws SQLException {
		conexion.close();
		conexion = null;
	}

	@Override
	public List<Suscriptor> buscarPorDNI(Suscriptor dni) {
		List<Suscriptor> lista = new ArrayList<Suscriptor>();

		try {
			obtenerConexion();
			String sql = "SELECT dni,nombres,apellidos"
					+ " FROM suscriptor"
					+ " WHERE dni = ? ";
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, dni.getDni());
			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				Suscriptor suscriptor = new Suscriptor();
				suscriptor.setDni(resultado.getString("dni"));
				suscriptor.setNombres(resultado.getString("nombres"));
				suscriptor.setApellidos(resultado.getString("apellidos"));

				lista.add(suscriptor);
			}
			resultado.close();
			sentencia.close();
			cerrarConexion();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return lista;
	}

	public List<Suscriptor> buscarPorApellidos(Suscriptor apellidos) {
		List<Suscriptor> lista = new ArrayList<Suscriptor>();

		try {
			obtenerConexion();
			String sql = "SELECT dni,nombres,apellidos"
					+ " FROM suscriptor"
					+ " WHERE apellidos = ? ";
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, apellidos.getApellidos());
			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				Suscriptor suscriptor = new Suscriptor();
				suscriptor.setDni(resultado.getString("dni"));
				suscriptor.setNombres(resultado.getString("nombres"));
				suscriptor.setApellidos(resultado.getString("apellidos"));

				lista.add(suscriptor);
			}
			resultado.close();
			sentencia.close();
			cerrarConexion();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return lista;
	}

	@Override
	public List<Diario> buscarPorCodigo(Diario codigo) {
		List<Diario> lista = new ArrayList<Diario>();

		try {
			obtenerConexion();
			String sql = "SELECT codigo_diario, nombre,precio_unitario"
					+ " FROM diario"
					+ " WHERE codigo_diario = ? ";
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, codigo.getCodigo());
			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				Diario diario = new Diario();
				diario.setCodigo(resultado.getString("codigo_diario"));
				diario.setNombre(resultado.getString("nombre"));
				diario.setPrecioUnitario(resultado.getDouble("precio_unitario"));

				lista.add(diario);
			}
			resultado.close();
			sentencia.close();
			cerrarConexion();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return lista;
	}

}
