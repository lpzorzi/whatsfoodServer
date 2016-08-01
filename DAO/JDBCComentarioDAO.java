package com.whatsfood.DAO;

import com.whatsfood.data.Comentario;
import com.whatsfood.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCComentarioDAO implements ComentarioDAO {

    private Connection connection;

    public JDBCComentarioDAO() {
        connection = ConnectionFactory.getConnectio();
    }
    
    @Override
    public void inserir(Comentario comentario) {
        try {
            String SQL = "INSERT INTO comentario (comentario_id, comentario_coment, comentario_post_id, comentario_cliente_id) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, "0");
            ps.setString(2, comentario.getComentario());
            ps.setString(3, comentario.getPostID());
            ps.setString(4, comentario.getClienteID());
            System.out.println(SQL);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao inserir comentario da aplicacao whtasFoodServer", ex);
        }
        
    }

    @Override
    public void remover(int ID) {
        try {
            String SQL = "DELETE FROM comentario WHERE comentario_id = ?;";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt( 1, ID);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao remover comentario da aplicacao whtasFoodServer", ex);
        }
    }

    @Override
    public void alterar(Comentario comentario) {
        try {
            String SQL = "UPDATE comentario SET comentario_coment = ? WHERE comentario_id = ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, comentario.getComentario());
            ps.setString(2, comentario.getID());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao alterar comentario da aplicacao whtasFoodServer", ex);
        }
    }

    @Override
    public List listar() {
        List<Comentario> comentarios = new ArrayList<Comentario>();
        try {
            String SQL = "SELECT * FROM comentario";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Comentario c = new Comentario();
                c.setClienteID(rs.getString("comentario_cliente_id"));
                c.setID(rs.getString("comentario_id"));
                c.setPostID(rs.getString("comentario_post_id"));
                c.setComentario(rs.getString("comentario_coment"));
                comentarios.add(c);
            }
            ps.close();
            rs.close();
            return comentarios;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar comentario da aplicacao whtasFoodServer", ex);
        }
    }
}
