/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liias.desarrolloweb.libros.Controladora;

import java.util.ArrayList;
import java.util.List;
import liias.desarrolloweb.libros.Modelo.Area;
import liias.desarrolloweb.libros.Modelo.Notificacion;
import liias.desarrolloweb.libros.Modelo.Usuario;
import liias.desarrolloweb.libros.Service.IAreaService;
import liias.desarrolloweb.libros.Service.INotificacionService;
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
public class Area_Controller {

    @Autowired
    private IAreaService Aserv;
    @Autowired
    private INotificacionService Nserv;

    
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/AreaNew")
    public ModelAndView registrarArea() {
        ModelAndView model = new ModelAndView("registrarArea");
        model.addObject("areaAgregar", new Area());
        
        return model;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/AgregarArea")
    public String adicionarArea(Area are, Model model, Authentication authentication) {
        System.out.println("holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa Area");

        ////////validar///
        boolean a=false;
        boolean e=false;
        boolean m=false;
        for (int i = 0; i < Aserv.findAll().size(); i++) {
            if (are.getManzana().equals(Aserv.findAll().get(i).getManzana())) {
                m=true;
            }
        }
        for (int i = 0; i < Aserv.findAll().size(); i++) {
            if (are.getEdificio().equals(Aserv.findAll().get(i).getEdificio())) {
                e=true;
            }
        }
        for (int i = 0; i < Aserv.findAll().size(); i++) {
            if (are.getApartamento().equals(Aserv.findAll().get(i).getApartamento())) {
                a=true;
            }
        }
        if (m && e && a) {
            return "errorArea";
        }
        ////////////////validar
        
        Aserv.Salvar(are);

        return gestArea(model, authentication);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/gestionarArea")
    public String gestArea(Model model, Authentication authentication) {
        model.addAttribute("Areassss", Aserv.findAll());

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
        model.addAttribute("notificacioness", listNotificacion);
        model.addAttribute("cantNotificaciones", listNotificacion.size());
        //////////////////////     NOTIFICACIONES .////////////////////////
        //////////////////////     NOTIFICACIONES .////////////////////////
        //////////////////////     NOTIFICACIONES .////////////////////////
        return "gestionarArea";
    }
    
 @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/ModificarArea")
    public ModelAndView modArea(Area us) {
        Area l = Aserv.Obtener(us.getId());

//      System.out.println("asdfasdf"+ l.getTitulo());
        return new ModelAndView("registrarArea").addObject("areaAgregar", l);

    }

//    @PreAuthorize("hasAuthority('ADMIN')")
//    @GetMapping("/EliminarArea/Dele")
//    public String DeleArea(Model modelo, Area uus, Authentication authentication) {
//        Area l = Aserv.Obtener(uus.getId());
//        Aserv.Del(l);
//        return gestArea(modelo, authentication);
//    }
    
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/EliminarArea/{id}")
    public String DeleArea(@PathVariable("id") int id,Model modelo, Authentication authentication) {
        Area l = Aserv.Obtener(id);
        Aserv.Del(l);
        return gestArea(modelo, authentication);
    }

}
