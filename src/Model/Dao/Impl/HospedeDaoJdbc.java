package Model.Dao.Impl;

import Model.Dao.HospedeDao;
import Model.Entities.Hospede;
import Model.Entities.Room;

import java.sql.Connection;
import java.util.List;

public class HospedeDaoJdbc implements HospedeDao {
    private Connection conn;

    public HospedeDaoJdbc(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Hospede obj) {

    }

    @Override
    public void update(Hospede obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Hospede findById(Integer id) {
        return null;
    }

    @Override
    public List<Hospede> findAll() {
        return null;
    }

    @Override
    public List<Hospede> FindByRoom(Room room) {
        return null;
    }
}
