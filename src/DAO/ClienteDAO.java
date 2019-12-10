
package DAO;
import java.util.ArrayList;
import java.util.List;
import Modelo.Cliente;
import java.sql.*;

/**
 *
 * @author MONIQUE BENTO
 */
public class ClienteDAO extends ExecuteSQL{

    public ClienteDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Cliente(Cliente a) {
        String sql = "insert into cliente values (0,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1,a.getNome());
            ps.setString(2,a.getNascimento());
            ps.setString(3,a.getRG ());
            ps.setString(4,a.getCPF());
            ps.setString(5,a.getEmail());
            ps.setString(6,a.getTelefone());
            ps.setString(7,a.getBairro());
            ps.setString(8,a.getRua());
            ps.setInt (9, a.getNumero());
            ps.setString(10,a.getCEP());
            
            
            if (ps.executeUpdate() > 0) {
                return "Inserido com  sucesso.";
            } else {
                return "Erro ao inserir";
            }
       } catch (SQLException e) {
           return e.getMessage ();
       }
   
    }

public List<Cliente> ListarComboCliente(){
        
        String sql = "select nome from cliente order by nome";
        List<Cliente> lista = new ArrayList<>();
        
        try {
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Cliente a = new Cliente();
                    a.setNome(rs.getString(1));
                    lista.add(a);
                    
                }
                
                return lista;
                
            } else {
                
                return null;
                
            }
            
        } catch (Exception e) {
        
            return null;
        
        }
        
    }

    public List<Cliente> ConsultaNomeCliente(int cod){
        
        String sql = "select nome from cliente where idcliente = "+ cod +" order by nome";
        List<Cliente> lista = new ArrayList<>();
        
        try {
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Cliente a = new Cliente();
                    a.setNome(rs.getString(1));
                    lista.add(a);
                    
                }
                
                return lista;
                
            } else {
                
                return null;
                
            }
            
        } catch (Exception e) {
        
            return null;
        
        }
        
    }
    
    public List<Cliente> ConsultaCodigoCliente(String nome) {
        String sql = "select idcliente from cliente where nome = '"+ nome +"'";
        List<Cliente> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Cliente a = new Cliente();
                    a.setCodigo(rs.getInt(1));
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public String Excluir_Cliente(Cliente a){
        String sql = "delete from cliente where idcliente = ? and nome = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCodigo());
            ps.setString(2, a.getNome());
            
            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso";
            } else {
                return "Erro ao excluir";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }



}