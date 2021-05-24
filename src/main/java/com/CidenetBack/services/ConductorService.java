package com.CidenetBack.services;

import com.CidenetBack.domains.entities.Conductor;
import com.CidenetBack.domains.repositories.ConductorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Slf4j
public class ConductorService {

    @Autowired
    private ConductorRepository conductorRepository;

    public Conductor consultarPorId(Long id){
        Conductor conductor = null;
        try {
            conductor = conductorRepository.findById(id).get();
        }catch (NoSuchElementException ex){
            log.info("ConductorService.Java - consultarPorId() -> No se encontro el conductor");
        }catch (Exception e){
            e.printStackTrace();
        }
        return conductor;
    }

}
