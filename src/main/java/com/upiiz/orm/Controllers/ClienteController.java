package com.upiiz.orm.Controllers;

import com.upiiz.orm.Models.ClienteEntity;
import com.upiiz.orm.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
@RequestMapping("/api/v1/clientes")
public class ClienteController {
    // Inyectar una dependencia de ClienteService
    @Autowired
    private ClienteService clienteService;

    // Listar todos los clientes
    public ResponseEntity<List<ClienteEntity>> getAllClientes(){
        return ResponseEntity.ok(clienteService.getAllClientes());
    }

    // Guardar un cliente
    public ResponseEntity<ClienteEntity> saveCliente(@RequestBody ClienteEntity cliente){
        return ResponseEntity.created(null).body(clienteService.saveCliente(cliente));
    }

    // Buscar un cliente por id
    public ResponseEntity<ClienteEntity> getClienteById(Long id){
        return ResponseEntity.ok(clienteService.getClienteById(id));
    }

}
