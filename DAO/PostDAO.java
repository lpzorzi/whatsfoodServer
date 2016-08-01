package com.whatsfood.DAO;

import com.whatsFood.data.Post;
import java.util.List;

public interface PostDAO {
    public void inserir (Post post);
    public void remover(int id);
    public void alterar (Post post);
    public Post buscar (int ID);
    public List listar();
}
