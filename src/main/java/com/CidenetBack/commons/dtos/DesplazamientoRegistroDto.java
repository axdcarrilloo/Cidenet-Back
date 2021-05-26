package com.CidenetBack.commons.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class DesplazamientoRegistroDto {

    private String placaCarro;
    private String origen;
    private String destino;
    private LocalDate fechaOrigen;
    private LocalDate fechaDestino;

}
