package com.whatsfood.DAO;

import com.whatsfood.data.Gerente;
import com.whatsfood.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCGerenteDAO implements GerenteDAO {

    private Connection connection;
    public JDBCGerenteDAO() {
        connection = ConnectionFactory.getConnectio();
    }

    @Override
    public void inserir(Gerente gerente) {
        try {
            String SQL = "INSERT INTO gerente (gerente_id, gerente_login, gerente_senha) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, "0");
            ps.setString(2, gerente.getLogin());
            ps.setString(3, gerente.getSenha());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCGerenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(int id) {
        try {
            String SQL = "DELETE FROM gerente WHERE gerente_id = ?;";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt( 1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao remover gerente da aplicacao whtasFoodServer", ex); 
        }
    }

    @Override
    public void alterar(Gerente gerente) {
        try {
            String SQL = "UPDATE gerente SET gerente_login = ?, gerente_senha = ? WHERE gerente_id = ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, gerente.getLogin());
            ps.setString(2, gerente.getSenha());
            ps.setString(2, gerente.getID());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao alterar gerente da aplicacao whtasFoodServer", ex); 
        }
    }

    @Override
    public Gerente buscar(String login) {
        Gerente gerente;
        try {
            String SQL = "SELECT * FROM gerente WHERE gerente_login = ?;";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString( 1, login);
            ResultSet rs = ps.executeQuery();
            gerente = new Gerente();
            if(rs.next()){
                gerente.setLogin(rs.getString("gerente_login"));
                gerente.setSenha(rs.getString("gerente_senha"));
                gerente.setID(rs.getString("gerente_id"));
            }else{
                System.out.println("VAZIO");
            }
            ps.close();
            rs.close();
            return gerente;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao buscar ciente da aplicacao whtasFoodServer", ex); 
        }
    }
    
    @Override
    public ArrayList listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
