/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liias.desarrolloweb.libros.Service;

import java.util.List;
import liias.desarrolloweb.libros.Modelo.Usuario;
/**
 *
 * @author mapa
 */
public interface IUsuarioService {
    public Usuario Salvar(Usuario p);
    public List<Usuario> findAll();
    public void Eliminar(Integer id);
    public void Del(Usuario l);
    public Usuario Obtener(int i);
    public Usuario findBynombre(String nombre);
    public Usuario findByusuarios(String nombre);
}
