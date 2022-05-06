package com.example.tcc_after.remote;

public class APIUtil {
//10.107.144.26
    //192.168.15.24
    private static final String API_URL = "http://10.107.144.15:4000/";

    public static RouterInterface getApiInterface(){
        //indicamos onde roda nossa aplicacao, e indica a rota
        return RetroFit.getClient(API_URL).create(RouterInterface.class);
    }

}
