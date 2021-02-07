package com.example.hw_4

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.hw_4.databinding.FragmentActualGameBinding


class ActualGameFragment : Fragment(R.layout.fragment_actual_game) {

    private val args: ActualGameFragmentArgs by navArgs()
    lateinit var binding: FragmentActualGameBinding
    private val repository = UsersRepository


    //1=green  0 =red
    var activePlayer = 0
    var gameIsActive = true
    var count = 0
    var occupiedBy = intArrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)
    var winningPositions = arrayOf(
        intArrayOf(0, 1, 2),
        intArrayOf(3, 4, 5),
        intArrayOf(6, 7, 8),
        intArrayOf(0, 3, 6),
        intArrayOf(1, 4, 7),
        intArrayOf(2, 5, 8),
        intArrayOf(0, 4, 8),
        intArrayOf(2, 4, 6)
    )



      fun dropIn(view: View) {

            val image = view as ImageView
            //understand
            val tappedcounter = image.tag.toString().toInt()
            if (occupiedBy[tappedcounter] == 2 && gameIsActive) {

                if (activePlayer == 1) {
                    image.setImageResource(R.drawable.ic_o)
                    activePlayer = 0
                    count++
                    occupiedBy[tappedcounter] = 1
                } else {
                    image.setImageResource(R.drawable.ic_x)
                    activePlayer = 1
                    count++
                    occupiedBy[tappedcounter] = 0
                }
                binding.whoseTurnTv.text = args.names[activePlayer]

                for (winningposition in winningPositions) {

                    if (occupiedBy[winningposition[0]] == occupiedBy[winningposition[1]]
                        && occupiedBy[winningposition[1]] == occupiedBy[winningposition[2]]
                        && occupiedBy[winningposition[0]] != 2) {

                        higlight(winningposition)
                        if (occupiedBy[winningposition[0]] == 0)
                            binding.winner1.text = "${args.names[0]} Won"
                        else if (occupiedBy[winningposition[0]] == 1)
                            binding.winner1.text = "${args.names[1]} Won"

                        binding.winner.visibility = View.VISIBLE
                        gameIsActive = false
                    }
                }
            }
            if (gameIsActive && count == 9) {
                activePlayer = 2
                binding.winner1.text = "DRAW"
                binding.winner.visibility = View.VISIBLE
                gameIsActive = false
            }
        }

        fun higlight(indexes: IntArray)
        {
            for (i in indexes )
                when (i){
                    binding.imageView.tag.toString().toInt() -> binding.imageView.setBackgroundColor(Color.BLACK)
                    binding.imageView2.tag.toString().toInt() -> binding.imageView2.setBackgroundColor(Color.BLACK)
                    binding.imageView3.tag.toString().toInt() -> binding.imageView3.setBackgroundColor(Color.BLACK)
                    binding.imageView4.tag.toString().toInt() -> binding.imageView4.setBackgroundColor(Color.BLACK)
                    binding.imageView5.tag.toString().toInt() -> binding.imageView5.setBackgroundColor(Color.BLACK)
                    binding.imageView6.tag.toString().toInt() -> binding.imageView6.setBackgroundColor(Color.BLACK)
                    binding.imageView7.tag.toString().toInt() -> binding.imageView7.setBackgroundColor(Color.BLACK)
                    binding.imageView8.tag.toString().toInt() -> binding.imageView8.setBackgroundColor(Color.BLACK)
                    binding.imageView9.tag.toString().toInt() -> binding.imageView9.setBackgroundColor(Color.BLACK)

                }

        }


        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)



            binding = FragmentActualGameBinding.bind(view)
            binding.whoseTurnTv.text = args.names[0]

            binding.imageView.setOnClickListener{
                dropIn(binding.imageView)
            }
            binding.imageView2.setOnClickListener{
                dropIn(binding.imageView2)
            }
            binding.imageView3.setOnClickListener{
                dropIn(binding.imageView3)
            }
            binding.imageView4.setOnClickListener{
                dropIn(binding.imageView4)
            }
            binding.imageView5.setOnClickListener{
                dropIn(binding.imageView5)
            }
            binding.imageView6.setOnClickListener{
                dropIn(binding.imageView6)
            }
            binding.imageView7.setOnClickListener{
                dropIn(binding.imageView7)
            }
            binding.imageView8.setOnClickListener{
                dropIn(binding.imageView8)
            }
            binding.imageView9.setOnClickListener{
                dropIn(binding.imageView9)
            }


            binding.continueBtn.setOnClickListener{
                if (activePlayer == 1) {
                    repository.updateUser(args.names[0], true)
                    repository.updateUser(args.names[1], false)
                }
                else if(activePlayer == 0){
                    repository.updateUser(args.names[0], false)
                    repository.updateUser(args.names[1], true)
                }
                findNavController().navigate(ActualGameFragmentDirections.actionActualGameFragmentToUserRecordsFragment2())
            }


        }


    }

