package com.Audantizi.PonderandoConAudantizi.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Audantizi.PonderandoConAudantizi.dto.Diario;
import com.Audantizi.PonderandoConAudantizi.dto.RespuestaDiario;
import com.Audantizi.PonderandoConAudantizi.dto.RespuestaSuscriptor;
import com.Audantizi.PonderandoConAudantizi.dto.Suscriptor;
import com.Audantizi.PonderandoConAudantizi.servicio.Servicio;

@RestController
public class Controlador {
	@Autowired
	private Servicio servicio;
	
	@RequestMapping(value = "/buscar-DNI", method = RequestMethod.POST,
            consumes = "application/json;charset=utf-8",
            produces = "application/json;charset=utf-8"
    )
    public @ResponseBody RespuestaSuscriptor buscarPorDNI(@RequestBody Suscriptor dni){
		RespuestaSuscriptor respuestaSuscriptor = new RespuestaSuscriptor();
		respuestaSuscriptor.setLista(servicio.buscarPorDNI(dni));
        return respuestaSuscriptor;
    }
	
	@RequestMapping(value = "/buscar-apellido", method = RequestMethod.POST,
            consumes = "application/json;charset=utf-8",
            produces = "application/json;charset=utf-8"
    )
    public @ResponseBody RespuestaSuscriptor buscarPorApellidos(@RequestBody Suscriptor apellidos){
		RespuestaSuscriptor respuestaSuscriptor = new RespuestaSuscriptor();
		respuestaSuscriptor.setLista(servicio.buscarPorApellidos(apellidos));
        return respuestaSuscriptor;
    }
	
	@RequestMapping(value = "/buscar-codigo", method = RequestMethod.POST,
            consumes = "application/json;charset=utf-8",
            produces = "application/json;charset=utf-8"
    )
    public @ResponseBody RespuestaDiario buscarPorCodigo(@RequestBody Diario codigo){
		RespuestaDiario respuestaDiario = new RespuestaDiario();
		respuestaDiario.setLista(servicio.buscarPorCodigo(codigo));
        return respuestaDiario;
    }
}
