package com.whatsfood.data;

public class Denuncia {
    private String ID;
    private String ClienteID;
    private String PostID;

    public Denuncia(String ID, String ClienteID, String PostID) {
        this.ID = ID;
        this.ClienteID = ClienteID;
        this.PostID = PostID;
    }

    public Denuncia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getClienteID() {
        return ClienteID;
    }

    public void setClienteID(String ClienteID) {
        this.ClienteID = ClienteID;
    }

    public String getPostID() {
        return PostID;
    }

    public void setPostID(String PostID) {
        this.PostID = PostID;
    }
    
    
    
}
