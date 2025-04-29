package Model.Dao;

import Model.Dao.Impl.HospedeDaoJdbc;
import Model.Dao.Impl.RoomDaoJdbc;
import db.DB;

public class DaoFactory {
    public static HospedeDao createHospedeDao(){
        return new HospedeDaoJdbc(DB.getConnection());
    }

    public static RoomDao createRoomDao(){
        return new RoomDaoJdbc(DB.getConnection());
    }
}
