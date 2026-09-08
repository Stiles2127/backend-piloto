package com.etul.backend_piloto;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/piloto")
@CrossOrigin(origins = "*")
public class PilotoController {

    @GetMapping("/ping")
    public Map<String, String> probarConexion() {
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("estado", "CONECTADO");
        respuesta.put("mensaje", "Prueba piloto exitosa desde la Nube");
        respuesta.put("empresa", "ETUL S.A.");
        respuesta.put("sedes", "Huaycán, Ñaña, Gálvez, Chorrillos, Lurín");
        return respuesta;
    }
}
