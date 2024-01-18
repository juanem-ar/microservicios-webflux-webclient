package com.arquitecturajava.servidor.controller;

import com.arquitecturajava.servidor.entity.Factura;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FacturasController {
    @GetMapping("/facturas")
    public List<Factura> buscarTodas() {
        List<Factura> lista= new ArrayList<Factura>();
        lista.add(new Factura(1,"ordenador",200));
        lista.add(new Factura(2,"tablet",300));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        return lista;


    }
}
