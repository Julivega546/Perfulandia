package com.perfulandia.perfulandia.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ventas")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Date fechaVenta;

    @Column(nullable = false, length = 15)
    private String runCliente;

    @Column(nullable = false, length = 100)
    private String nombreCliente;

    @Column(nullable = false)
    private Integer total;

}
