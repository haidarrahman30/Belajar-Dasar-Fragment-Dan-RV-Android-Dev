package com.example.androidbasic.belajarfragment.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.androidbasic.R
import com.example.androidbasic.belajarfragment.belajarrv.RvActivity


class FragmentSatu : Fragment() {

    lateinit var btn_satu: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_satu = view.findViewById(R.id.btn_satu) as Button


        val fragmentDua = FragmentDua()

        btn_satu.setOnClickListener {

            val bundle = Bundle()
            bundle.putString(FragmentDua.EXTRA_NAME, "Muhammad Khaidar Rahman")

            val desc = "Orang Ini Sedang Belajar Fundamental Android"

            fragmentDua.arguments = bundle
            fragmentDua.desc = desc


            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.utama, fragmentDua, FragmentDua::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_satu, container, false)
    }




}