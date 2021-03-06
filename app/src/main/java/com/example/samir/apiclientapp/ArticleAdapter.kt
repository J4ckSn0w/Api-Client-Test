package com.example.samir.apiclientapp
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.card_layout.view.*

class ArticleAdapter(
        private val articleList: ArrayList<Article>,
        private val listener: (Article) -> Unit
    ): RecyclerView.Adapter<ArticleAdapter.ArticleHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ArticleHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false))

    override fun onBindViewHolder(holder: ArticleHolder, position: Int) = holder.bind(articleList[position], listener)

    override fun getItemCount() = articleList.size

    class ArticleHolder(articleView: View): RecyclerView.ViewHolder(articleView) {

        fun bind(article: Article, listener: (Article) -> Unit) = with(itemView) {
            title.text = article.title
            address.text = article.body
            setOnClickListener { listener(article)
                val intent = Intent(context, MainActivity::class.java).apply {
                    putExtra("opcion",2)
                    putExtra("post",article.id)
                }
                context.startActivity(intent)
            }
        }
    }
}
