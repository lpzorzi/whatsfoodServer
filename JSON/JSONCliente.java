package com.whatsfood.JSON;

import com.whatsFood.data.Cliente;
import com.whatsfood.DAO.JDBCClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

@WebServlet(urlPatterns = {"/JSONCliente"})
public class JSONCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String data = "1";
        data = request.getParameter("data");
        System.out.println("Fui chamado");
        JDBCClienteDAO JDBCc = new JDBCClienteDAO();
        List<Cliente> clientes = null;
        Gson gson = new Gson();
        Cliente c;
        if(data.equals("1")){           //Para Inserir
            String nome = request.getParameter("nome");
            c = new Cliente(nome , "0");
            JDBCc.inserir(c);
        }else if(data.equals("2")){     //Para buscar
            String ID = request.getParameter("ID");
            c = JDBCc.buscar(Integer.parseInt(ID));
            clientes.add(c);
            String json = gson.toJson(clientes);
            out.print(json);
        }else if(data.equals("3")){     //Para Listar
            clientes = JDBCc.listar();
            String json = gson.toJson(clientes);
            out.print(json);
        }else if(data.equals("4")){     //Para Alterar
            c = new Cliente();
            c.setID(request.getParameter("ID"));
            c.setNome(request.getParameter("nome"));
            JDBCc.alterar(c);
        }else if(data.equals("5")){     //Para Excluir
            String ID = request.getParameter("ID");
            JDBCc.remover(Integer.parseInt(ID));
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
