package model.generico;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author leona
 */

public class ResultSetGenerico {

    private final ResultSet result;

    public ResultSetGenerico(ResultSet result) {
        this.result = result;
    }

    public String getString(String nameColumn) throws SQLException {
        return result.getString(nameColumn);
    }

    public Integer getInt(String nameColumn) throws SQLException {
        return result.getInt(nameColumn);
    }

    public Long getLong(String nameColumn) throws SQLException {
        return result.getLong(nameColumn);
    }

    public Date getDate(String nameColumn) throws SQLException {
        return new Date(result.getLong(nameColumn));
    }
    public boolean getBoolean(String nameColumn) throws SQLException {
        return result.getBoolean(nameColumn);
    }
    public double getDouble(String nameColumn)throws SQLException{
        return result.getDouble(nameColumn);
    }


}
