package com.perfulandia.perfulandia.repository;

import com.perfulandia.perfulandia.model.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentasRepository extends JpaRepository <Ventas, Long>  {
}
