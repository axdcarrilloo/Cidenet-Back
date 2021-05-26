package com.CidenetBack.services;

import com.CidenetBack.commons.builders.DesplazamientoBuild;
import com.CidenetBack.commons.dtos.DesplazamientoRegistroDto;
import com.CidenetBack.commons.utils.Constantes;
import com.CidenetBack.domains.entities.Carro;
import com.CidenetBack.domains.entities.Desplazamiento;
import com.CidenetBack.domains.repositories.DesplazamientoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class DesplazamientoService {

    @Autowired
    private DesplazamientoRepository desplazamientoRepository;

    @Autowired
    private CarroService carroService;

    public Desplazamiento consultarPorPlaca(String placa){
        return desplazamientoRepository.findByPlacaCarro(placa);
    }

    public Long eliminar(Long id){
        Long resultado = Constantes.PROCESO_EXITOSO;
        desplazamientoRepository.deleteById(id);
        return resultado;
    }

    public List<Desplazamiento> consultarTodos(){
        return desplazamientoRepository.findAll();
    }

    public Long registrar(DesplazamientoRegistroDto desplazamientoDto){
        Long resultado = Constantes.PROCESO_EXITOSO;
        if(Objects.nonNull(carroService.consultarPorPlaca(desplazamientoDto.getPlacaCarro()))){
            log.info("DesplazamientoService.Java - registrar() -> Registrndo desplazamiento..!");
            resultado = desplazamientoRepository.save(DesplazamientoBuild.convertirDtoADomain(desplazamientoDto)).getId();
        }else {
            resultado = Constantes.NO_EXISTE_OBJETO;
            log.info("DesplazamientoService.Java - registrar() -> El carro con estas placas no existe");
        }
        return resultado;
    }

}
