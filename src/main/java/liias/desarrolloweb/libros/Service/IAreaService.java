/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liias.desarrolloweb.libros.Service;

import java.util.List;
import liias.desarrolloweb.libros.Modelo.Area;
/**
 *
 * @author mapa
 */
public interface IAreaService {
    public Area Salvar(Area p);
    public List<Area> findAll();
    public void Eliminar(Integer id);
    public void Del(Area l);
    public Area Obtener(int i);
}
