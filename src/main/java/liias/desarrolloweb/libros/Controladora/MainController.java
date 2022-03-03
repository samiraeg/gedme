/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liias.desarrolloweb.libros.Controladora;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import liias.desarrolloweb.libros.Modelo.Notificacion;
import liias.desarrolloweb.libros.Modelo.Usuario;
import liias.desarrolloweb.libros.Service.INotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Ale
 */
@Controller
public class MainController {
    @Autowired
    private INotificacionService Nserv;
    
     @GetMapping(path = {"/login", "/", "/index"})
    public String login() {
        return "login";
    }
 
    
    @GetMapping("/main")
    public String DenunciaMain(HttpSession session, Model model,Authentication authentication) {
        SecurityContext ctx = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
        Authentication auth = ctx.getAuthentication();//aqui está toda la informacion del user 
        
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
        return "GEDEM";
    }
}
