package com.perfulandia.perfulandia;


import com.perfulandia.perfulandia.model.*;
import com.perfulandia.perfulandia.repository.*;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;

@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private InventarioRepository inventarioRepository;
    @Autowired
    private ProveedoresRepository proveedoresRepository;
    @Autowired
    private VentasRepository ventasRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        Random random = new Random();


        for (int i = 0; i < 5; i++) {
            Proveedores proveedor = new Proveedores();
            proveedor.setNombre(faker.company().name());
            proveedor.setCorreo(faker.internet().emailAddress());
            proveedoresRepository.save(proveedor);
        }


        for (int i = 0; i < 20; i++) {
            Producto producto = new Producto();
            producto.setNombre(faker.commerce().productName());
            producto.setDescripcion(faker.lorem().sentence());
            producto.setPrecio((int) faker.number().randomDouble(2, 1000, 10000));
            productoRepository.save(producto);
        }


        for (Producto producto : productoRepository.findAll()) {
            Inventario inventario = new Inventario();
            inventario.setProducto(producto);
            inventario.setCantidad(faker.number().numberBetween(10, 100));
            inventarioRepository.save(inventario);
        }


        for (int i = 0; i < 10; i++) {
            Cliente cliente = new Cliente();
            cliente.setNombre(faker.name().fullName());
            cliente.setCorreo(faker.internet().emailAddress());
            clienteRepository.save(cliente);
        }


        for (int i = 0; i < 15; i++) {
            Ventas venta = new Ventas();
            venta.setNombreCliente(clienteRepository.findAll().get(random.nextInt(10)));
            venta.setTotal(faker.number().numberBetween(1, 5));
            venta.setFechaVenta(new Date());

            ventasRepository.save(venta);
        }
    }
}
