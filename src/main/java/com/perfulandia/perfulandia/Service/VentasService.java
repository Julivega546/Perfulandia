package com.perfulandia.perfulandia.Service;

import com.perfulandia.perfulandia.model.Ventas;
import com.perfulandia.perfulandia.repository.VentasRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class VentasService {

    @Autowired
    private VentasRepository ventasRepository;

    public List<Ventas> findall(){
        return ventasRepository.findAll();
    }
    public Ventas findById(Long id){
        return  ventasRepository.findById(id).get();
    }
    public Ventas save(Ventas ventas ){
        return ventasRepository.save(ventas);
    }
    public void delete(long id) {
        ventasRepository.deleteById(id);
    }
}
