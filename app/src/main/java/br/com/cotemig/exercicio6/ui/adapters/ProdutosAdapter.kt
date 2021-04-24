package br.com.cotemig.exercicio6.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.cotemig.exercicio6.R
import br.com.cotemig.exercicio6.model.Produto
import com.bumptech.glide.Glide


class ProdutosAdapter(var context: Context, var produtos: List<Produto>):BaseAdapter() {

    override fun getCount(): Int {
        return produtos.size
    }

    override fun getItem(p0: Int): Any {
        return ""
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view = LayoutInflater.from(context).inflate(R.layout.item_produto, null)

        var nome = view.findViewById<TextView>(R.id.nome)
        nome.text = produtos[p0].nome

        var avatar = view.findViewById<ImageView>(R.id.avatar)
        Glide.with(context).load(produtos[p0].imagem).into(avatar)

        var preco = view.findViewById<TextView>(R.id.preco)
        preco.text = produtos[p0].valor.toString()

        return view

    }
}