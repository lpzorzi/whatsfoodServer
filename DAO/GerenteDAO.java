package com.whatsfood.DAO;

import com.whatsfood.data.Gerente;
import java.util.ArrayList;
import java.util.List;

public interface GerenteDAO {
    public void inserir (Gerente gerente);
    public void remover(int id);
    public void alterar (Gerente gerente);
    public Gerente buscar(String login);
    public List listar();
}
