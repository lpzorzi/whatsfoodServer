package com.whatsfood.DAO;

import com.whatsfood.data.Denuncia;
import com.whatsfood.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCDenunciaDAO implements DenunciaDAO {

    private Connection connection;

    public JDBCDenunciaDAO() {
        connection = ConnectionFactory.getConnectio();
    }
    
    @Override
    public void inserir(Denuncia denuncia) {
        try {
            String SQL = "INSERT INTO denuncia (denuncia_id, denuncia_post_id, denuncia_cliente_id) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, "0");
            ps.setString(2, denuncia.getPostID());
            ps.setString(3, denuncia.getClienteID());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCDenunciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void remover(int ID) {
        try {
            String SQL = "DELETE FROM denuncia WHERE denuncia_id = ?;";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt( 1, ID);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao remover denuncia da aplicacao whtasFoodServer", ex);
        }
    }

    @Override
    public List listar() {
        List<Denuncia> denuncias = new ArrayList<Denuncia>();
        try {
            String SQL = "SELECT * FROM comentario";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Denuncia denuncia = new Denuncia();
                denuncia.setClienteID(rs.getString("denuncia_cliente_id"));
                denuncia.setID(rs.getString("denuncia_id"));
                denuncia.setPostID(rs.getString("denuncia_post_id"));
                denuncias.add(denuncia);
            }
            ps.close();
            rs.close();
            return denuncias;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar denuncias da aplicacao whtasFoodServer", ex);
        }
    }
    
}
