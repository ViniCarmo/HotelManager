package Model.Dao;

import Model.Entities.Hospede;
import Model.Entities.Reserva;

import java.util.List;

public interface ReservaDao {
    void insert(Reserva obj);

    void update(Reserva obj);

    void deleteById(Integer id);

    Reserva findById(Integer id);

    List<Reserva> findAll();

}
