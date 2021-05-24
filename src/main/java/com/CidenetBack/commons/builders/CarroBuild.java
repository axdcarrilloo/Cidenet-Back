package com.CidenetBack.commons.builders;

import com.CidenetBack.commons.dtos.CarroRegistroDto;
import com.CidenetBack.domains.entities.Carro;

public class CarroBuild {

    public static Carro convertirDtoADomain(CarroRegistroDto carroR){
        return Carro.builder().placa(carroR.getPlaca()).marca(carroR.getMarca()).conductor(carroR.getConductor()).build();
    }

}
