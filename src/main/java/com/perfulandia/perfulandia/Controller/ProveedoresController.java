package com.perfulandia.perfulandia.Controller;


import com.perfulandia.perfulandia.Service.ProveedorService;
import com.perfulandia.perfulandia.model.Producto;
import com.perfulandia.perfulandia.model.Proveedores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Proveedores")
public class ProveedoresController {
    @Autowired
    private ProveedorService proveedorService;



    @GetMapping("/{id}")
    public ResponseEntity<Proveedores> buscar(@PathVariable Long id){
        try{
            Proveedores proveedores =proveedorService.findById(id);
            return ResponseEntity.ok(proveedores);
        } catch ( Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try {
            proveedorService.delete(id);
            return ResponseEntity.noContent().build();

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Integer id, @RequestBody Producto producto){
        try {
            Proveedores proveedoresnuevo = proveedorService.findById(id.longValue());
            proveedoresnuevo.setApellido(proveedoresnuevo.getApellido());
            proveedoresnuevo.setId(proveedoresnuevo.getId());
            proveedoresnuevo.setDireccion(proveedoresnuevo.getDireccion());
            proveedoresnuevo.setNombre(proveedoresnuevo.getNombre());
            proveedoresnuevo.setCorreo(proveedoresnuevo.getCorreo());
            proveedoresnuevo.setRun(proveedoresnuevo.getRun());




            proveedorService.save(proveedoresnuevo);
            return ResponseEntity.ok(producto);
        } catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }
}
