package com.ianpedraza.magicball.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ianpedraza.magicball.R
import com.ianpedraza.magicball.utils.Event
import kotlin.random.Random

class HomeViewModel : ViewModel() {

    private val _magicBallImageResource: MutableLiveData<Event<Int>> =
        MutableLiveData()

    val magicBallImageResource: LiveData<Event<Int>>
        get() = _magicBallImageResource

    fun ask() {
        val randomInt = Random.nextInt(6) + 1

        val drawableResource = when (randomInt) {
            1 -> R.drawable.magic_ball_1
            2 -> R.drawable.magic_ball_2
            3 -> R.drawable.magic_ball_3
            else -> R.drawable.magic_ball_4
        }

        _magicBallImageResource.value = Event(drawableResource)
    }

}