package com.whatsfood.DAO;

import com.whatsfood.data.Comentario;
import java.util.ArrayList;
import java.util.List;

public interface ComentarioDAO {
    public void inserir(Comentario comentario);
    public void remover(int ID);
    public void alterar (Comentario comentario);
    public List listar();
}

