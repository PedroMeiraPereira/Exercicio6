package br.com.cotemig.exercicio6.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.cotemig.exercicio6.R
import br.com.cotemig.exercicio6.model.ListaProduto
import br.com.cotemig.exercicio6.model.Produto
import br.com.cotemig.exercicio6.services.RetrofitInitializer
import br.com.cotemig.exercicio6.ui.adapters.ProdutosAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getProdutos()

    }

    fun getProdutos(){

        var s = RetrofitInitializer().serviceProduto()

        var call = s.getListaProduto()

        call.enqueue(object: Callback<ListaProduto> {

            override fun onResponse(call: Call<ListaProduto>, response: Response<ListaProduto>) {
                    if(response.code() == 200){
                        response.body()?.let{
                            showList(it.lista)
                        }
                    }
            }

            override fun onFailure(call: Call<ListaProduto>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Erro", Toast.LENGTH_LONG).show()
            }
        })

    }

    fun showList(produtos : List<Produto>){

        listaProdutos.adapter = ProdutosAdapter(this, produtos)

    }

}