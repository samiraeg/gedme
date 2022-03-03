/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liias.desarrolloweb.libros.Service;

import java.util.List;
import liias.desarrolloweb.libros.Modelo.Usuario;
import liias.desarrolloweb.libros.Repo.IUsuarioRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author mapa
 */
@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepo repo;

    @Autowired
    private PasswordEncoder encoder;

    public UsuarioServiceImpl() {
    }

    public UsuarioServiceImpl(IUsuarioRepo personaRepo) {
        this.repo = personaRepo;
    }

    @Override
    public Usuario Salvar(Usuario usuario) {
        usuario.setPass(encoder.encode(usuario.getPass()));
        return repo.save(usuario);
    }

    @Override
    public List<Usuario> findAll() {
        return repo.findAll();
    }

    @Override
    public void Eliminar(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public void Del(Usuario l) {
        repo.delete(l);
    }

    @Override
    public Usuario Obtener(int i) {
        return repo.getOne(i);
    }

    @Override
    public Usuario findBynombre(String nombre) {
        return repo.findBynombre(nombre).orElse(null);
    }

    @Override
    public Usuario findByusuarios(String usuarios) {
        return repo.findByusuarios(usuarios).orElse(null);
    }

  
}
