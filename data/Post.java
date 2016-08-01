package com.whatsFood.data;

public class Post {
    private String ID = new String();
    private String clienteID = new String();
    private String comentario = new String();
    
    public Post (String ID, String clienteID, String comentario){
        this.ID = ID;
        this.clienteID = clienteID;
        this.comentario = comentario;
    }

    public String getClienteID() {
        return clienteID;
    }

    public void setClienteID(String clienteID) {
        this.clienteID = clienteID;
    }

       public Post() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
}
