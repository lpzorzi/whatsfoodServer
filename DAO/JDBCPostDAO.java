package com.whatsfood.DAO;

import com.whatsFood.data.Post;
import com.whatsfood.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCPostDAO implements PostDAO {
    
    private Connection connection;
    public JDBCPostDAO(){
        connection = ConnectionFactory.getConnectio();
    }

    @Override
    public void inserir(Post post) {
        try{
            String SQL = "INSERT INTO post (post_id, post_cliente_id, post_comentario) VALUES(?,?,?)";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, "0");
            ps.setString(2, post.getClienteID());
            ps.setString(3, post.getComentario());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao inserir post da aplicacao whtasFoodServer", ex); 

        }
    }
    
    @Override
    public void remover(int id) {
        try {
            String SQL = "DELETE FROM post WHERE post_id = ?;";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt( 1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCPostDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao remover post da aplicacao whtasFoodServer", ex); 
        }
    }

    @Override
    public void alterar(Post post) {
        try {
            String SQL = "UPDATE post SET post_comentario = ? WHERE post_id = ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, post.getComentario());
            ps.setString(2, post.getID());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCPostDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao alterar post da aplicacao whtasFoodServer", ex); 
        }
    }
    
    @Override
    public Post buscar(int ID) {
        Post post;
        try {
            String SQL = "SELECT * FROM post WHERE post_id = ?;";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt( 1, ID);
            ResultSet rs = ps.executeQuery();
            post = new Post();
            if(rs.next()){
                post.setID(rs.getString("post_id"));
                post.setClienteID(rs.getString("post_cliente_id"));
                post.setComentario(rs.getString("post_comentario"));
            }else{
                System.out.println("VAZIO");
            }
            ps.close();
            rs.close();
            return post;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCPostDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao buscar post da aplicacao whtasFoodServer", ex); 
        }
    }

    @Override
    public List listar() {
        List<Post> posts = new ArrayList<Post> ();
        try {
            String SQL = "SELECT * FROM post;";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Post post = new Post();
                post.setID(rs.getString("post_id"));
                System.out.print(post.getID());
                post.setClienteID(rs.getString("post_cliente_id"));
                System.out.print(post.getClienteID());
                post.setComentario(rs.getString("post_comentario"));
                System.out.print(post.getComentario());
                posts.add(post);
            }
            
            ps.close();
            rs.close();
            return posts;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCPostDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar post da aplicacao whtasFoodServer", ex); 
        }    
    }
}
