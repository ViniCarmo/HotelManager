package Model.Dao;

import Model.Entities.Room;

import java.util.List;

public interface RoomDao {
    void update(Room obj);

    List<Room> findAll();

}
