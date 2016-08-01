package com.whatsfood.DAO;

import com.whatsfood.data.Curtir;
import com.whatsfood.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCCurtirDAO implements CurtirDAO {

    private Connection connection;
    public JDBCCurtirDAO() {
        connection = ConnectionFactory.getConnectio();
    }
    
    @Override
    public void inserir(Curtir curtir) {
        try {
            String SQL = "INSERT INTO curtir (curtir_cliente_id, curtir_post_id) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, curtir.getClienteID());
            ps.setString(2, curtir.getPostID());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCCurtirDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(int ID) {
        try {
            String SQL = "DELETE FROM curtir WHERE curtir_post_id = ?;";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt( 1, ID);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao remover curtir da aplicacao whtasFoodServer", ex);
        }
    }

    @Override
    public List listar(int ID) {
        List<Curtir> curtidas = new ArrayList<Curtir>();
        try {
            String SQL = "SELECT * FROM comentario WHERE comentario_post_id = ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Curtir c = new Curtir();
                c.setClienteID(rs.getString("comentario_cliente_id"));
                c.setPostID(rs.getString("comentario_post_id"));
                curtidas.add(c);
            }
            ps.close();
            rs.close();
            return curtidas;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar comentario da aplicacao whtasFoodServer", ex);
        }
    }
}
