package com.arquitecturajava.servidorfront.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Factura {
    private int numero;
    private String concepto;
    private double importe;
}
