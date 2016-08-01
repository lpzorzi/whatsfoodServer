package com.whatsfood.DAO;

import com.whatsFood.data.Cliente;
import com.whatsfood.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCClienteDAO implements ClienteDAO{

    private Connection connection;
    public JDBCClienteDAO() {
        connection = ConnectionFactory.getConnectio();
    }
    
    @Override
    public void inserir(Cliente cliente) {
        try {
            String SQL = "INSERT INTO cliente (cliente_id, cliente_nome) VALUES (?,?) ";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, "0");
            ps.setString(2, cliente.getNome());
            System.out.println("Novo Cliene: "+SQL);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao inserir ciente da aplicacao whtasFoodServer", ex); 
        }
        
    }

    @Override
    public void remover(int ID) {
        try {
            String SQL = "DELETE FROM cliente WHERE cliente_id = ?;";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt( 1, ID);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao remover ciente da aplicacao whtasFoodServer", ex); 
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        try {
            String SQL = "UPDATE cliente SET cliente_nome = ? WHERE cliente_id = ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getID());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao alterar ciente da aplicacao whtasFoodServer", ex); 
        }
    }
    
    @Override
    public Cliente buscar(int ID) {
        Cliente cliente;
        try {
            String SQL = "SELECT * FROM cliente WHERE cliente_id = ?;";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt( 1, ID);
            ResultSet rs = ps.executeQuery();
            cliente = new Cliente();
            if(rs.next()){
                cliente.setNome(rs.getString("cliente_nome"));
                cliente.setID(rs.getString("cliente_id"));
            }else{
                System.out.println("VAZIO");
            }
            ps.close();
            rs.close();
            return cliente;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao buscar ciente da aplicacao whtasFoodServer", ex); 
        }
    }

    @Override
    public List listar() {
        List<Cliente> clientes = new ArrayList<Cliente> ();
        try {
            String SQL = "SELECT * FROM cliente";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("cliente_nome"));
                cliente.setID(rs.getString("cliente_id"));
                clientes.add(cliente);
            }
            ps.close();
            rs.close();
            return clientes;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar ciente da aplicacao whtasFoodServer", ex); 
        }
    }   
}
