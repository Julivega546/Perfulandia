package com.perfulandia.perfulandia.repository;
import com.perfulandia.perfulandia.model.Inventario;
import com.perfulandia.perfulandia.model.Provedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProvedoresRepository extends JpaRepository<Provedores, Long>{
}
