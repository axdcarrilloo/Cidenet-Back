package com.CidenetBack.domains.repositories;

import com.CidenetBack.commons.utils.ConstanstSQL;
import com.CidenetBack.domains.entities.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

    @Transactional
    @Query(value = ConstanstSQL.CONSULTAR_PLACAMARCA, nativeQuery = true)
    List<Carro> getByPlacaOrMarca(@Param("contrains") String contrains);

    @Modifying
    @Transactional
    @Query(value = ConstanstSQL.MODIFICAR_CARRO, nativeQuery = true)
    Integer uploadCarro(@Param("placa")String placa, @Param("marca")String marca,
                     @Param("id_conductor")Long id_conductor, @Param("id")Long id);

    Carro findByPlaca(String placa);

}
