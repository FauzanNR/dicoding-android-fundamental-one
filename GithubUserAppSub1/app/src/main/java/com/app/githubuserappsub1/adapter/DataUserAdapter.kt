package com.app.githubuserappsub1.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.githubuserappsub1.R
import com.app.githubuserappsub1.activity.DetailUserActivity
import com.app.githubuserappsub1.data.GithubUser
import com.app.githubuserappsub1.databinding.ItemLayoutBinding


class DataUserAdapter : RecyclerView.Adapter<DataUserAdapter.DataAdapterViewHolder>() {


    private val mData = ArrayList<GithubUser>()

    companion object {
        val EXTRA_DATA = "EXTRA_DATA"
    }

    fun setDataAdapter(data: ArrayList<GithubUser>) {
        mData.clear()
        mData.addAll(data)
        notifyDataSetChanged()
    }

    inner class DataAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemLayoutBinding.bind(itemView)

        fun bind(githubUser: GithubUser) {
            with(itemView) {
                val source =
                    resources.getIdentifier(githubUser.avatar, null, this.context.packageName)
                binding.imgAvatar.setImageResource(source)
                binding.tvNama.text = githubUser.name
                binding.tvUsername.text = githubUser.username
                binding.idCompanyItem.text = githubUser.company
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataUserAdapter.DataAdapterViewHolder = DataAdapterViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
    )

    override fun onBindViewHolder(holder: DataUserAdapter.DataAdapterViewHolder, position: Int) {
        holder.bind(mData[position])
        val data = mData[position]
        holder.binding.idItemLayout.setOnClickListener {
            holder.itemView.context.startActivity(
                Intent(holder.itemView.context, DetailUserActivity::class.java)
                    .putExtra(EXTRA_DATA, data)
            )
        }
    }

    override fun getItemCount(): Int = mData.size

}