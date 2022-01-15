package com.example.applist.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applist.databinding.ItemAppBinding
import com.example.applist.model.AppData
import com.example.applist.model.AppLogo

class AppsListAdapter(private val actionListener: ActionListener) :
    RecyclerView.Adapter<AppsListAdapter.AppListViewHolder>(),
    View.OnClickListener {

     var apps: List<AppData> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemAppBinding.inflate(inflater, parent, false)
        binding.root.setOnClickListener(this)
        return AppListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AppListViewHolder, position: Int) {
        val app = apps[position]
        with(holder.binding) {
            holder.itemView.tag = app
            titleApp.text = app.name

            val logo = AppLogo.logoMap[app.logo]
            iconApp.setImageDrawable(logo)
        }
    }

    override fun getItemCount(): Int = apps.size

    class AppListViewHolder(val binding: ItemAppBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onClick(v: View) {
        val app = v.tag as AppData
        actionListener.onAppDetails(app)
    }
}