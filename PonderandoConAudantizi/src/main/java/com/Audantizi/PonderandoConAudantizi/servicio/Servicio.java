package com.Audantizi.PonderandoConAudantizi.servicio;

import java.util.List;

import com.Audantizi.PonderandoConAudantizi.dto.Diario;
import com.Audantizi.PonderandoConAudantizi.dto.Suscriptor;

public interface Servicio {
	public List<Suscriptor> buscarPorDNI(Suscriptor dni);
	public List<Suscriptor> buscarPorApellidos(Suscriptor apellidos);
	public List<Diario> buscarPorCodigo(Diario codigo);
	
}
