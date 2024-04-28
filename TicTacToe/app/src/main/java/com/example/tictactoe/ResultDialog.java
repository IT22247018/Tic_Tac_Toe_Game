package com.example.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jetbrains.annotations.NonNls;

public class ResultDialog extends Dialog {

    private final String message;
    private final MainActivity1 mainActivity;

    public ResultDialog(@NonNull Context context, String message, MainActivity1 mainActivity){
        super(context);
        this.message=message;
        this.mainActivity=mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_dialog);

        TextView messageText=findViewById(R.id.messageText);
        Button statAgainButton=findViewById(R.id.startAgainButton);

        messageText.setText(message);

        statAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.restartMatch();
                dismiss();
            }
        });
    }
}