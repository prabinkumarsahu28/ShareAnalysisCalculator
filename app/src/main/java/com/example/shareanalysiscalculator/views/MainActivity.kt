package com.example.shareanalysiscalculator.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.shareanalysiscalculator.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var cs1: Float = 0.000000000001.toFloat()
    private var ps1: Float = 0.000000000001.toFloat()
    private var v: Float = 0.000000000001.toFloat()
    private var cl: Float = 0.000000000001.toFloat()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llT1R1.isVisible = false
        llT2R2.isVisible = false
        llT3R3.isVisible = false

//        val viewModel = ViewModelProviders.of(this).get(DataViewModel::class.java)
//
//        etCs.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//
//            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                viewModel.cs1Changed(text.toString().toFloat())
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//            }
//        })
//
//        etPs.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//
//            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                viewModel.ps1Changed(text.toString().toFloat())
//
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//            }
//        })
//
//        etV.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//
//            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                viewModel.vChanged(text.toString().toFloat())
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//            }
//        })
//
//        etCl.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//
//            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                viewModel.clChanged(text.toString().toFloat())
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//            }
//        })
//
//        viewModel.getCs1LiveData().observe(this, {
//            cs1 = it
//        })
//
//        viewModel.getPs1LiveData().observe(this, {
//            ps1 = it
//        })
//
//        viewModel.getVLiveData().observe(this, {
//            v = it
//        })
//
//        viewModel.getClLiveData().observe(this, {
//            cl = it
//        })

        btnResult.setOnClickListener {

            if (etV.text.toString().isNotEmpty() || etCl.text.toString().isNotEmpty()) {
                v = etV.text.toString().toFloat()
                cl = etCl.text.toString().toFloat()
            }
            if (etCs.text.toString().isNotEmpty() || etPs.text.toString().isNotEmpty()) {
                cs1 = etCs.text.toString().toFloat()
                ps1 = etPs.text.toString().toFloat()
            }

            llT1R1.isVisible = true
            llT2R2.isVisible = true
            llT3R3.isVisible = true

            val x: Float = (100 / cl)
            val m: Float = (v / 12)
            val m1: Float = ((m * 0.66).toFloat())
            val m2: Float = ((m * 0.33).toFloat())
            val cs: Float = x * (cs1 - cl)
            val ps: Float = x * (ps1 - cl)
            val tg: Float = cs - ps
            val t1: Float = ((cs - m2) / x) + cl
            val t2: Float = ((cs - m1) / x) + cl
            val t3: Float = ((cs - m) / x) + cl
            val r1: Float = tg / x
            val r2: Float = ((tg * 0.66) / x).toFloat()
            val r3: Float = ((tg * 0.33) / x).toFloat()

            tvX.text = "X : $x"
            tvM.text = "M : $m"
            tvM1.text = "M1 : $m1"
            tvM2.text = "M2 : $m2"
            tvT1.text = "T1 : $t1"
            tvT2.text = "T2 : $t2"
            tvT3.text = "T3 : $t3"
            tvCs.text = "CS : $cs"
            tvPs.text = "PS : $ps"
            tvTg.text = "TG : $tg"
            tvR1.text = "R1 : $r1"
            tvR2.text = "R2 : $r2"
            tvR3.text = "R3 : $r3"
        }
    }
}