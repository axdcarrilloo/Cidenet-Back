package com.CidenetBack.api;

import com.CidenetBack.commons.dtos.CarroRegistroDto;
import com.CidenetBack.commons.utils.Route;
import com.CidenetBack.domains.entities.Carro;
import com.CidenetBack.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = Route.BASE + Route.CARRO, produces = MediaType.APPLICATION_JSON_VALUE)
public class CarroController {

    @Autowired
    private CarroService carroService;

    @DeleteMapping(value = Route.ELIMINAR)
    public ResponseEntity<Long> eliminarCarro(@PathVariable Long id){
        return new ResponseEntity<Long>(carroService.eliminarCarro(id), HttpStatus.OK);
    }

    @PutMapping(value = Route.MODIFICAR)
    public ResponseEntity<Integer> modificarCarro(@RequestBody Carro carro){
        return new ResponseEntity<Integer>(carroService.modificarCarro(carro), HttpStatus.OK);
    }

    @GetMapping(value = Route.CONSULTAR)
    public ResponseEntity<List<Carro>> consultarTodosCarros(){
        return new ResponseEntity<List<Carro>>(carroService.consultarTodosCarros(), HttpStatus.OK);
    }

    @PostMapping(value = Route.REGISTRAR)
    public ResponseEntity<Long> registrarCarro(@RequestBody CarroRegistroDto carroRegistroDto){
        return new ResponseEntity<Long>(carroService.registrarCarro(carroRegistroDto), HttpStatus.OK);
    }

}
