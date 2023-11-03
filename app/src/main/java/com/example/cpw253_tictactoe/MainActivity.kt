package com.example.cpw253_tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import com.example.cpw253_tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    enum class Turn
    {
        NOUGHT,
        CROSS
    }

    private var firstTurn = Turn.CROSS
    private var currentTurn = Turn.CROSS

    private var boardList = mutableListOf<Button>()

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBoard()
    }

    private fun initBoard()
    {
        boardList.add(binding.button1)
        boardList.add(binding.button2)
        boardList.add(binding.button3)
        boardList.add(binding.button4)
        boardList.add(binding.button5)
        boardList.add(binding.button6)
        boardList.add(binding.button7)
        boardList.add(binding.button8)
        boardList.add(binding.button9)


    }

    fun onClick(view: View)
    {
        if(view !is Button)
            return
        addToBoard(view)
    }

    fun clickNewGame(view: View)
    {
        for(button in boardList)
        {
            button.text = ""
        }

        if(firstTurn == Turn.NOUGHT)
            firstTurn == Turn.CROSS
        else if(firstTurn == Turn.CROSS)
            firstTurn == Turn.NOUGHT

        currentTurn = firstTurn
        setTurnLabel()
    }

    private fun addToBoard(button: Button)
    {
        if(button.text != "")
            return

        if(currentTurn == Turn.NOUGHT)
        {
            button.text = NOUGHT
            currentTurn = Turn.CROSS
        }
        else if (currentTurn == Turn.CROSS)
        {
            button.text = CROSS
            currentTurn = Turn.NOUGHT
        }
        setTurnLabel()
    }

    private fun setTurnLabel()
    {
        var turnText = ""
        if(currentTurn == Turn.CROSS)
            turnText = "Player $CROSS's Turn"
        else if(currentTurn == Turn.NOUGHT)
            turnText = "Player $NOUGHT's Turn"

        binding.textView.text = turnText
    }

    companion object
    {
        const val NOUGHT = "O"
        const val CROSS = "X"

    }




}