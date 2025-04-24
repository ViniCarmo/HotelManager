package Model.Dao;

import Model.Dao.Impl.HospedeDaoJdbc;
import db.DB;

public class DaoFactory {
    public static HospedeDao createHospedeDao(){
        return new HospedeDaoJdbc(DB.getConnection());
    }
}
