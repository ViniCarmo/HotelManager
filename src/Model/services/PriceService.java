package Model.services;

import Model.Entities.Reserva;

public class PriceService {

    Reserva reserva;

    public static double total(double pricePerNight , int nights){
        return pricePerNight  * nights;
    }

}
