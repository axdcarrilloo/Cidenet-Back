package com.CidenetBack.commons.dtos;

import com.CidenetBack.domains.entities.Conductor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class CarroRegistroDto implements Serializable {

    private String placa;
    private String marca;
    private Conductor conductor;

}
