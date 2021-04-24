package br.com.cotemig.exercicio6.services

import br.com.cotemig.exercicio6.model.ListaProduto
import retrofit2.Call
import retrofit2.http.GET

interface ServiceProduto {

    @GET("produto")
    fun getListaProduto() : Call<ListaProduto>

}