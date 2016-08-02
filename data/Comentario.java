package com.whatsfood.data;

public class Comentario {
    private String ID;
    private String comentario;
    private String clienteID;
    private String postID;

    public Comentario(String ID, String comentario, String clienteID, String postID) {
        this.ID = ID;
        this.comentario = comentario;
        this.clienteID = clienteID;
        this.postID = postID;
    }

    public Comentario() {    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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
