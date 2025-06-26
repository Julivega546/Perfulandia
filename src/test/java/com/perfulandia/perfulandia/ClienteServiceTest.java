/*package com.perfulandia.perfulandia;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

import com.perfulandia.perfulandia.Service.ClienteService;
import com.perfulandia.perfulandia.model.Cliente;
import com.perfulandia.perfulandia.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;


@SpringBootTest
public class ClienteServiceTest {

    @Autowired
    private ClienteService clienteService;

    @MockBean
    private ClienteRepository clienteRepository;

    @Test
    public void testFindAll() {

        when(clienteRepository.findAll()).thenReturn(List.of(new Cliente()));


        List<Cliente> clientes = clienteService.findAll();

        // Verifica que la lista devuelta no sea nula y contenga exactamente una Carrera.
        assertNotNull(clientes);
        assertEquals(1, clientes.size());
    }

    @Test
    public void testFindByCodigo() {
        String codigo = "1";
        Cliente cliente = new Cliente();


        when(clienteRepository.findById(id)).thenReturn(Optional.of(cliente));


        Cliente found = clienteService.findById(id);


        assertNotNull(found);
        assertEquals(id, found.getId());
    }

    @Test
    public void testSave() {
        Cliente cliente = new Cliente();


        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente saved = clienteService.save(cliente);


        assertNotNull(saved);
        assertEquals("", saved.getNombre());
    }

    @Test
    public void testDeleteById() {
        String codigo = "1";


        doNothing().when(clienteRepository).deleteById(id);


        clienteService.deleteById(id);


        verify(clienteRepository, times(1)).deleteById(codigo);
    }

}

 */
