package com.beit_and_pear.oldpeoplesinging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyListAdapter(private val data: List<ListItem>) :
    RecyclerView.Adapter<MyViewHolder>() {
    // ビューホルダー生成
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }
    // ビューにデータを割り当て、ページを生成
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtTitle.text = data[position].title
        holder.imgPhoto.setImageDrawable(data[position].photo)
        holder.imgPhoto.contentDescription = data[position].title
    }
    // データの項目数を取得
    override fun getItemCount(): Int {
        return data.size
    }

}