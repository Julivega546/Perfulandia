package com.perfulandia.perfulandia.Controller;


import com.perfulandia.perfulandia.Service.VentasService;
import com.perfulandia.perfulandia.model.Ventas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ventas")
public class VentasController {
    @Autowired
    private VentasService ventasService;

    @PutMapping("/{id}")
    public ResponseEntity<Ventas> actualizar(@PathVariable Integer id, @RequestBody Ventas ventas){
        try {
            Ventas ventas1 = ventasService.findById(id.longValue());
            ventas1.setFechaVenta(ventas1.getFechaVenta());
            ventas1.setTotal(ventas1.getTotal());


            ventasService.save(ventas1);
            return ResponseEntity.ok(ventas);
        } catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ventas> buscar(@PathVariable Integer id){
        try{
            Ventas ventas = ventasService.findById(id.longValue());
            return ResponseEntity.ok(ventas);
        } catch ( Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try {
            ventasService.delete(id);
            return ResponseEntity.noContent().build();

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Ventas> guardar(@RequestBody Ventas ventas){
        Ventas ventanueva =ventasService.save(ventas);
        return ResponseEntity.status(HttpStatus.CREATED).body(ventanueva);
    }
}
