package com.Audantizi.PonderandoConAudantizi.dao;

import java.util.List;

import com.Audantizi.PonderandoConAudantizi.dto.Diario;
import com.Audantizi.PonderandoConAudantizi.dto.Suscriptor;

public interface Dao {
	public List<Suscriptor> buscarPorDNI(Suscriptor dni);
	public List<Suscriptor> buscarPorApellidos(Suscriptor apellidos);
	public List<Diario> buscarPorCodigo(Diario codigo);
}
