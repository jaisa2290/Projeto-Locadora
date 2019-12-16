
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Modelo.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DVDDAO extends ExecuteSQL {
    
    public DVDDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_DVD(DVD a) {
        
        try {
            String sql = "insert into dvd values(0,?,?,?,?,?)";
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setInt(1, a.getCod_filme());
            ps.setDouble(2, a.getPreco());
            ps.setString(3, a.getData_compra());
            ps.setString(4, a.getSituacao());
            
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso!";
            } else {
                return "Erro ao inserir";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
    public String Excluir_DVD(DVD a){
        String sql = "delete from dvd where idfilme = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCod_filme());
            
            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso";
            } else {
                return "Erro ao excluir";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
    public boolean Testar_DVD(int cod) {
        boolean teste = false;
        try {
            
            String sql = "select iddvd from dvd where iddvd =" + cod + "";
           PreparedStatement ps = getCon().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             
             if (rs != null) {
                 while (rs.next()) {
                     teste = true;
                 }
             }
             
        } catch (SQLException ex) {
        }
        return teste;
    }
    
    public boolean Testar_Situacao(int cod) {
        boolean teste = false;
                try {
                    
                    String sql = "select iddvd from dvd where iddvd =" + cod + ""
                            + " and situacao = 'Disponivel'";
                    PreparedStatement ps = getCon().prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    
                    if (rs != null) {
                        while (rs.next()) {
                            teste = true;
                        }
                    }
                    
                } catch (SQLException ex) {
                }
                return teste;
    }

    public List<DVD> ListarCodFilme(int cod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<DVD> CapturarDVD(int cod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
