/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liias.desarrolloweb.libros.Service;

import java.util.List;
import java.util.Optional;
import liias.desarrolloweb.libros.Modelo.Notificacion;
/**
 *
 * @author mapa
 */
public interface INotificacionService {
    public Notificacion Salvar(Notificacion p);
    public List<Notificacion> findAll();
    public void Eliminar(Integer id);
    public void Del(Notificacion l);
    public Notificacion Obtener(int i);
    
}
