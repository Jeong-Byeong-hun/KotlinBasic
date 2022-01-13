package com.example.kotlinstopwatch

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinstopwatch.adapter.LabTimeAdapter
import com.example.kotlinstopwatch.vo.LabTimeVO
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import java.util.*


class MainActivity : AppCompatActivity() {

    private var time = 0
    private var timerTask: Timer? = null
    private var isRunning = false

    private lateinit var tv_min: TextView
    private lateinit var tv_sec: TextView
    private lateinit var tv_millisec: TextView
    private lateinit var fabLab: ExtendedFloatingActionButton
    private lateinit var fabStart: ExtendedFloatingActionButton
    private lateinit var rvLabTime: RecyclerView
    private lateinit var labTimeAdapter: LabTimeAdapter
    private var labTimeList: MutableList<LabTimeVO> = mutableListOf<LabTimeVO>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onBind()
        initAdapter()
    }

    private fun onBind() {
        tv_min = findViewById(R.id.tv_min)
        tv_sec = findViewById(R.id.tv_sec)
        tv_millisec = findViewById(R.id.tv_millisec)
        rvLabTime = findViewById(R.id.rvLabTime)
        fabLab = findViewById(R.id.fabLab)
        fabLab.setOnClickListener {
            if (isRunning) {
                val labTime =
                    tv_min.text.toString() + ":" + tv_sec.text.toString() + ":" + tv_millisec.text.toString()
                val labTimeVO: LabTimeVO = LabTimeVO(labTimeList.size + 1, labTime)

                labTimeList.add(0, labTimeVO)
//            Log.d("TAG", "onBind: " + labTimeVO.toString())

                labTimeAdapter.setLabTimeList(labTimeList)
            } else {
                time = 0
                tv_min.text = String.format("%02d", 0)
                tv_sec.text = String.format("%02d", 0)
                tv_millisec.text = String.format("%02d", 0)

                labTimeList.clear()
                labTimeAdapter.setLabTimeList(labTimeList)

            }
        }
        fabStart = findViewById(R.id.fabStart)
        fabStart.setOnClickListener {
            isRunning = !isRunning
            if (isRunning) {
                fabLab.isEnabled = true
                start()
                fabLab.text = "랩"
            } else {
                pause()
                fabLab.text = "재설정"
            }
        }
    }

    private fun initAdapter() {
        labTimeAdapter = LabTimeAdapter()
        rvLabTime.adapter = labTimeAdapter
    }

    private fun pause() {
        fabStart.text = "시작"
        timerTask?.cancel()
    }

    private fun start() {
        fabStart.text = "정지"

        timerTask = kotlin.concurrent.timer(period = 10) {
            time++
            var sectime = 0
            val min = time / 6000
            sectime = time % 6000
            val sec = sectime / 100
            val milli = time % 100
            runOnUiThread {
                tv_min.text = String.format("%02d", min)
                tv_sec.text = String.format("%02d", sec)
                tv_millisec.text = String.format("%02d", milli)

            }
        }

    }
}