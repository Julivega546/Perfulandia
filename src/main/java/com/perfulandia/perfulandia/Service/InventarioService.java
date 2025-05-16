package com.perfulandia.perfulandia.Service;

import com.perfulandia.perfulandia.model.Inventario;
import com.perfulandia.perfulandia.repository.InventarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    public List<Inventario> findall(){
        return inventarioRepository.findAll();
    }
    public Inventario findById(Long id){
        return  inventarioRepository.findById(id).get();
    }
    public Inventario save(Inventario inventario ){
        return inventarioRepository.save(inventario);
    }
    public void delete(long id) {
        inventarioRepository.deleteById(id);
    }
}
