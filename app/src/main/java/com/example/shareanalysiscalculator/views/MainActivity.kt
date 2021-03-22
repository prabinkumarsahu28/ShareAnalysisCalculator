package com.example.shareanalysiscalculator.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.shareanalysiscalculator.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var cs1: Float = 0.toFloat()
    private var ps1: Float = 0.toFloat()
    private var v: Float = 0.toFloat()
    private var cl: Float = 0.toFloat()

    private var t1: Float = 0.toFloat()
    private var t2: Float = 0.toFloat()
    private var t3: Float = 0.toFloat()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llT1R1.isVisible = false
        llT2R2.isVisible = false
        llT3R3.isVisible = false

        btnResult.setOnClickListener {

            if (etV.text.toString().isNotEmpty()) {
                v = etV.text.toString().toFloat()
            }
            if (etCl.text.toString().isNotEmpty()) {
                cl = etCl.text.toString().toFloat()
            }
            if (etCs.text.toString().isNotEmpty()) {
                cs1 = etCs.text.toString().toFloat()
            }
            if (etPs.text.toString().isNotEmpty()) {
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

            if (cs > 1.2) {
                t1 = ((m2 - cs) / x) + cl
                t2 = ((m1 - cs) / x) + cl
                t3 = ((m - cs) / x) + cl
            } else if (cs < -1.2) {
                t1 = ((m2 - cs) / x) - cl
                t2 = ((m1 - cs) / x) - cl
                t3 = ((m - cs) / x) - cl
            } else if (cs < 0 && cs >= -1.2) {
                t1 = ((m2 - cs) / x) + cl
                t2 = ((m1 - cs) / x) + cl
                t3 = ((m - cs) / x) + cl
            } else if (cs in 0.0..1.2) {
                t1 = ((m1 - cs) / x) - cl
                t2 = ((m2 - cs) / x) - cl
                t3 = ((m - cs) / x) - cl
            }

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