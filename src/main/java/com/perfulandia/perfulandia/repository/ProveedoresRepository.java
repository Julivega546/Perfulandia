package com.perfulandia.perfulandia.repository;
import com.perfulandia.perfulandia.model.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProveedoresRepository extends JpaRepository<Proveedores, Long>{
}
