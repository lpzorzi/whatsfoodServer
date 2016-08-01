/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.whatsfood.testes;

import com.whatsFood.data.Cliente;
import com.whatsFood.data.Post;
import com.whatsfood.DAO.JDBCClienteDAO;
import com.whatsfood.DAO.JDBCComentarioDAO;
import com.whatsfood.DAO.JDBCCurtirDAO;
import com.whatsfood.DAO.JDBCDenunciaDAO;
import com.whatsfood.DAO.JDBCGerenteDAO;
import com.whatsfood.DAO.JDBCPostDAO;
import com.whatsfood.data.Comentario;
import com.whatsfood.data.Curtir;
import com.whatsfood.data.Denuncia;
import com.whatsfood.data.Gerente;
import com.whatsfood.util.ConnectionFactory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author samsung
 */
public class teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* TESTE CLIENTE            -------OK
        Cliente c = new Cliente("Lucas", "0");
        JDBCClienteDAO JDBCc = new JDBCClienteDAO();
        JDBCc.inserir(c);
        List<Cliente> clientes = JDBCc.listar();
        for (Cliente cliente : clientes) {
            System.out.print("Nome: "+cliente.getNome()+", ");
            System.out.println("ID: "+cliente.getID());
        }
        JDBCc.alterar(new Cliente("LucasZ","3"));
        clientes = JDBCc.listar();
        for (Cliente cliente : clientes) {
            System.out.print("Nome: "+cliente.getNome()+", ");
            System.out.println("ID: "+cliente.getID());
        }
        */
        /* TESTE POST
        Post p = new Post("0","1","ALOHA");
        JDBCPostDAO JDBCp = new JDBCPostDAO();
        
        //JDBCp.inserir(p);
        //JDBCp.inserir(p);
        
        System.out.print("BLZ ");
        List<Post> posts = JDBCp.listar();
        for (Post post : posts) {
            System.out.print("ID: "+post.getID());
            System.out.print("Cliente: "+post.getClienteID());
            System.out.print("Comentario "+post.getComentario());
        }
        JDBCp.alterar(new Post("1","1","ALOHA2"));
        JDBCp.remover(2);
        System.out.print("-------------------------------------------");
        p = JDBCp.buscar(1);
        System.out.print("ID: "+p.getID());
        System.out.print("Cliente: "+p.getClienteID());
        System.out.print("Comentario "+p.getComentario());
        System.out.print("-------------------------------------------");
        posts = JDBCp.listar();
        for (Post post : posts) {
            System.out.print("ID: "+post.getID());
            System.out.print("Cliente: "+post.getClienteID());
            System.out.print("Comentario "+post.getComentario());
        }
        */

        // TESTE GERENTE
        Gerente g = new Gerente("0", "loging", "senhag");
        JDBCGerenteDAO JDBCg = new JDBCGerenteDAO();
        //JDBCg.inserir(g);
        g = new Gerente("0", "loging2", "senhag2");
        //JDBCg.inserir(g);
        g = JDBCg.buscar("loging");
        
        
        /* TESTE COMENTARIO         -------OK
        Comentario c = new Comentario("0", "ALOHA", "1", "1");
        JDBCComentarioDAO JDBCc = new JDBCComentarioDAO();
        JDBCc.inserir(c);
        JDBCc.inserir(c);
        List<Comentario> comentarios = JDBCc.listar();
        for (Comentario comentario : comentarios){
            System.out.println("ID: " + comentario.getID());
            System.out.println("Post ID: " + comentario.getPostID());
            System.out.println("Cliente ID: " + comentario.getClienteID());
            System.out.println("Comentario: " + comentario.getComentario());
        }
        c = new Comentario("1", "ALOHA2", "1", "1");
        JDBCc.alterar(c);
        JDBCc.remover(2);
        comentarios = JDBCc.listar();
        System.out.println("----------------------------------------------------");
        for (Comentario comentario : comentarios){
            System.out.println("ID: " + comentario.getID());
            System.out.println("Post ID: " + comentario.getPostID());
            System.out.println("Cliente ID: " + comentario.getClienteID());
            System.out.println("Comentario: " + comentario.getComentario());
        }
        */
        /* TESTE CURTIR              -------------- FALTA LISTAR
        Curtir c = new Curtir("1", "1");
        JDBCCurtirDAO JDBCc = new JDBCCurtirDAO();
        JDBCc.inserir(c);
        c = new Curtir("3", "2");
        JDBCc.inserir(c);
        List<Curtir> curtidas = null ;
        //curtidas = JDBCc.listar(1);
        if(!curtidas.isEmpty()){
            for (Curtir curtir : curtidas){
                System.out.println("Cliente ID: " + curtir.getClienteID());
                System.out.println("Post ID: " + curtir.getPostID());
            }
        }else{
            System.out.println("VAZIO");
        }
        */
        /* TESTAR DENUNCIA
        Denuncia d = new Denuncia("0","1","1");
        JDBCDenunciaDAO JDBCd = new JDBCDenunciaDAO();
        JDBCd.inserir(d);
        List<Denuncia> denuncias = null ;
        denuncias = JDBCd.listar();
        for (Denuncia denuncia : denuncias){
            System.out.println("Cliente ID: " + denuncia.getClienteID());
            System.out.println("Post ID: " + denuncia.getPostID());
        }
        */
    }
    
}
