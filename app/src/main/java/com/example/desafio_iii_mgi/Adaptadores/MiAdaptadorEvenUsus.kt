package com.example.desafio_iii_mgi.Adaptadores

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio_iii_mgi.Events.Evento
import com.example.desafio_iii_mgi.Events.EventoActivity
import com.example.desafio_iii_mgi.R

class MiAdaptadorEvenUsus : RecyclerView.Adapter<MiAdaptadorEvenUsus.ViewHolder>(){

    var evento: ArrayList<Evento> = ArrayList()
    var correo: String? = null
    lateinit var context: Context

    fun MiAdaptadorEvenUsus(evento: ArrayList<Evento>, context: Context, correo: String?) {
        this.evento = evento
        this.context = context
        this.correo = correo
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = evento.get(position)
        holder.bind(item, context, this, correo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.list_event_usu,parent, false)
        )
    }



    override fun getItemCount(): Int {
        return evento.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombreEV = view.findViewById(R.id.txtEventoList) as TextView
        val pillUsu = view.findViewById(R.id.swtEventoUsu) as Switch



        fun bind(evento: Evento, context: Context, adapter: MiAdaptadorEvenUsus, correo: String?) {

            nombreEV.text = evento.nombre

            if (evento.listEve.size != 0){
                for (i in 0..evento.listEve.size){
                    var idVar: String? = evento.listEve.elementAtOrNull(i)

                    if(correo == idVar){
                        pillUsu.isChecked = true
                    }



                }
            }

            itemView.setOnClickListener(View.OnClickListener {

                val intent = Intent(context, EventoActivity::class.java)
                intent.putExtra("id", evento.idEvento.toString())
                itemView.context.startActivity(intent)



            })

        }

    }
}