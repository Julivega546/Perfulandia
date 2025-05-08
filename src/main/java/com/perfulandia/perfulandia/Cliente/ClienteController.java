package com.perfulandia.perfulandia.Cliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteController {
@Column(unique = true,length = 13 , nullable = false)
    private String run ;

}
