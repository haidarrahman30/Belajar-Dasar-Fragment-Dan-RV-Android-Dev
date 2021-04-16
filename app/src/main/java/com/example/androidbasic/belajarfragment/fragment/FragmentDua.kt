package com.example.androidbasic.belajarfragment.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.androidbasic.R



class FragmentDua : Fragment() {

    lateinit var btn_dua: Button
    lateinit var tv_name: TextView
    lateinit var tv_desc: TextView

    var desc: String? = null

    companion object{
        val EXTRA_NAME = "extra_name"
        val EXTRA_DESC = "extra_desc"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_dua = view.findViewById(R.id.btn_dua) as Button
        tv_name = view.findViewById(R.id.tv_name) as TextView
        tv_desc = view.findViewById(R.id.tv_desc) as TextView

        val fragmentSatu = FragmentSatu()

        btn_dua.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.utama, fragmentSatu, FragmentSatu::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if(savedInstanceState != null){
            val description = savedInstanceState.getString(EXTRA_DESC)
            desc = description
        }

        if(arguments != null){
            val name = arguments?.getString(EXTRA_NAME)
            tv_name.text = name
            tv_desc.text = desc
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dua, container, false)
    }


}