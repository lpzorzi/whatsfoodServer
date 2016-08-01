package com.whatsfood.data;

public class Curtir {
    private String clienteID;
    private String postID;

    public Curtir(String clienteID, String postID) {
        this.clienteID = clienteID;
        this.postID = postID;
    }

    public Curtir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getClienteID() {
        return clienteID;
    }

    public void setClienteID(String clienteID) {
        this.clienteID = clienteID;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }
    
    
}
