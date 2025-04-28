package Model.Dao;

import Model.Entities.Hospede;
import Model.Entities.Room;

import java.util.List;

public interface HospedeDao {
    void insert(Hospede obj);

    void update(Hospede obj);

    void deleteById(Integer id);

    Hospede findById(Integer id);

    List<Hospede> findAll();

}
