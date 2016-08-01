package com.whatsfood.data;

public class Gerente {
    private String ID;
    private String login;
    private String senha;

    public Gerente(String ID, String login, String senha) {
        this.ID = ID;
        this.login = login;
        this.senha = senha;
    }

    public Gerente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
