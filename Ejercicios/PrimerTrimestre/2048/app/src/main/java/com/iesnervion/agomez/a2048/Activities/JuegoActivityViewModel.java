package com.iesnervion.agomez.a2048.Activities;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.iesnervion.agomez.a2048.Entities.Tablero;

/**
 * Created by aleja on 08/02/2018.
 */

public class JuegoActivityViewModel extends ViewModel
{
    private MutableLiveData<Tablero> tablero;
    private MutableLiveData<Integer> score;
    private MutableLiveData<Integer> highscore;

    public JuegoActivityViewModel()
    {
        //El viewModel entero se puede guardar en la badat para cuando el jugador se salga se quede guardado el estado de la partida.
        this.tablero = new MutableLiveData<>();
        this.score = new MutableLiveData<>();
        this.highscore = new MutableLiveData<>();
    }


    public JuegoActivityViewModel(MutableLiveData<Tablero> tablero, MutableLiveData<Integer> score, MutableLiveData<Integer> highscore) {
        this.tablero = tablero;
        this.score = score;
        this.highscore = highscore;
    }

    public MutableLiveData<Tablero> getTablero() {
        return tablero;
    }

    public void setTablero(MutableLiveData<Tablero> tablero) {
        this.tablero = tablero;
    }

    public MutableLiveData<Integer> getScore() {
        return score;
    }

    public void setScore(MutableLiveData<Integer> score) {
        this.score = score;
    }

    public MutableLiveData<Integer> getHighscore() {
        return highscore;
    }

    public void setHighscore(MutableLiveData<Integer> highscore) {
        this.highscore = highscore;
    }
}
