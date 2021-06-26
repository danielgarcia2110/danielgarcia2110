package com.Audantizi.PonderandoConAudantizi.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Audantizi.PonderandoConAudantizi.dao.Dao;
import com.Audantizi.PonderandoConAudantizi.dto.Diario;
import com.Audantizi.PonderandoConAudantizi.dto.Suscriptor;

@Service
@Transactional
public class ServicioImpl implements Servicio {
	@Autowired
	private Dao dao;

	public List<Suscriptor> buscarPorDNI(Suscriptor dni) {
		return dao.buscarPorDNI(dni);
	}

	@Override
	public List<Suscriptor> buscarPorApellidos(Suscriptor apellidos) {
		return dao.buscarPorApellidos(apellidos);
	}

	@Override
	public List<Diario> buscarPorCodigo(Diario codigo) {
		return dao.buscarPorCodigo(codigo);
	}

}
