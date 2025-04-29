package Model.Dao;

import Model.Entities.Hospede;
import Model.Entities.Room;

import java.util.List;

public interface RoomDao {
    void updateStatus(Room obj);

    Room findById(Integer id);

    List<Room> findAll();

}
