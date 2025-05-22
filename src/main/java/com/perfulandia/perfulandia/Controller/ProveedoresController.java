package com.perfulandia.perfulandia.Controller;


import com.perfulandia.perfulandia.Service.ProveedorService;
import com.perfulandia.perfulandia.model.Cliente;
import com.perfulandia.perfulandia.model.Inventario;
import com.perfulandia.perfulandia.model.Proveedores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/proveedores")
public class ProveedoresController {
    @Autowired
    private ProveedorService proveedorService;


    @GetMapping
    public ResponseEntity<List<Proveedores>> listar() {
        List<Proveedores> proveedores = proveedorService.findall();
        if (proveedores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(proveedores);
    }

    @PostMapping
    public ResponseEntity<Proveedores> guardar(@RequestBody Proveedores proveedores){
        Proveedores proveedoresnuevo =proveedorService.save(proveedores);
        return ResponseEntity.status(HttpStatus.CREATED).body(proveedoresnuevo);
    }


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
    public ResponseEntity<Proveedores> actualizar(@PathVariable Integer id, @RequestBody Proveedores proveedores){
        try {
            Proveedores proveedoresnuevo = proveedorService.findById(id.longValue());
            proveedoresnuevo.setApellido(proveedoresnuevo.getApellido());
            proveedoresnuevo.setId(proveedoresnuevo.getId());
            proveedoresnuevo.setDireccion(proveedoresnuevo.getDireccion());
            proveedoresnuevo.setNombre(proveedoresnuevo.getNombre());
            proveedoresnuevo.setCorreo(proveedoresnuevo.getCorreo());
            proveedoresnuevo.setRun(proveedoresnuevo.getRun());
            proveedoresnuevo.setNumero(proveedoresnuevo.getNumero());




            proveedorService.save(proveedoresnuevo);
            return ResponseEntity.ok(proveedores);
        } catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }
}
