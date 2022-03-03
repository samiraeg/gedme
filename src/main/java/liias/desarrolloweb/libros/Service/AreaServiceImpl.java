/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liias.desarrolloweb.libros.Service;

import java.util.List;
import liias.desarrolloweb.libros.Modelo.Area;
import liias.desarrolloweb.libros.Repo.IAreaRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mapa
 */
@Service
public class AreaServiceImpl implements IAreaService {

    @Autowired
    private IAreaRepo ARepo;

    public AreaServiceImpl() {
    }

    public AreaServiceImpl(IAreaRepo areaRepo) {
        this.ARepo = areaRepo;
    }

    @Override
    public Area Salvar(Area p) {
        return ARepo.save(p);
    }

    @Override
    public List<Area> findAll() {
        return ARepo.findAll();
    }

    @Override
    public void Eliminar(Integer id) {
        ARepo.deleteById(id);
    }

    @Override
    public void Del(Area l) {
        ARepo.delete(l);
    }

    @Override
    public Area Obtener(int i) {
        return ARepo.getOne(i);
    }

}
