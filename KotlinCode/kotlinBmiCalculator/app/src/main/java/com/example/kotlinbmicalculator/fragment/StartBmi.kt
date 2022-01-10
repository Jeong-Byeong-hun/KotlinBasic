package com.example.kotlinbmicalculator.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.kotlinbmicalculator.R

class StartBmi : Fragment() {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.start_bmi, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        val et_height = view.findViewById<EditText>(R.id.et_height)
        val et_weight = view.findViewById<EditText>(R.id.et_weight)
        val bt_next = view.findViewById<Button>(R.id.bt_next)

        bt_next.setOnClickListener(View.OnClickListener {
            if (et_height.text.isEmpty()) {
                Toast.makeText(context, "키를 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }

            if (et_weight.text.isEmpty()) {
                Toast.makeText(context, "몸무게를 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }

            val height = et_height.let { et_height.text.trim() }.toString().toInt()
            val weight = et_weight.let { et_weight.text.trim() }.toString().toInt()

            val bundle = bundleOf("height" to height, "weight" to weight)

            Log.d("TAG", "onViewCreated: " + height)
            Log.d("TAG", "onViewCreated: " + weight)
            // 결과창으로 보내기
            navController.navigate(R.id.action_startBmi_to_resultBmi, bundle)
        })

    }

}