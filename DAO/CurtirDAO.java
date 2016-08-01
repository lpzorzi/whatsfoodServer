package com.whatsfood.DAO;

import com.whatsfood.data.Curtir;
import java.util.List;

public interface CurtirDAO {
    public void inserir(Curtir curtir);
    public void remover(int ID);
    public List listar(int ID);
}
