/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liias.desarrolloweb.libros.Controladora;

import liias.desarrolloweb.libros.Modelo.Denuncia;
import liias.desarrolloweb.libros.Modelo.Notificacion;
import liias.desarrolloweb.libros.Modelo.Reporte;

import liias.desarrolloweb.libros.Service.INotificacionService;
import liias.desarrolloweb.libros.Service.IReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Ale
 */
@Controller
public class Notificacion_Controller {

    @Autowired
    private INotificacionService Nserv;
    

    

     @GetMapping("/EliminarNotificacion")
    public String EliminarNotificacion(Model modelo, Notificacion uus,Authentication authentication) {
        Notificacion l = Nserv.Obtener(uus.getId());
        l.setUsuario(null);
        Nserv.Del(l);
        return "redirect:/main" ;
    }
  
}
