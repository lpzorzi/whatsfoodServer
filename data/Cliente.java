package com.whatsFood.data;

public class Cliente {
    private String nome;
    private String ID;
    
    public Cliente(String nome, String ID){
        this.nome = nome;
        this.ID = ID;
    }

    public Cliente() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
}
