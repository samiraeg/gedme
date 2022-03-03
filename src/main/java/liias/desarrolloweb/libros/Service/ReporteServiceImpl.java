/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liias.desarrolloweb.libros.Service;

import java.util.List;
import liias.desarrolloweb.libros.Modelo.Reporte;
import liias.desarrolloweb.libros.Repo.IReporteRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mapa
 */
@Service
public class ReporteServiceImpl implements IReporteService {

    @Autowired
    private IReporteRepo RRepo;

    public ReporteServiceImpl(IReporteRepo RRepo) {
        this.RRepo = RRepo;
    }

    public ReporteServiceImpl() {
    }

    @Override
    public Reporte Salvar(Reporte p) {
        return RRepo.save(p);
    }

    @Override
    public List<Reporte> findAll() {
        return RRepo.findAll();
    }

    @Override
    public void Eliminar(Integer id) {
        RRepo.deleteById(id);
    }

    @Override
    public void Del(Reporte l) {
        RRepo.delete(l);
    }

    @Override
    public Reporte Obtener(int i) {
        return RRepo.getOne(i);
    }

}
