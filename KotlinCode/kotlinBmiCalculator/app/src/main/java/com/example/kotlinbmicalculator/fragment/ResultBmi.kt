package com.example.kotlinbmicalculator.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.kotlinbmicalculator.R

class ResultBmi : Fragment() {
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.reslut_bmi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        val tv_result = view.findViewById<TextView>(R.id.tv_result)
        val btn_back = view.findViewById<Button>(R.id.btn_back)
        val height = arguments?.getInt("height", 0)
        val weight = arguments?.getInt("weight", 0)
        Log.d("TAG", "onViewCreated: " + height)
        Log.d("TAG", "onViewCreated: " + weight)

        val pow_height : Double = Math.pow(height!! / 100.0, 2.0)
        val bmi = weight!! / pow_height

        when{
            bmi >= 35 -> tv_result.text = "고도 비만"
            bmi >= 30 -> tv_result.text = "2단계 비만"
            bmi >= 25 -> tv_result.text = "1단계 비만"
            bmi >= 23 -> tv_result.text = "과체중"
            bmi >= 18.5 -> tv_result.text = "정상"
            else -> tv_result.text = "저체중"
        }

        btn_back.setOnClickListener(View.OnClickListener {
            navController.navigate(R.id.action_resultBmi_to_startBmi)
        })

    }
}