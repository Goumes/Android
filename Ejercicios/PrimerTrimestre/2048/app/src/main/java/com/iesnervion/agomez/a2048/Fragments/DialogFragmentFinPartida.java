package com.iesnervion.agomez.a2048.Fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.iesnervion.agomez.a2048.R;

/**
 * Created by aleja on 28/02/2018.
 */

public class DialogFragmentFinPartida extends DialogFragment
{
    Button btnAceptar;
    TextView valorScore;
    private DialogInterface.OnDismissListener onDismissListener;

    public static DialogFragmentFinPartida newInstance(int score) {
        DialogFragmentFinPartida f = new DialogFragmentFinPartida();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("score", score);
        f.setArguments(args);

        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fin_partida, container, false);

        int score = getArguments().getInt("score");

        btnAceptar = view.findViewById(R.id.btnAceptar);
        valorScore = view.findViewById(R.id.valorDialogScore);
        valorScore.setText(String.valueOf(score));

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               dismiss();
            }
        });

        return view;
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialog);
        }
    }

}
