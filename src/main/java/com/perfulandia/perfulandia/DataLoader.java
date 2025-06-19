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
        Faker faker = new Faker(new Random());
        Random random = new Random();

        // Crear proveedores
        for (int i = 0; i < 5; i++) {
            Proveedores proveedor = new Proveedores();
            proveedor.setRun(faker.idNumber().valid());
            proveedor.setNombre(faker.company().name());
            proveedor.setCorreo(faker.internet().emailAddress());
            proveedor.setDireccion(faker.address().fullAddress());
            proveedor.setNumero(faker.phoneNumber().cellPhone());
            proveedoresRepository.save(proveedor);
        }

        // Crear productos
        for (int i = 0; i < 15; i++) {
            Producto producto = new Producto();
            producto.setNombre(faker.commerce().productName());
            producto.setDescripcion(faker.lorem().sentence());
            producto.setPrecio(faker.number().numberBetween(1000, 10000));
            producto.setStock(faker.number().numberBetween(10, 100));
            productoRepository.save(producto);
        }

        // Crear inventario
        for (Producto producto : productoRepository.findAll()) {
            Inventario inventario = new Inventario();
            inventario.setProducto(producto);
            inventario.setCantidad(faker.number().numberBetween(10, 50));
            inventario.setTipoMovimiento("Ingreso");
            inventario.setFechaMovimiento(new Date());
            inventarioRepository.save(inventario);
        }

        // Crear clientes
        for (int i = 0; i < 10; i++) {
            Cliente cliente = new Cliente();
            cliente.setRun(faker.idNumber().valid());
            cliente.setNombre(faker.name().firstName());
            cliente.setApellido(faker.name().lastName());
            cliente.setCorreo(faker.internet().emailAddress());
            clienteRepository.save(cliente);
        }

        // Crear ventas
        for (int i = 0; i < 20; i++) {
            Cliente cliente = clienteRepository.findAll().get(random.nextInt((int) clienteRepository.count()));
            Producto producto = productoRepository.findAll().get(random.nextInt((int) productoRepository.count()));
            int cantidad = faker.number().numberBetween(1, 5);

            Ventas venta = new Ventas();
            venta.setFechaVenta(new Date());
            venta.setRunCliente(cliente.getRun());
            venta.setNombreCliente(cliente.getNombre() + " " + cliente.getApellido());
            venta.setCantidad(cantidad);
            venta.setTotal(producto.getPrecio() * cantidad);
            ventasRepository.save(venta);
        }
    }
}
