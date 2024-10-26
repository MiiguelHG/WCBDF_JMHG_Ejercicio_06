package com.upiiz.orm.Controllers;

import com.upiiz.orm.Models.ClienteEntity;
import com.upiiz.orm.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
    // Inyectar una dependencia de ClienteService
    @Autowired
    private ClienteService clienteService;

    // Listar todos los clientes
    @GetMapping
    public ResponseEntity<List<ClienteEntity>> getAllClientes(){
        return ResponseEntity.ok(clienteService.getAllClientes());
    }

    // Guardar un cliente
    @PostMapping
    public ResponseEntity<ClienteEntity> saveCliente(@RequestBody ClienteEntity cliente){
        return ResponseEntity.created(null).body(clienteService.saveCliente(cliente));
    }

    @GetMapping("/{id}")
    // Buscar un cliente por id
    public ResponseEntity<ClienteEntity> getClienteById(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.getClienteById(id));
    }

    // Actualizar un cliente por id
    @PutMapping("/{id}")
    public ResponseEntity<ClienteEntity> updateCliente(@PathVariable Long id, @RequestBody ClienteEntity cliente) {
        cliente.setId(id);
        return ResponseEntity.ok(clienteService.updateCliente(cliente));
    }

    // Eliminar un cliente por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id){
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }

}
