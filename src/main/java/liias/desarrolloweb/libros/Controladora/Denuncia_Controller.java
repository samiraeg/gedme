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
public class Denuncia_Controller {

    @Autowired
    private IDenunciaService Drepo;
    @Autowired
    private IUsuarioService Urepo;
    @Autowired
    private IReporteService Rrepo;
    @Autowired
    private IAreaService Asrvi;
    @Autowired
    private INotificacionService Nserv;

    
    @GetMapping("/Rdenuncia")
    public ModelAndView Rdenuncia(Model modal, Authentication authentication) {
        ModelAndView model = new ModelAndView("registrardenuncia");

        List<Area> listArea = Asrvi.findAll();
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
        model.addObject("notificacioness", listNotificacion);
        model.addObject("cantNotificaciones", listNotificacion.size());
        //////////////////////     NOTIFICACIONES .////////////////////////
        //////////////////////     NOTIFICACIONES .////////////////////////
        //////////////////////     NOTIFICACIONES .////////////////////////

        model.addObject("userAgregar", new Denuncia());
        model.addObject("listArea", listArea);

        return model;
    }

    @PostMapping("/AgregarDenuncia")
    public String adicionarDenuncia(Model modelo, Denuncia usua, Authentication authentication) {


        ////////////////hacer el findBynombre
        Usuario u = Urepo.findByusuarios(authentication.getName());
        
        usua.setUsuario(u);
        Drepo.Salvar(usua);
        return "redirect:/main";
    }


    @PreAuthorize("hasAnyAuthority('ADMIN','Especialista')")
    @GetMapping("/GestDenuncia")
    public String gestDenuncia(Model model, Authentication authentication) {
        model.addAttribute("Denunciass", Drepo.findAll());

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

        return "informesdedenuncia";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','Especialista')")
    @GetMapping("/ModificarDenuncia")
    public ModelAndView modD(Denuncia us) {
        Denuncia l = Drepo.Obtener(us.getId());
        List<Area> listArea = Asrvi.findAll();
//      System.out.println("asdfasdf"+ l.getTitulo());
        return new ModelAndView("registrardenuncia").addObject("userAgregar", l).addObject("listArea", listArea);

    }

 
   @PreAuthorize("hasAuthority('Especialista')")
    @GetMapping("/EliminarDenuncia/{id}")
    public String DeleD(@PathVariable("id") int id,Model modelo, Authentication authentication) {
        Denuncia l = Drepo.Obtener(id);
        Drepo.Del(l);
        return gestDenuncia(modelo, authentication);
    }

    
    
    
                              //GENERAR REPORTE
                              //GENERAR REPORTE
                              //GENERAR REPORTE
                              //GENERAR REPORTE
                              //GENERAR REPORTE
    /////////////////////////////////////REPORTES//////////////////////////////////////////
    ////////////////////////////////////////REPORTES//////////////////////////////////////////
    ////////////////////////////////////////REPORTES//////////////////////////////////////////
     @PreAuthorize("hasAnyAuthority('ADMIN','Especialista')")
    @GetMapping("/GenerarReporte{id}")
    public String GenerR(@PathVariable("id") int id, Model modelo, Authentication authentication) {
        Reporte r = new Reporte();

        Denuncia l = Drepo.Obtener(id);
        
        
         System.out.println("jaajajjajaja");
         for (int i = 0; i < Rrepo.findAll().size(); i++) {
             System.out.println("entre al for, iteracion:"+i);
             System.out.println("el id del repo con su denuncia"+Rrepo.findAll().get(i).getDenuncia().getId());
             if(id==Rrepo.findAll().get(i).getDenuncia().getId()){
                 System.out.println("iffffffffffffffffffffffff");
                 return "errorReporte";
             }
                 
         }
                 System.out.println("locura");
        
        
        
        
        r.setReporte("Area: " + l.getArea().getManzana() + "/" + l.getArea().getEdificio() + "/" + l.getArea().getApartamento() + "; Descripcion:  " + l.getDescripcion());
        r.setDenuncia(l);

        //////////////////////////////////////Fotossssssssssssssssss     
        //////////////////////////////////////Fotossssssssssssssssss     
        //////////////////////////////////////Fotossssssssssssssssss  
        if (l.getArea().getManzana().equals("1")) {
                r.setFoto("/img/1.jpg");
           
        }
        if (l.getArea().getManzana().equals("2")) {
                r.setFoto("/img/2.jpg");
           
        }
        if (l.getArea().getManzana().equals("3")) {
                r.setFoto("/img/3.jpg");
           
        }
        if (l.getArea().getManzana().equals("4")) {
                r.setFoto("/img/4.jpg");
           
        }
        if (l.getArea().getManzana().equals("5")) {
                r.setFoto("/img/5.jpg");
           
        }
        
        //////////////////////////////////////Fotossssssssssssssssss     
        //////////////////////////////////////Fotossssssssssssssssss     
        //////////////////////////////////////Fotossssssssssssssssss
     
        Rrepo.Salvar(r);
        return gestDenuncia(modelo, authentication);

    }

 

}
