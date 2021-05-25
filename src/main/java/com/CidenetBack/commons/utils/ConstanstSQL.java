package com.CidenetBack.commons.utils;

public class ConstanstSQL {

    public static final String CONSULTAR_PLACAMARCA = "SELECT * FROM `carros` WHERE placa LIKE :contrains% OR marca LIKE :contrains%";
    public static final String MODIFICAR_CARRO = "UPDATE `carros` SET placa = :placa, marca = :marca, id_conductor = :id_conductor WHERE id = :id";

}
