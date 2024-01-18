package com.arquitecturajava.servidorfront.service;

import com.arquitecturajava.servidorfront.entity.Factura;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@Service
public class ClienteFacturaService {
    public List<Factura> buscarTodas() {
        RestTemplate plantilla = new RestTemplate();
        Factura[] facturas = plantilla.getForObject("http://localhost:8080/facturas", Factura[].class);
        List<Factura> lista = Arrays.asList(facturas);
        return lista;
    }
    public Flux<Factura> buscarTodasConFlux() {
        WebClient cliente = WebClient.create("http://localhost:8081/facturas");
        Flux<Factura> facturas=cliente.get().retrieve().bodyToFlux(Factura.class);
        Flux<Factura> facturas2=cliente.get().retrieve().bodyToFlux(Factura.class);
        Flux<Factura> facturas3=cliente.get().retrieve().bodyToFlux(Factura.class);
        Flux<Factura> todas=Flux.merge(facturas,facturas2,facturas3);
        System.out.println(todas);
        return todas;

    }
}
