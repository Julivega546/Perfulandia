package com.perfulandia.perfulandia.repository;

import com.perfulandia.perfulandia.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long>  {
}
