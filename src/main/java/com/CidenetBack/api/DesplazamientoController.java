package com.CidenetBack.api;

import com.CidenetBack.commons.dtos.DesplazamientoRegistroDto;
import com.CidenetBack.commons.utils.Route;
import com.CidenetBack.domains.entities.Desplazamiento;
import com.CidenetBack.services.DesplazamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = Route.BASE + Route.DESPLAZAMIENTO, produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "${cors.front.url}" , methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class DesplazamientoController {

    @Autowired
    private DesplazamientoService desplazamientoService;

    @GetMapping(value = Route.CONSULTAR_PLACA)
    public ResponseEntity<Desplazamiento> consultarPorPlaca(@PathVariable String placa){
        return new ResponseEntity<Desplazamiento>(desplazamientoService.consultarPorPlaca(placa), HttpStatus.OK);
    }

    @DeleteMapping(value = Route.ELIMINAR)
    public ResponseEntity<Long> eliminar(@PathVariable Long id){
        return new ResponseEntity<Long>(desplazamientoService.eliminar(id), HttpStatus.OK);
    }

    @GetMapping(value = Route.CONSULTAR)
    public ResponseEntity<List<Desplazamiento>> consultarTodos(){
        return new ResponseEntity<List<Desplazamiento>>(desplazamientoService.consultarTodos(), HttpStatus.OK);
    }

    @PostMapping(value = Route.REGISTRAR)
    public ResponseEntity<Long> registrar(@RequestBody DesplazamientoRegistroDto desplazamientoDto){
        return new ResponseEntity<Long>(desplazamientoService.registrar(desplazamientoDto), HttpStatus.OK);
    }

}
