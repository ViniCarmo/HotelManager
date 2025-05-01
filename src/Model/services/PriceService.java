package Model.services;

import Model.Entities.Reserva;

public class PriceService {

    Reserva reserva;

    public double total(double pricePerNignht, int nights){
        return pricePerNignht * nights;
    }

}
