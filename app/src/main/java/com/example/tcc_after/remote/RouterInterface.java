package com.example.tcc_after.remote;

import com.example.tcc_after.model.UsuarioComum;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RouterInterface {
    /**ROTA DE INSERCAO DE USUARIO**/
    //Pegar o verbo http e colocar o caminho
    @POST("perfil/cadastrarPerfilUsuarioComumEndereco/")
    //realiza uma requisicao para a rota acima pelo metodo addUsuario
    Call<UsuarioComum> addUsuarioComum(@Body UsuarioComum usuarioComum);


}
