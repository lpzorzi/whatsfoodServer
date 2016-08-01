package com.whatsfood.DAO;

import com.whatsfood.data.Denuncia;
import java.util.ArrayList;
import java.util.List;

public interface DenunciaDAO {
    public void inserir(Denuncia denuncia);
    public void remover(int ID);
    public List listar();
}
