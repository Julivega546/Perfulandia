package com.perfulandia.perfulandia;
import com.perfulandia.perfulandia.model.Cliente;
import com.perfulandia.perfulandia.model.Inventario;
import com.perfulandia.perfulandia.model.Producto;
import com.perfulandia.perfulandia.model.Ventas;
import com.perfulandia.perfulandia.repository.*;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private InventarioRepository inventarioRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ProveedoresRepository proveedoresRepository;
    @Autowired
    private VentasRepository ventasRepository;


    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        Random random = new Random();


    }
}