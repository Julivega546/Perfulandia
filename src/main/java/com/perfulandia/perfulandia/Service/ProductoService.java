package com.perfulandia.perfulandia.Service;

import com.perfulandia.perfulandia.model.Producto;
import com.perfulandia.perfulandia.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;



    public List<Producto> findall(){
        return productoRepository.findAll();
    }
    public Producto findById(Long id){
        return  productoRepository.findById(id).get();
    }
    public Producto save(Producto producto ){
        return productoRepository.save(producto);
    }
    public void delete(long id){
        productoRepository.deleteById(id);
    }
}
