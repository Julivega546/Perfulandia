package com.perfulandia.perfulandia.Controller;


import com.perfulandia.perfulandia.Service.InventarioService;
import com.perfulandia.perfulandia.model.Inventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Inventario")
public class InventarioController {
    @Autowired
    private InventarioService inventarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Inventario> buscar(@PathVariable Long id){
        try{
            Inventario inventario =inventarioService.findById(id);
            return ResponseEntity.ok(inventario);
        } catch ( Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try {
            inventarioService.delete(id);
            return ResponseEntity.noContent().build();

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Inventario> guardar(@RequestBody Inventario inventario){
        Inventario inventario1 =inventarioService.save(inventario);
        return ResponseEntity.status(HttpStatus.CREATED).body(inventario1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventario> actualizar(@PathVariable Integer id, @RequestBody Inventario inventario){
        try {
            Inventario inventario1 = inventarioService.findById(id.longValue());
            inventario1.setCantidad(inventario1.getCantidad());
            inventario1.setId(inventario1.getId());
            inventario1.setProducto(inventario1.getProducto());
            inventario1.setTipoMovimiento(inventario1.getTipoMovimiento());




            inventarioService.save(inventario1);
            return ResponseEntity.ok(inventario);
        } catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }

}
