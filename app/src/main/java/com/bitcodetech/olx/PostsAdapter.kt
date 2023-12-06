package com.bitcodetech.olx

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class PostsAdapter(
    private var posts: ArrayList<Posts>,

):RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {

    interface OnPostClickListener{
        fun onPostClick(position: Int,post: Posts,view: View)
    }

    var onPostClickListener :OnPostClickListener?=null



  inner  class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {



       var selectedImage: ImageView
       var price: TextView
       var city:TextView
       var description:TextView
       //val postView:View


        init {

            selectedImage = view.findViewById(R.id.postedPhoto)
            city = view.findViewById(R.id.city)
            price = view.findViewById(R.id.price)
            description = view.findViewById(R.id.description)


            itemView.setOnClickListener{
                if(onPostClickListener!= null) {
                    onPostClickListener?.onPostClick(
                        adapterPosition,
                        posts[adapterPosition],
                        it
                    )
                }



                Toast.makeText(
                    it.context,
                    "${posts[adapterPosition].city}",
                    Toast.LENGTH_SHORT
                ).show()


            }
        }

    }


    override fun getItemCount()=posts.size



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        val view =layoutInflater.inflate(R.layout.posts_view,null)
        return PostViewHolder(view)
    }
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        holder.city.text=posts[position].city
        posts[position].selectedImage?.let { holder.selectedImage.setImageResource(it) }
        holder.price.text=posts[position].price
        holder.description.text=posts[position].description
    }
}