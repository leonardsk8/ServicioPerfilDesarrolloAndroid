package model.generico;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by leonardo on 10/07/2018.
 */

public interface IConsultaGenerica<T> {

    T consulta(ResultSetGenerico cursor);
    PreparedStatement registro(PreparedStatement ps,T obj) throws SQLException;
    
}
