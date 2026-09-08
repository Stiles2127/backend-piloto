package com.etul.backend_piloto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/ping")
    public Map<String, String> probarConexion() {
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("estado", "CONECTADO");
        respuesta.put("mensaje", "Prueba piloto exitosa desde la Nube");
        respuesta.put("empresa", "ETUL S.A.");
        respuesta.put("sedes", "Huaycán, Ñaña, Gálvez, Chorrillos, Lurín");
        return respuesta;
    }

    @GetMapping("/db-check")
    public Map<String, Object> probarBaseDatos() {
        Map<String, Object> respuesta = new HashMap<>();
        try {
            // Ejecuta una consulta ligera para obtener la versión del motor de MySQL en Aiven
            String version = jdbcTemplate.queryForObject("SELECT VERSION()", String.class);
            String dbNombre = jdbcTemplate.queryForObject("SELECT DATABASE()", String.class);

            respuesta.put("conexion_db", "EXITOSA");
            respuesta.put("base_de_datos", dbNombre);
            respuesta.put("version_mysql", version);
            respuesta.put("mensaje", "Conexión directa confirmada con Aiven MySQL");
        } catch (Exception e) {
            respuesta.put("conexion_db", "FALLIDA");
            respuesta.put("error", e.getMessage());
        }
        return respuesta;
    }
}