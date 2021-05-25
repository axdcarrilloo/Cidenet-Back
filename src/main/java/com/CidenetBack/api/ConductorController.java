package com.CidenetBack.api;

import com.CidenetBack.commons.utils.Route;
import com.CidenetBack.domains.entities.Conductor;
import com.CidenetBack.services.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = Route.BASE + Route.CONDUCTOR, produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "${cors.front.url}" , methods = {RequestMethod.GET})
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    @GetMapping(value = Route.CONSULTAR)
    public ResponseEntity<List<Conductor>> consultarConductores(){
        return new ResponseEntity<List<Conductor>>(conductorService.consultarConductores(), HttpStatus.OK);
    }

}
