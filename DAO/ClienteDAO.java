package com.whatsfood.DAO;

import com.whatsFood.data.Cliente;
import java.util.List;

public interface ClienteDAO {
    public void inserir(Cliente cliente);
    public void remover(int ID);
    public void alterar (Cliente cliente);
    public Cliente buscar (int ID);
    public List listar();
}
