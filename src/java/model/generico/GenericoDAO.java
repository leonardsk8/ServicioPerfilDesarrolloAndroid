package model.generico;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Conexion;
/**
 *
 * @author leonardo
 */
public abstract class GenericoDAO {

    
    public Connection accessDb;
    public PreparedStatement ps;
    public ResultSet result;
    

    public GenericoDAO(Conexion db) {
        this.accessDb = db.getConexion();
    }

    public <T extends Object> List<T> consultar(String sql,
                                                String[] args,
                                                IConsultaGenerica<T> generico) throws SQLException {
        if (args == null) {
            args = new String[]{};
        }
        ps=accessDb.prepareStatement(sql, args);
        result = ps.executeQuery();
        if (!result.next()) {
            return new ArrayList<>();
        }
        System.out.println(ps.toString());
        List<T> lista = new ArrayList<>();
        ResultSetGenerico resultGenerico = new ResultSetGenerico(result);
        do {
            lista.add(generico.consulta(resultGenerico));
        } while (result.next());
        return lista;
    }
    public String insertar(String sql,Object obj,IConsultaGenerica generico) throws SQLException {
        ps=accessDb.prepareStatement(sql);
        ps = generico.registro(ps, obj);
        return ps.executeUpdate()+"";
    }
    public String deleteEvery(String sql) throws SQLException{
        ps=accessDb.prepareStatement(sql);        
        return ps.executeUpdate()+"";
    }


}
