/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Aluguel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MONIQUE BENTO
 */
public class AluguelDAO extends ExecuteSQL {

    public AluguelDAO(Connection con) {
        super(con);
    }
  
      public String Inserir_Aluguel(Aluguel a) {
        String sql = "insert into aluguel values (0,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setInt(1,a.getCod());
            ps.setInt(2,a.getCoddvd());
            ps.setInt(3,a.getCodcliente ());
            ps.setString(4,a.getData_aluguel());
            ps.setString(5,a.getHorario());
            ps.setString(6,a.getData_devolucao());
           
            
            if (ps.executeUpdate() > 0) {
                return "Inserido com  sucesso.";
            } else {
                return "Erro ao inserir";
            }
       } catch (SQLException e) {
           return e.getMessage ();
       }
   
    }
    
    public List<Aluguel> Listaraluguel() {
        String sql = "select idaluguel,iddvd,idcliente,hora_aluguel,data_aluguel,data_devolucao from aluguel";
        List<Aluguel> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
            Aluguel a = new Aluguel();
            a.setCod(rs.getInt(1));
            a.setCoddvd(rs.getInt(2));
            a.setCodcliente(rs.getInt(3));
            a.setData_aluguel(rs.getString(4));
            a.setHorario(rs.getString(5));
            a.setData_devolucao(rs.getString(6));
            
            lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
       } catch (SQLException e) {
           return null; 
       }
   
    }
    
    

public List<Aluguel> ListarComboAluguel(){
        
        String sql = "select idaluguel from aluguel order by idaluguel";
        List<Aluguel> lista = new ArrayList<>();
        
        try {
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
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

    public List<Aluguel> ConsultaNomeAluguel(int cod){
        
        String sql = "select nome from Aluguel where idcliente = "+ cod +" order by nome";
        List<Aluguel> lista = new ArrayList<>();
        
        try {
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
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
    
    public List<Aluguel> ConsultaCodigoAluguel(int cod) {
        String sql = "select idaluguel from aluguel where idaluguel = '"+ cod +"'";
        List<Aluguel> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    
    }
        public String Excluir_Aluguel(Aluguel a){
        String sql = "delete from aluguel where idaluguel = ? ";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCod());
            
            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso";
            } else {
                return "Erro ao excluir";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
        
        public List<Aluguel> Pesquisar_Nome_Aluguel(String nome) {
            String sql = "select idaluguel,iddvd , idcliente, hora_aluguel, data_aluguel, data_devolucao "
                    + "from aluguel where nome Like '%" + nome + "%'";
            List<Aluguel> lista = new ArrayList();
             try {
                PreparedStatement ps = getCon().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                
                if (rs != null) {
                    while (rs.next()) {
                        Aluguel a = new Aluguel();
                        a.setCod(rs.getInt(1));
                        a.setCoddvd(rs.getInt(2));
                        a.setCodcliente(rs.getInt(3));
                        a.setData_aluguel(rs.getString(4));
                        a.setHorario(rs.getString(5));
                        a.setData_devolucao(rs.getString(6));
                       
                        lista.add(a);
                    }
                    return lista;
                 } else {
                    return null;
                }
            } catch (SQLException e) {
                return null;
            }
            
         
        }
        
        
       public List<Aluguel> Pesquisar_Cod_Aluguel(int cod) {
            String sql = "select idaluguel, iddvd , idcliente, hora_aluguel,data_aluguel , data_devolucao "
                    + "from Cliente where idcliente = '" + cod + "'";
            List<Aluguel> lista = new ArrayList();
             try {
                PreparedStatement ps = getCon().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                
                if (rs != null) {
                    while (rs.next()) {
                        Aluguel a = new Aluguel();
                        a.setCod(rs.getInt(1));
                        a.setCoddvd(rs.getInt(2));
                        a.setCodcliente(rs.getInt(3));
                        a.setData_aluguel(rs.getString(4));
                        a.setHorario(rs.getString(5));
                        a.setData_devolucao(rs.getString(6));
                       
                        lista.add(a);
                    }
                    return lista;
                 } else {
                    return null;
                }
            } catch (SQLException e) {
                return null;
            }
        
            
        }

                
        public boolean Testar_Aluguel(int cod) {
            boolean Resultado = false;
            try {
                
                String sql = "select * from aluguel where idaluguel = " + cod + "";
                PreparedStatement ps = getCon().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                
                if (rs != null) {
                    while (rs.next()) {
                        Resultado = true;
                    }
                }
            } catch (SQLException ex) {
                ex.getMessage();
            }
            return Resultado;
      }
        
        public List<Aluguel> CapturarAluguel(int cod) {
            String sql = "select * from idaluguel where idaluguel =" + cod + " ";
            List<Aluguel> lista = new ArrayList<>();
            try {
                PreparedStatement ps = getCon().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        Aluguel a = new Aluguel();
                        a.setCod(rs.getInt(1));
                        a.setCoddvd(rs.getInt(2));
                        a.setCodcliente(rs.getInt(3));
                        a.setCoddvd(rs.getInt(4));
                        a.setData_aluguel(rs.getString(5));
                        a.setHorario(rs.getString(5));
                        a.setData_devolucao(rs.getString(5));


                        
                        lista.add(a);
                    }
                    return lista;
                 } else {
                    return null;
                }
            } catch (SQLException e) {
                return null;
            }
        }

public String Alterar_Aluguel(Aluguel a) {
    String sql = "update aluguel set iddvd = ? ,idcliente = ? ,hora_aluguel = ? "
            + ",data_aluguel = ? ,data_devolucao = ?  ";
    try {
        PreparedStatement ps = getCon() .prepareStatement(sql);
        ps.setInt(1, a.getCod());
        ps.setInt(2, a.getCoddvd());
        ps.setInt(3, a.getCodcliente());
        ps.setString(4, a.getData_aluguel());
        ps.setString(5, a.getHorario());
        ps.setString(6, a.getData_devolucao());

        if (ps.executeUpdate() > 0) {
            return "Atualizado com sucesso.";
        } else {
            return "Erro ao Atualizar";
        }
    } catch (SQLException e) {
        return e.getMessage();
    }
}

}
    

