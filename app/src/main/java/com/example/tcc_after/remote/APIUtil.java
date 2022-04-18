package com.example.tcc_after.remote;

public class APIUtil {

    private static final String API_URL = "http://10.107.144.12:4000/";

    public static RouterInterface getUsuarioInterface(){
        //indicamos onde roda nossa aplicacao, e indica a rota
        return RetroFit.getClient(API_URL).create(RouterInterface.class);
    }

}
