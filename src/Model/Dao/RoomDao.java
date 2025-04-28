package Model.Dao;

import Model.Entities.Room;

import java.util.List;

public interface RoomDao {
    void updateStatus(Room obj);

    List<Room> findAll();

}
