/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liias.desarrolloweb.libros.Service;

import java.util.List;
import liias.desarrolloweb.libros.Modelo.Denuncia;
/**
 *
 * @author mapa
 */
public interface IDenunciaService {
    public Denuncia Salvar(Denuncia p);
    public List<Denuncia> findAll();
    public void Eliminar(Integer id);
    public void Del(Denuncia l);
    public Denuncia Obtener(int i);
    
}
