package br.com.livraria.dao;

import br.com.livraria.factory.ConnectionFactory;
import br.com.livraria.model.Editora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Italo
 */
public class EditoraDao {
    private Object connection;
    public void salvar(Editora ed)
            throws ClassNotFoundException, SQLException{
        String sql = "INSERT INTO editora"
                 + "(razao_social) VALUES(?)";
        
        Connection connection = ConnectionFactory.getConnection();
          
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, ed.getRazaoSocial());
        stmt.execute();
        stmt.close();            
    }
    
    public void excluir(Editora ed) throws ClassNotFoundException, SQLException{
        String sql = "DELETE FROM editora WHERE id = ?";
        
        Connection connection = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, ed.getId());
        stmt.execute();
        stmt.close();        
    }
    public void editar(Editora ed) throws ClassNotFoundException, SQLException{
        String sql = "UPDATE editora SET razao_social = ? WHERE id = ?";
        
        Connection connection = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, ed.getRazaoSocial());
        stmt.setInt(2, ed.getId());
        stmt.execute();
        stmt.close();         
    }
    
    public Editora pesquisar(Editora editora) throws ClassNotFoundException{
        String sql = "select * from editora where id = ?";        
        Connection connection = ConnectionFactory.getConnection();
        try{
            Editora ed = null;
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, editora.getId());
            stmt.execute();
            
            ResultSet rs = stmt.executeQuery();//armazenamento dos resultados obtidos no objeto rs
            ed = new Editora();
                while(rs.next()){
                    ed.setRazaoSocial(rs.getString("razao_social"));
                }
        rs.close();
        stmt.close();
        return ed;//retornando a lista preechidas com os dados do DB
        
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        
    }
    
    public ArrayList<Editora> listar() throws ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM editora";
        
        Connection connection = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<Editora> lista = new ArrayList<Editora>();
        
        while(rs.next()){
            Editora e = new Editora();
            e.setId(rs.getInt("id"));
            e.setRazaoSocial(rs.getString("razao_social"));
            lista.add(e);
        }
        return lista;
    }
    
//    public void pesquisar(Editora ed) throws ClassNotFoundException{
//        String sql = "select * from editora WHERE id = ?";
//        
//        Connection connection = ConnectionFactory.getConnection();
//        try {
//            PreparedStatement stmt = connection.prepareStatement(sql);
//            // seta os valores
//            stmt.setInt(1, ed.getId());            
//            // execute
//            stmt.execute();
//            stmt.close();
//        }catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        
//    }
}
