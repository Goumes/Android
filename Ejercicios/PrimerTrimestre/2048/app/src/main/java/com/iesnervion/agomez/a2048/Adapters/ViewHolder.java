package com.iesnervion.agomez.a2048.Adapters;

import android.widget.TextView;

/**
 * Created by aleja on 19/02/2018.
 */

public class ViewHolder
{
    TextView user;
    TextView highscore;


    public ViewHolder(TextView user, TextView highscore) {
        this.user = user;
        this.highscore = highscore;
    }

    public TextView getUser() {
        return user;
    }

    public void setUser(TextView user) {
        this.user = user;
    }

    public TextView getHighscore() {
        return highscore;
    }

    public void setHighscore(TextView highscore) {
        this.highscore = highscore;
    }
}
