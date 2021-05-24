package com.CidenetBack.services;

import com.CidenetBack.commons.builders.CarroBuild;
import com.CidenetBack.commons.dtos.CarroRegistroDto;
import com.CidenetBack.commons.utils.Constantes;
import com.CidenetBack.domains.entities.Carro;
import com.CidenetBack.domains.repositories.CarroRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private ConductorService conductorService;

    public Long eliminarCarro(Long id){
        Long resultado = Constantes.PROCESO_EXITOSO;
        carroRepository.deleteById(id);
        return resultado;
    }

    public Integer modificarCarro(Carro carro){
        Integer resultado = Integer.parseInt(Constantes.NO_EXISTE_OBJETO+"");
        if (Objects.nonNull(conductorService.consultarPorId(carro.getConductor().getId()))) {
            log.info("CarroService.Java - modificarCarro() -> Modificando carro");
            resultado = carroRepository.uploadCarro(carro.getPlaca(), carro.getMarca(), carro.getConductor().getId(), carro.getId());
        }
        return resultado;
    }

    public List<Carro> consultarTodosCarros(){
        log.info("CarroService.Java - consultarTodosCarros() -> Consultando los carros");
        return carroRepository.findAll();
    }

    public Carro consultarPorPlaca(String placa){
        log.info("CarroService.Java - consultarPorPlaca() -> Consultando carro por placa");
        return carroRepository.findByPlaca(placa);
    }

    public Long registrarCarro(CarroRegistroDto carroRegistroDto){
        Long resultado = 0L;
        if(Objects.isNull(consultarPorPlaca(carroRegistroDto.getPlaca()))){
            if(Objects.nonNull(conductorService.consultarPorId(carroRegistroDto.getConductor().getId()))){
                log.info("CarroService.Java - registrarCarro() -> Registrando carro");
                resultado = carroRepository.save(CarroBuild.convertirDtoADomain(carroRegistroDto)).getId();
            }else {
                log.info("CarroService.Java - registrarCarro() -> No existe el conductor");
                resultado = Constantes.NO_EXISTE_OBJETO;
            }
        }else{
            log.info("CarroService.Java - registrarCarro() -> Carro ya existente");
            resultado = Constantes.OBJETO_EXISTENTE;
        }
        return resultado;
    }

}
