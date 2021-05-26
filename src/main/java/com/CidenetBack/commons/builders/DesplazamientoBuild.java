package com.CidenetBack.commons.builders;

import com.CidenetBack.commons.dtos.DesplazamientoRegistroDto;
import com.CidenetBack.domains.entities.Desplazamiento;

public class DesplazamientoBuild {

    public static Desplazamiento convertirDtoADomain(DesplazamientoRegistroDto desplazamientoDto){
        return Desplazamiento.builder().placaCarro(desplazamientoDto.getPlacaCarro()).origen(desplazamientoDto.getOrigen()).
                destino(desplazamientoDto.getDestino()).fechaOrigen(desplazamientoDto.getFechaOrigen()).
                fechaDestino(desplazamientoDto.getFechaDestino()).build();
    }

}
