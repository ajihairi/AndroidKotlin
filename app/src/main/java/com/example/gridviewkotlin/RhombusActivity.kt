package com.example.gridviewkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_rhombus.*
import java.lang.StringBuilder

class RhombusActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rhombus)
        init()
    }

    private fun init(){
        convert_btn.setOnClickListener {
            val numb = input_text_id.text.toString()
            reset_btn.visibility = View.VISIBLE
            main(numb.toInt())
        }
        reset_btn.setOnClickListener {
            text_view_id.text = ""
            input_text_id.setText("")
            reset_btn.visibility = View.GONE
        }
        reset_btn.visibility = View.GONE
    }

    fun main(numb : Int) {
        // val br = BufferedReader(InputStreamReader(System.`in`))
        println("ENTER THE HEIGHT ")
        // int value = (int) Math.floor(5/2);
        // System.out.println(value);
        var stringBuilder = StringBuilder()
        val ht = numb //height
        val space = ht - 1

        var midspace = if (ht % 2 != 0) -1 else 0//1
        var k: Int

        run {
            var c = 1
            while (c <= Math.ceil((ht / 2).toDouble()))
            // dibulatkan ke atas input 5/2 == 3
            {
                var i = space
                while (i >= 1) {
                    var i2 = Math.ceil((i / 2).toDouble()).toInt()
                    // int i2 = i;
                    while (i2 != 0) {
//                        print(" ")
                        stringBuilder.append(" ")
                        i2--
                    }
                    stringBuilder.append("*")
//                    print("*")

                    for (j in 1..midspace)
//                        print(" ")
                         stringBuilder.append(" ")

                    val x = if (ht % 2 != 0) 1 else 0
                    if (c != x) {
                        stringBuilder.append("*")
                    }

                    //1
//                        print("*")
                    midspace += 2 // 2
                    stringBuilder.append("\n")
//                    println()
                    c++
                    i -= 2
                }
            }
        }

        var c = 1
        while (c <= Math.floor((ht / 2).toDouble()))
        // dibulatkan kebawah input 5/2 == 2
        {
            var i = 0
            while (i <= space) {
                // int i2=i;
                var i2 = Math.ceil((i / 2).toDouble()).toInt()
                while (i2 != 0) {
//                    print(" ")
                    stringBuilder.append(" ")
                    i2--
                }
                midspace -= 2 // 2
                stringBuilder.append("*")
//                print("*")
                val z = if (ht % 2 != 0) 2 else 0
                k = midspace + z
                while (k >= 1) {
                    // for(k=midspace+2;k>=1;k-- )
                    stringBuilder.append(" ")
                    k--
                }
                val x = if (ht % 2 != 0) ht / 2 + 1 else ht / 1
                if (c != x) {
                //if ((c!=(ht/2+1)))
                    stringBuilder.append("*") }

                stringBuilder.append("\n")

                c++
                i += 2
            }
        }
        text_view_id.text = stringBuilder.toString()
    }
}
