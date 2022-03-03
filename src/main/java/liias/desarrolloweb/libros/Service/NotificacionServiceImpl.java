/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liias.desarrolloweb.libros.Service;

import java.util.List;
import java.util.Optional;
import liias.desarrolloweb.libros.Modelo.Notificacion;
import liias.desarrolloweb.libros.Repo.INotificacionRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mapa
 */
@Service
public class NotificacionServiceImpl implements INotificacionService {

    @Autowired
    private INotificacionRepo NRepo;

  
    public NotificacionServiceImpl() {
        
    }
    

    @Override
    public Notificacion Salvar(Notificacion p) {
        return NRepo.save(p);
    }

    @Override
    public List<Notificacion> findAll() {
        return NRepo.findAll();
    }

    @Override
    public void Eliminar(Integer id) {
        NRepo.deleteById(id);
    }

    @Override
    public void Del(Notificacion l) {
        NRepo.delete(l);
    }

    @Override
    public Notificacion Obtener(int i) {
        return NRepo.getOne(i);
    }

  

 

}
