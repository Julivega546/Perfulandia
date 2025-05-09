package com.perfulandia.perfulandia.Controller;


import com.perfulandia.perfulandia.Service.ClienteService;
import com.perfulandia.perfulandia.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        List<Cliente> clientes = clienteService.findAll();
        if (clientes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<Cliente> guardar(@RequestBody Cliente cliente){
        Cliente clienteNuevo =clienteService.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteNuevo);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable Integer id){
        try{
            Cliente cliente = clienteService.findById(id);
            return ResponseEntity.ok(cliente);
        } catch ( Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizar (@PathVariable Integer id , @RequestBody Cliente cliente){
       try {
           Cliente cli = clienteService.findById(id);
           cli.setId(id);
           cli.setRun(cliente.getRun());
           cli.setNombre(cliente.getNombre());
           cli.setApellido(cliente.getApellido());
           cli.setCorreo(cliente.getCorreo());
           clienteService.save(cli);
           return ResponseEntity.ok(cliente);
       } catch (Exception e){
           return ResponseEntity.notFound().build();
       }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try {
            clienteService.delete(id);
            return ResponseEntity.noContent().build();

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
