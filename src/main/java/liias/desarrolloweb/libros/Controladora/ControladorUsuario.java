/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liias.desarrolloweb.libros.Controladora;

import java.util.ArrayList;
import java.util.List;
import liias.desarrolloweb.libros.Modelo.Denuncia;
import liias.desarrolloweb.libros.Modelo.Notificacion;
import liias.desarrolloweb.libros.Modelo.Usuario;
import liias.desarrolloweb.libros.Service.INotificacionService;
import liias.desarrolloweb.libros.Service.IUsuarioService;
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
public class ControladorUsuario {

    @Autowired
    private IUsuarioService repoU;
    @Autowired
    private INotificacionService Nserv;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/registrar")
    public ModelAndView registrar() {
        ModelAndView model = new ModelAndView("registrar");
        model.addObject("userAgregar", new Usuario());
        return model;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/AgregarUsuario")
    public String adicionarUsuario(Usuario usua, Model model, Authentication authentication) {
        System.out.println("holaaaaaaaaaa   holi");

        /////////////validarrrrrrrrrrrrrrrrrrr///  
        boolean f = false;

        for (int i = 0; i < repoU.findAll().size(); i++) {
            
            System.out.println("for id existente");
            
            if (usua.getId() == repoU.findAll().get(i).getId()) {
                System.out.println(" hay una id , se esta modificanco ");
                f = true;
            }
        }

        if (!f) {
            System.out.println("no hay id igual");
            for (int i = 0; i < repoU.findAll().size(); i++) {
                System.out.println("for de comprobar usuarios ");
                if (usua.getUsuarios().equals(repoU.findAll().get(i).getUsuarios())) {
                    System.out.println("usuario existente");
                   return "errorUsuario";
                }
            }
        }






        
////////////validarrrrrrrrrrrrrrrrrrr///

        usua.setRol("Usuario");
        repoU.Salvar(usua);

        return gestU(model, authentication);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/GestUsuarios")
    public String gestU(Model model, Authentication authentication) {
        model.addAttribute("Usuarioss", repoU.findAll());

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

        return "usuarios";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/ModificarUsuario")
    public ModelAndView mod(Usuario us) {
        Usuario l = repoU.Obtener(us.getId());
//      System.out.println("asdfasdf"+ l.getTitulo());
        return new ModelAndView("registrar").addObject("userAgregar", l);

    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/EliminarUsuario/{id}")
    public String DeleD(@PathVariable("id") int id, Model modelo, Authentication authentication) {
        Usuario l = repoU.Obtener(id);

//        System.out.println("a");
//        for (int i = 0; i < Nserv.findAll().size(); i++) {
//            System.out.println("b");
//            
//            if (Nserv.findbyId(i)!==null) {
//                
//            }
//                if (l.getId() == Nserv.findAll().get(id)) {
//                    System.out.println("c");
//                    Nserv.Del(Nserv.Obtener(i));
//                }
//            
//
//        }
        repoU.Del(l);
        return gestU(modelo, authentication);
    }

}
