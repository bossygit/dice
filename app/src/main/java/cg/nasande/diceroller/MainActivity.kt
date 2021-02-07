  package cg.nasande.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_scroll : Button = findViewById(R.id.button_scroll)

                button_scroll.setOnClickListener {

                    val diceImage : ImageView = findViewById(R.id.imageView)

                    val diceResult : Dice = Dice(6)
                    diceImage.contentDescription = diceResult.roll().toString()

                    when(diceResult.roll()){

                        1 -> diceImage.setImageResource(R.drawable.dice_1)
                        2 -> diceImage.setImageResource(R.drawable.dice_2)
                        3 -> diceImage.setImageResource(R.drawable.dice_3)
                        4 -> diceImage.setImageResource(R.drawable.dice_4)
                        5 -> diceImage.setImageResource(R.drawable.dice_5)
                        6 -> diceImage.setImageResource(R.drawable.dice_6)
                    }

                    val toast : Toast = Toast.makeText(this,"Dice rolled",Toast.LENGTH_LONG)
                    toast.show()
                }

    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}