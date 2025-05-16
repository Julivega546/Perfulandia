package com.perfulandia.perfulandia.Service;

import com.perfulandia.perfulandia.model.Proveedores;
import com.perfulandia.perfulandia.repository.ProveedoresRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProveedorService {

    @Autowired
    private ProveedoresRepository proveedoresRepository;

    public List<Proveedores> findall(){
        return proveedoresRepository.findAll();
    }
    public Proveedores findById(Long id){
        return  proveedoresRepository.findById(id).get();
    }
    public Proveedores save(Proveedores proveedores ){
        return proveedoresRepository.save(proveedores);
    }
    public void delete(long id) {
        proveedoresRepository.deleteById(id);
    }
}
