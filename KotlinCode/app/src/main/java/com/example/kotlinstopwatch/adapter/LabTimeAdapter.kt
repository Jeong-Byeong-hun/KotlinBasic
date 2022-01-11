package com.example.kotlinstopwatch.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinstopwatch.R
import com.example.kotlinstopwatch.vo.LabTimeVO

class LabTimeAdapter : RecyclerView.Adapter<LabTimeAdapter.LabTimeViewHolder>() {

    private var labTimeList: MutableList<LabTimeVO> = mutableListOf<LabTimeVO>()

    fun setLabTimeList(labTimeVO: MutableList<LabTimeVO>) {
        labTimeList = labTimeVO
        notifyDataSetChanged()
        Log.d("TAG", "setLabTimeList: " + labTimeList.toString())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LabTimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_labtime, parent, false)
        return LabTimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: LabTimeViewHolder, position: Int) {
        holder.bind(labTimeList[position])
    }

    override fun getItemCount(): Int {
        return labTimeList.size
    }

    inner class LabTimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tv_lab: TextView = itemView.findViewById(R.id.tv_lab)
        private val tv_time: TextView = itemView.findViewById(R.id.tv_time)

        fun bind(labTimeVO: LabTimeVO) {
            tv_lab.text = "랩 " + labTimeVO.labCount
            tv_time.text = labTimeVO.time
        }
    }

}