package com.example.calculadora_kotlin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException


class MainActivity : AppCompatActivity() {

    var isNewOp = true
    var oldNum = ""
    var op = "+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        botonigual.isClickable = false


    }

    fun number(view: View) {
        if (isNewOp) {
            cuadrito.text = ""
            tv_2.text = ""
        }
        isNewOp = false
        var btClickValue = cuadrito.text.toString()
        var btPressed = view as Button
        when (btPressed.id) {
            bot0.id -> {
                btClickValue += "0"
            }
            bot1.id -> {
                btClickValue += "1"
            }
            bot2.id -> {
                btClickValue += "2"
            }
            bot3.id -> {
                btClickValue += "3"
            }
            bot4.id -> {
                btClickValue += "4"
            }
            bot5.id -> {
                btClickValue += "5"
            }
            bot6.id -> {
                btClickValue += "6"
            }
            bot7.id -> {
                btClickValue += "7"
            }
            bot8.id -> {
                btClickValue += "8"
            }
            bot9.id -> {
                btClickValue += "9"
            }
            botonsr.id -> {
                btClickValue = "-$btClickValue"
                botonsr.isClickable = false
            }
            botoncoma.id -> {
                if (btClickValue.isNotEmpty()) {
                    btClickValue += "."
                } else {
                    btClickValue += "0."
                }
                botoncoma.isClickable = false
            }
        }
        cuadrito.setText(btClickValue)
    }

    fun operator(view: View) {
        botonsr.isClickable = true
        botoncoma.isClickable = true
        var btPressed = view as Button
        when (btPressed.id) {
            botonsuma.id -> {
                op = "+"
            }
            botonresta.id -> {
                op = "-"
            }
            botonmulti.id -> {
                op = "x"
            }
            botondivi.id -> {
                op = "/"
            }
        }
        oldNum = cuadrito.text.toString()
        isNewOp = true
        botonigual.isClickable = true
    }

    fun equal(view: View) {
        var newNum = cuadrito.text.toString()
        var result = 0.0
        when (op) {
            "+" -> {
                result = oldNum.toDouble() + newNum.toDouble()
            }
            "-" -> {
                result = oldNum.toDouble() - newNum.toDouble()
            }
            "x" -> {
                result = oldNum.toDouble() * newNum.toDouble()
                if (result.isInfinite() || result.isNaN()) {
                    result = 0.0;
                }
            }
            "/" -> {
                result = oldNum.toDouble() / newNum.toDouble()
                if (result.isInfinite() || result.isNaN()) {
                    result = 0.0
                    Toast.makeText(
                        applicationContext,
                        "No puedes dividir entre 0",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

        tv_2.setText(oldNum + op + newNum)
        cuadrito.text = result.toString()
        isNewOp = true
    }

    fun deleteLast(view: View) {
        val chain = cuadrito.text.toString()
        if (chain.isNotEmpty()) {
            cuadrito.text = chain.substring(0, chain.length - 1)
        }
    }

    fun resetAll(view: View) {

        oldNum = 0.toString()
        cuadrito.text = "0"
        tv_2.text = ""
        isNewOp = true
        botonigual.isClickable = true
    }

    fun percent(view: View) {
        var percent = cuadrito.text.toString().toDouble() / 100
        cuadrito.setText(percent.toString())
        isNewOp = true
    }

    var isNewOpLand = true
    var oldNumLand = ""
    var opLand = "+"

    fun landNum(view: View) {
        if (isNewOpLand) {
            cuadrito.text = ""
        }
        isNewOpLand = false
        var btClickValue = cuadrito.text.toString()
        var btPressed = view as Button
        when (btPressed.id) {
            bot0.id -> {
                btClickValue += "0"
            }
            bot1.id -> {
                btClickValue += "1"
            }
            bot2.id -> {
                btClickValue += "2"
            }
            bot3.id -> {
                btClickValue += "3"
            }
            bot4.id -> {
                btClickValue += "4"
            }
            bot5.id -> {
                btClickValue += "5"
            }
            bot6.id -> {
                btClickValue += "6"
            }
            bot7.id -> {
                btClickValue += "7"
            }
            bot8.id -> {
                btClickValue += "8"
            }
            bot9.id -> {
                btClickValue += "9"
            }
            botoncoma.id -> {
                if (btClickValue.isNotEmpty()) {
                    btClickValue += "."
                } else {
                    btClickValue += "0."
                }
                botoncoma.isClickable = false
            }
        }
        cuadrito.setText(btClickValue)
    }

    fun numLetra(view: View) {
        if (isNewOpLand) {
            cuadrito.text = ""
        }
        isNewOpLand = false
        var btClickValue = cuadrito.text.toString()
        var btPressed = view as Button
        when (btPressed.id) {
            A.id -> {
                btClickValue += "a"
            }
            B.id -> {
                btClickValue += "b"
            }
            C.id -> {
                btClickValue += "c"
            }
            D.id -> {
                btClickValue += "d"
            }
            E.id -> {
                btClickValue += "e"
            }
            F.id -> {
                btClickValue += "f"
            }
        }
        cuadrito.setText(btClickValue)
    }

    fun landOperator(view: View) {
        botoncoma.isClickable = true
        var btPressed = view as Button

        if (!botonbinario.isEnabled) {
            var numero = cuadrito.text.toString().toLong()
            var a = convertBinaryToDecimal(numero)
            oldNumLand = a.toString()
            cuadrito.setText("0")
        }
        if (!botonhexadecimal.isEnabled) {
            var x = hexadecimalADecimal(cuadrito.text.toString());
            oldNumLand = x.toString()
            cuadrito.setText("0")
        }
        if (!botondecimal.isEnabled) {
            oldNumLand = cuadrito.text.toString()
            cuadrito.setText("0")
        }
        when (btPressed.id) {
            botonsuma.id -> {
                opLand = "+"
            }
            botonresta.id -> {
                opLand = "-"
            }
            botonmulti.id -> {
                opLand = "x"
            }
            botondivi.id -> {
                opLand = "/"
            }
        }
        isNewOpLand = true
        botonigual.isClickable = true
    }

    fun landEqual(view: View) {
        var currentNum = cuadrito.text
        var result = 0
        try {
            var newNum = cuadrito.text.toString()
            if (!botonbinario.isEnabled) {
                var numero = cuadrito.text.toString().toLong()
                var x = convertBinaryToDecimal(numero)
                newNum = x.toString()
            }
            if (!botonhexadecimal.isEnabled) {
                var x = hexadecimalADecimal(cuadrito.text.toString());
                newNum = x.toString()
            }
            if (!botondecimal.isEnabled) {
                newNum = cuadrito.text.toString()
            }

            when (opLand) {

                "+" -> {
                    result = oldNumLand.toInt() + newNum.toInt()
                }
                "-" -> {
                    result = oldNumLand.toInt() - newNum.toInt()
                }
                "x" -> {
                    result = oldNumLand.toInt() * newNum.toInt()

                }
                "/" -> {
                    result = oldNumLand.toInt() / newNum.toInt()

                }

            }

            if (!botonbinario.isEnabled) {
                var bin = result.toString()

                var resBin = Integer.toBinaryString(bin.toInt())
                cuadrito.setText(resBin.toString())
            }
            if (!botonhexadecimal.isEnabled) {
                var e = result.toString()
                var r = Integer.toHexString(e.toInt())
                cuadrito.setText(r)
            }
            if (!botondecimal.isEnabled) {
                cuadrito.setText(result.toString())
            }

            isNewOpLand = true
        } catch (ae: ArithmeticException) {
            Toast.makeText(applicationContext, "No puedes dividir entre 0", Toast.LENGTH_SHORT)
                .show()
            result = 0

        } catch (ex: NumberFormatException) {
            currentNum = cuadrito.text
        } catch (e: Exception) {
        }

    }

    fun resetAllLand(view: View) {
        oldNum = 0.toString()
        cuadrito.text = "0"
        isNewOp = true
    }

    fun deleteLastLand(view: View) {
        val chain = cuadrito.text.toString()
        if (chain.isNotEmpty()) {
            cuadrito.text = chain.substring(0, chain.length - 1)
        }
    }

    fun convertBinaryToDecimal(num: Long): Int {
        var num = num
        var decimalNumber = 0
        var i = 0
        var remainder: Long

        while (num.toInt() != 0) {
            remainder = num % 10
            num /= 10
            decimalNumber += (remainder * Math.pow(2.0, i.toDouble())).toInt()
            ++i
        }
        return decimalNumber
    }

    fun hexadecimalADecimal(hexadecimal: String): Long {
        var decimal: Long = 0
        var potencia = 0
        for (x in hexadecimal.length - 1 downTo 0) {
            val valor: Int = caracterHexadecimalADecimal(hexadecimal[x])
            val elevado = Math.pow(16.0, potencia.toDouble()).toLong() * valor
            decimal += elevado
            potencia++
        }
        return decimal
    }

    fun caracterHexadecimalADecimal(caracter: Char): Int {
        return when (caracter) {
            'a' -> 10
            'b' -> 11
            'c' -> 12
            'd' -> 13
            'e' -> 14
            'f' -> 15
            else -> caracter.toString().toInt()
        }
    }

    fun binary(view: View) {

        Toast.makeText(applicationContext, "Modo BINARIO activado", Toast.LENGTH_SHORT)
            .show()
        bot2.visibility = View.INVISIBLE
        bot3.visibility = View.INVISIBLE
        bot4.visibility = View.INVISIBLE
        bot5.visibility = View.INVISIBLE
        bot6.visibility = View.INVISIBLE
        bot7.visibility = View.INVISIBLE
        bot8.visibility = View.INVISIBLE
        bot9.visibility = View.INVISIBLE

        A.visibility = View.INVISIBLE
        B.visibility = View.INVISIBLE
        C.visibility = View.INVISIBLE
        D.visibility = View.INVISIBLE
        E.visibility = View.INVISIBLE
        F.visibility = View.INVISIBLE

        if (!botondecimal.isEnabled) {
            if (cuadrito.text == "") {
                cuadrito.text = "0"
            } else {
                try {
                    var toBi = cuadrito.text.toString().toLong()
                    cuadrito.setText(Integer.toBinaryString(toBi.toInt()))
                } catch (ae: NumberFormatException) {
                    Toast.makeText(applicationContext, "Numero demasiado largo", Toast.LENGTH_LONG)
                        .show()
                    cuadrito.text = "0"
                }

            }
        }

        if (!botonhexadecimal.isEnabled) {
            try {
                var toDec = hexadecimalADecimal(cuadrito.text.toString())
                cuadrito.setText(Integer.toBinaryString(toDec.toInt()))
            } catch (ae: NumberFormatException) {
                Toast.makeText(applicationContext, "Numero demasiado largo", Toast.LENGTH_LONG)
                    .show()
                cuadrito.text = "0"
            }

        }

        botonbinario.setEnabled(false)
        botondecimal.setEnabled(true)
        botonhexadecimal.setEnabled(true)
    }

    fun decimal(view: View) {
        Toast.makeText(applicationContext, "Modo DECIMAL activado", Toast.LENGTH_SHORT)
            .show()

        bot2.visibility = View.VISIBLE
        bot3.visibility = View.VISIBLE
        bot4.visibility = View.VISIBLE
        bot5.visibility = View.VISIBLE
        bot6.visibility = View.VISIBLE
        bot7.visibility = View.VISIBLE
        bot8.visibility = View.VISIBLE
        bot9.visibility = View.VISIBLE

        A.visibility = View.INVISIBLE
        B.visibility = View.INVISIBLE
        C.visibility = View.INVISIBLE
        D.visibility = View.INVISIBLE
        E.visibility = View.INVISIBLE
        F.visibility = View.INVISIBLE

        if (!botonbinario.isEnabled) {
            try {
                var toBi = cuadrito.text.toString().toLong()
                var a = convertBinaryToDecimal(toBi)
                cuadrito.setText(a.toString())
            } catch (ae: NumberFormatException) {
                Toast.makeText(applicationContext, "Numero demasiado largo", Toast.LENGTH_LONG)
                    .show()
                cuadrito.text = "0"
            }
        }
        if (!botonhexadecimal.isEnabled) {
            try {
                var toDec = hexadecimalADecimal(cuadrito.text.toString())
                cuadrito.setText(toDec.toString())
            } catch (ae: NumberFormatException) {
                Toast.makeText(applicationContext, "Numero demasiado largo", Toast.LENGTH_LONG)
                    .show()
                cuadrito.text = "0"
            }
        }
        botonbinario.setEnabled(true)
        botondecimal.setEnabled(false)
        botonhexadecimal.setEnabled(true)
    }

    fun hexa(view: View) {
        Toast.makeText(applicationContext, "Modo HEXADECIMAL activado", Toast.LENGTH_SHORT)
            .show()
        bot2.visibility = View.VISIBLE
        bot3.visibility = View.VISIBLE
        bot4.visibility = View.VISIBLE
        bot5.visibility = View.VISIBLE
        bot6.visibility = View.VISIBLE
        bot7.visibility = View.VISIBLE
        bot8.visibility = View.VISIBLE
        bot9.visibility = View.VISIBLE

        A.visibility = View.VISIBLE
        B.visibility = View.VISIBLE
        C.visibility = View.VISIBLE
        D.visibility = View.VISIBLE
        E.visibility = View.VISIBLE
        F.visibility = View.VISIBLE

        if (!botonbinario.isEnabled) {

            try {
                var toBi = cuadrito.text.toString().toLong()
                var toDec = convertBinaryToDecimal(toBi)
                cuadrito.setText(Integer.toHexString(toDec))
            } catch (ae: NumberFormatException) {
                Toast.makeText(applicationContext, "Numero demasiado largo", Toast.LENGTH_LONG)
                    .show()
                cuadrito.text = "0"
            }
        }
        if (!botondecimal.isEnabled) {
            try {
                var toDec = hexadecimalADecimal(cuadrito.text.toString())
                cuadrito.setText(Integer.toHexString(toDec.toInt()))
            } catch (ae: NumberFormatException) {
                Toast.makeText(applicationContext, "Numero demasiado largo", Toast.LENGTH_LONG)
                    .show()
                cuadrito.text = "0"
            }
        }
        botonbinario.setEnabled(true)
        botondecimal.setEnabled(true)
        botonhexadecimal.setEnabled(false)
    }


}
