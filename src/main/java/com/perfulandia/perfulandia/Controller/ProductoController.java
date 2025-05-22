package com.perfulandia.perfulandia.Controller;


import com.perfulandia.perfulandia.Service.ProductoService;
import com.perfulandia.perfulandia.model.Inventario;
import com.perfulandia.perfulandia.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/producto")
public class ProductoController{

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> listar() {
        List<Producto> productos = productoService.findall();
        if (productos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscar(@PathVariable Long id){
        try{
            Producto producto =productoService.findById(id);
            return ResponseEntity.ok(producto);
        } catch ( Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try {
            productoService.delete(id);
            return ResponseEntity.noContent().build();

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Producto> guardar(@RequestBody Producto producto){
        Producto productonuevo =productoService.save(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productonuevo);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Integer id, @RequestBody Producto producto){
        try {
            Producto productonuevo = productoService.findById(id.longValue());
            productonuevo.setDescripcion(productonuevo.getDescripcion());
            productonuevo.setId(productonuevo.getId());
            productonuevo.setPrecio(productonuevo.getPrecio());
            productonuevo.setNombre(productonuevo.getNombre());
            productonuevo.setStock(productonuevo.getStock());


            productoService.save(productonuevo);
            return ResponseEntity.ok(producto);
        } catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }

}
