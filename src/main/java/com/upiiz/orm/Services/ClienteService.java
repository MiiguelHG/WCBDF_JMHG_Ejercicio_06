package com.upiiz.orm.Services;

import com.upiiz.orm.Models.ClienteEntity;
import com.upiiz.orm.Repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    //Inyectar una dependencia de ClienteRepository
    @Autowired
    private ClienteRepository clienteRepository;

    //Listar todos los clientes
    public List<ClienteEntity> getAllClientes(){
        return clienteRepository.findAll();
    }

    //Guardar un cliente
    public ClienteEntity saveCliente(ClienteEntity cliente){
        return clienteRepository.save(cliente);
    }

    //Buscar un cliente por id
    public ClienteEntity getClienteById(Long id){
        return clienteRepository.findById(id).orElse(null);
    }

    //Actualizar un cliente por id
    public ClienteEntity updateCliente(ClienteEntity cliente){
        if (clienteRepository.existsById(cliente.getId())){
            return clienteRepository.save(cliente);
        }
        return null;
    }

    //Eliminar un cliente por id
    public void deleteCliente(Long id){
        clienteRepository.deleteById(id);
    }


}
