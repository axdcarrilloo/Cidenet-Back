package com.CidenetBack.domains.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "desplazamientos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Desplazamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "placa_carro", length = 7, nullable = false)
    private String placaCarro;

    @Column(nullable = false)
    private String origen;

    @Column(nullable = false)
    private String destino;

    @Column(name = "fecha_origen", nullable = false)
    private LocalDate fechaOrigen;

    @Column(name = "fecha_destino", nullable = false)
    private LocalDate fechaDestino;

}
