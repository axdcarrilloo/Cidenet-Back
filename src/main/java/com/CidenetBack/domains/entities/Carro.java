package com.CidenetBack.domains.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "carros")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 7, nullable = false, unique = true)
    private String placa;

    @Column(nullable = false)
    private String marca;

    @ManyToOne
    @JoinColumn(name = "id_conductor" , referencedColumnName = "id", nullable = false)
    private Conductor conductor;

}
