/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liias.desarrolloweb.libros.Repo;

import liias.desarrolloweb.libros.Modelo.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mapa
 */
@Repository
public interface IAreaRepo extends JpaRepository<Area, Integer>{
//    Usuario findByNombre(String nombre);
    //findBy es una palabra reserva por tanto se puede utilizar 
    //para modificar lo q uno desee, en este caso buscar poor nombre
    // es el atributo nombre pero despues de un findBy lo q sigue es con mayuscula
    
}
