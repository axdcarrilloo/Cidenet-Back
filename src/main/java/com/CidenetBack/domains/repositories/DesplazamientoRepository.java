package com.CidenetBack.domains.repositories;

import com.CidenetBack.domains.entities.Desplazamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesplazamientoRepository extends JpaRepository<Desplazamiento, Long> {

    Desplazamiento findByPlacaCarro(String placa);

}
