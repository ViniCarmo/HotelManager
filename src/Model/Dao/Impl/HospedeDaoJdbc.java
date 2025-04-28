package Model.Dao.Impl;

import Model.Dao.HospedeDao;
import Model.Entities.Hospede;
import Model.Entities.Room;
import db.DB;
import db.DbException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospedeDaoJdbc implements HospedeDao {
    private Connection conn;

    public HospedeDaoJdbc(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Hospede obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO hospede (nome, cpf, telefone) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            st.setString(1, obj.getName());
            st.setString(2, obj.getCPF());
            st.setString(3, obj.getPhone());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                rs.close();
            } else {
                throw new DbException("Erro inesperado! Nenhuma linha foi afetada.");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Hospede obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE hospede " +
                    "SET nome = ?, cpf = ?, telefone = ? " +
                    "WHERE id=?");

            st.setString(1, obj.getName());
            st.setString(2, obj.getCPF());
            st.setString(3, obj.getPhone());
            st.setInt(4, obj.getId());

            st.executeUpdate();

        } catch (Exception e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM hospede " +
                    "WHERE id = ?");

            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Hospede findById(Integer id) {
        return null;
    }

    @Override
    public List<Hospede> findAll() {
        List<Hospede> list = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM hospede");
            rs = st.executeQuery();

            while (rs.next()) {
                Hospede hospede = new Hospede();
                hospede.setId(rs.getInt("id"));
                hospede.setName(rs.getString("nome"));
                hospede.setCPF(rs.getString("cpf"));
                hospede.setPhone(rs.getString("telefone"));

                list.add(hospede);
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
        return list;
    }
}
