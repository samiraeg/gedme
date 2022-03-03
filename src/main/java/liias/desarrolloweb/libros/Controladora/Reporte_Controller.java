/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liias.desarrolloweb.libros.Controladora;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import liias.desarrolloweb.libros.Modelo.Area;
import liias.desarrolloweb.libros.Modelo.Denuncia;
import liias.desarrolloweb.libros.Modelo.Notificacion;
import liias.desarrolloweb.libros.Modelo.Reporte;
import liias.desarrolloweb.libros.Modelo.Usuario;
import liias.desarrolloweb.libros.Service.IAreaService;
import liias.desarrolloweb.libros.Service.IDenunciaService;
import liias.desarrolloweb.libros.Service.INotificacionService;
import liias.desarrolloweb.libros.Service.IReporteService;
import liias.desarrolloweb.libros.Service.IUsuarioService;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Ale
 */
@Controller
public class Reporte_Controller {

    @Autowired
    private IReporteService Rrepo;

    @Autowired
    private INotificacionService Nserv;

    ////////////////////////////////////////REPORTES//////////////////////////////////////////
    ////////////////////////////////////////REPORTES//////////////////////////////////////////
    ////////////////////////////////////////REPORTES//////////////////////////////////////////
    @GetMapping("/Reportes")
    public String gestReportes(Model model, Authentication authentication) {

        model.addAttribute("Reportesss", Rrepo.findAll());

        //////////////////////     NOTIFICACIONES .////////////////////////
        //////////////////////     NOTIFICACIONES .////////////////////////
        //////////////////////     NOTIFICACIONES .////////////////////////
        List<Notificacion> listNotificacion = new ArrayList<>();
        List<Notificacion> l = Nserv.findAll();
        Notificacion n;
        Usuario u;
        for (int i = 0; i < l.size(); i++) {
            n = l.get(i);
            u = n.getUsuario();

            if (authentication.getName().equals(u.getUsuarios())) {
                listNotificacion.add(n);
            }
        }
        model.addAttribute("cantNotificaciones", listNotificacion.size());
        model.addAttribute("notificacioness", listNotificacion);
        //////////////////////     NOTIFICACIONES .////////////////////////
        //////////////////////     NOTIFICACIONES .////////////////////////
        //////////////////////     NOTIFICACIONES .////////////////////////

        return "GEDEM_Reportes";
    }

    @PreAuthorize("hasAuthority('Especialista')")
    @GetMapping("/EliminarReporte/{id}")
    public String Deler(Model modelo, @PathVariable("id") int id, Authentication authentication) {
        System.out.println("jajajjaajjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
        Reporte l = Rrepo.Obtener(id);
        Rrepo.Del(l);

//        return gestReportes(modelo, authentication);
        return "redirect:/Reportes";
    }

    /////////////////////////////////////////////////
    /////////////////////////////////////////////////
    /////////////////////////////////////////////////
    //Notificaionnnnnnnnnnnnnnnnnnnnn
    /////////////////////////////////////////////////
    /////////////////////////////////////////////////
    /////////////////////////////////////////////////
    
    @PreAuthorize("hasAuthority('Especialista')")
    @GetMapping("/GuardarNotificacion/{id}")
    public String Guardar(Model modelo, @PathVariable("id") int id, Authentication authentication) {
        System.out.println("reporte :");

        Reporte l = Rrepo.Obtener(id);
        Denuncia d = l.getDenuncia();
        Usuario u = d.getUsuario();

        Notificacion n = new Notificacion();
        n.setNotificacion(" Su denuncia:" + l.getReporte() + " Ha sido resuelta ");
        n.setUsuario(u);

        Nserv.Salvar(n);

        return gestReportes(modelo, authentication);
    }

    //////////////pdf
}
