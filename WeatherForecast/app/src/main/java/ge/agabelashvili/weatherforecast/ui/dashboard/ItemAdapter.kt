package ge.ezarkua.listsdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ge.agabelashvili.weatherforecast.R
import ge.agabelashvili.weatherforecast.ui.dashboard.ListItem

class ItemAdapter(var list: ArrayList<ListItem>) : RecyclerView.Adapter<ItemViewHolder>() {

    var contactClickListener: ContactItemClickListener? = null

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var item = list[position]
       /* holder.contactName.text = item.name
        holder.contactNameFirstLetter.text = item.name[0].toString()*/
        holder.itemView.setOnClickListener {
            //Toast.makeText(holder.itemView.context, item.phoneNumber, Toast.LENGTH_SHORT).show()
            //list.removeAt(position)
            //notifyDataSetChanged()
            contactClickListener?.onContactClicked(item)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(view)
    }
}

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    /*var contactName = itemView.findViewById<TextView>(R.id.txt_contact_name)
    var contactNameFirstLetter = itemView.findViewById<TextView>(R.id.txt_first_letter)*/
}

interface ContactItemClickListener {
    fun onContactClicked(item: ListItem)
}