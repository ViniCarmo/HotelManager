package Model.Dao.Impl;

import Model.Dao.RoomDao;
import Model.Entities.Hospede;
import Model.Entities.Room;
import Model.Entities.RoomStatus;
import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDaoJdbc implements RoomDao {
    private Connection conn;

    public RoomDaoJdbc(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void updateStatus(Room obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("UPDATE quarto " +
                    "SET status = ? " +
                    "WHERE id = ?");

            st.setString(1, obj.getStatus().toString());
            st.setInt(2, obj.getId());
            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            {
                DB.closeStatement(st);
            }
        }
    }

    @Override
    public Room findById(Integer id) {
        return null;
    }

    @Override
    public List<Room> findAll() {
            List<Room> list = new ArrayList<>();

            try (PreparedStatement st = conn.prepareStatement("SELECT * FROM quarto");
                 ResultSet rs = st.executeQuery()) {

                while (rs.next()) {
                    Room room = new Room();
                    room.setId(rs.getInt("id"));
                    room.setRoomNumber(rs.getInt("numero"));
                    room.setPricePerNight(rs.getDouble("preco_por_noite"));
                    room.setStatus(RoomStatus.valueOf(rs.getString("status").toUpperCase()));

                    list.add(room);
                }

            } catch (SQLException e) {
                throw new RuntimeException("Erro ao buscar quartos: " + e.getMessage(), e);
            }

            return list;
        }

    }
