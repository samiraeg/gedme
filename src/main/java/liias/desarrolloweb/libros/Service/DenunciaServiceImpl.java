/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liias.desarrolloweb.libros.Service;

import java.util.List;
import liias.desarrolloweb.libros.Modelo.Denuncia;
import liias.desarrolloweb.libros.Repo.IDenunciaRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mapa
 */
@Service
public class DenunciaServiceImpl implements IDenunciaService {

    @Autowired
    private IDenunciaRepo dRepo;

    public DenunciaServiceImpl() {
    }

    public DenunciaServiceImpl(IDenunciaRepo personaRepo) {
        this.dRepo = personaRepo;
    }

    @Override
    public Denuncia Salvar(Denuncia p) {
        return dRepo.save(p);
    }

    @Override
    public List<Denuncia> findAll() {
        return dRepo.findAll();
    }

    @Override
    public void Eliminar(Integer id) {
        dRepo.deleteById(id);
    }

    @Override
    public void Del(Denuncia l) {
        dRepo.delete(l);
    }

    @Override
    public Denuncia Obtener(int i) {
        return dRepo.getOne(i);
    }


}
