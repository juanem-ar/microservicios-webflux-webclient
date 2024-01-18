package com.arquitecturajava.servidorfront.controller;

import com.arquitecturajava.servidorfront.entity.Factura;
import com.arquitecturajava.servidorfront.service.ClienteFacturaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class FacturaClienteController {

    ClienteFacturaService servicio;
    /* PETICIONES BLOQUEANTES
    @GetMapping("/lista")
    public String lista(Model modelo) {
        List<Factura> lista = servicio.buscarTodas();
        modelo.addAttribute("factura", lista);
        return "lista/ver_productos";
    }
    */
    // PETICIONES NO BLOQUEANTES
    @GetMapping("/lista")
    public String lista(Model modelo) {
        List<Factura> lista=servicio.buscarTodasConFlux().collectList().block();
        modelo.addAttribute("lista", lista);
        return "lista";
    }
    @GetMapping("/facturas")
    public Flux<Factura> buscarTodasConFluxController() {
        Flux<Factura> lista= Flux.just(
                new Factura(1,"ordenador",200),
                new Factura(2,"tablet",300)
                ).delaySequence(Duration.ofSeconds(3));
        return lista;
    }
}
