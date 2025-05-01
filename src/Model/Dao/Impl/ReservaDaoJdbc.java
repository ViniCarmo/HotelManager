package Model.Dao.Impl;

import Model.Dao.ReservaDao;
import Model.Entities.Hospede;
import Model.Entities.Reserva;
import Model.Entities.Room;
import db.DB;
import db.DbException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDaoJdbc implements ReservaDao {

    private Connection conn;
    private HospedeDaoJdbc hospedeDao;
    private RoomDaoJdbc roomDao;

    public ReservaDaoJdbc(Connection conn) {
        this.conn = conn;
        this.hospedeDao = new HospedeDaoJdbc(conn);
        this.roomDao = new RoomDaoJdbc(conn);
    }

    @Override
    public void insert(Reserva obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO reserva (id_hospede, id_quarto, valor_total, noites) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setInt(1, obj.getHospede().getId());
            st.setInt(2, obj.getRoom().getId());
            st.setDouble(3, obj.getTotalValue());
            st.setInt(4, obj.getNights());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    obj.setId(rs.getInt(1));
                }
                DB.closeResultSet(rs);
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Reserva obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE reserva SET id_hospede = ?, id_quarto = ?, valor_total = ?, noites = ? WHERE id = ?");

            st.setInt(1, obj.getHospede().getId());
            st.setInt(2, obj.getRoom().getId());
            st.setDouble(3, obj.getTotalValue());
            st.setInt(4, obj.getNights());
            st.setInt(5, obj.getId());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM reserva WHERE id = ?");
            st.setInt(1, id);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Reserva findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM reserva WHERE id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Hospede hospede = hospedeDao.findById(rs.getInt("id_hospede"));
                Room quarto = roomDao.findById(rs.getInt("id_quarto"));

                Reserva reserva = new Reserva();
                reserva.setId(rs.getInt("id"));
                reserva.setHospede(hospede);
                reserva.setRoom(quarto);
                reserva.setTotalValue(rs.getDouble("valor_total"));
                reserva.setNights(rs.getInt("noites"));

                return reserva;
            }

            return null;

        } catch (SQLException e) {
            throw new DbException(e.getMessage()    );
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    @Override
    public List<Reserva> findAll() {
        List<Reserva> list = new ArrayList<>();
        Statement st = null;
        ResultSet rs = null;

        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM reserva");

            while (rs.next()) {
                Hospede hospede = hospedeDao.findById(rs.getInt("id_hospede"));
                Room quarto = roomDao.findById(rs.getInt("id_quarto"));

                Reserva reserva = new Reserva();
                reserva.setId(rs.getInt("id"));
                reserva.setHospede(hospede);
                reserva.setRoom(quarto);
                reserva.setTotalValue(rs.getDouble("valor_total"));
                reserva.setNights(
                        rs.getInt("noites"));

                list.add(reserva);
            }

            return list;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }
}
