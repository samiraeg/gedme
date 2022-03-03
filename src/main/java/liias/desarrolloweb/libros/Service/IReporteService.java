/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liias.desarrolloweb.libros.Service;

import java.util.List;
import liias.desarrolloweb.libros.Modelo.Reporte;
/**
 *
 * @author mapa
 */
public interface IReporteService {
    public Reporte Salvar(Reporte p);
    public List<Reporte> findAll();
    public void Eliminar(Integer id);
    public void Del(Reporte l);
    public Reporte Obtener(int i);
}
