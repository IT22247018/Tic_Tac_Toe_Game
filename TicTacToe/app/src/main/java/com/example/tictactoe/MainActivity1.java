package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import com.example.tictactoe.databinding.ActivityMainBinding;
import java.util.ArrayList;
import java.util.List;

public class MainActivity1 extends AppCompatActivity {

    ActivityMainBinding binding;
    private final List<int[]> combinationList = new ArrayList<>();
    private int[] boxPositions = {0,0,0,0,0,0,0,0,0}; //9 zero
    private int playerTurn = 1;
    private int totalSelectedBoxes = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        combinationList.add(new int[] {0,1,2});
        combinationList.add(new int[] {3,4,5});
        combinationList.add(new int[] {6,7,8});
        combinationList.add(new int[] {0,3,6});
        combinationList.add(new int[] {1,4,7});
        combinationList.add(new int[] {2,5,8});
        combinationList.add(new int[] {2,4,6});
        combinationList.add(new int[] {0,4,8});

        String getPlayerOneName=getIntent().getStringExtra("playerOne");
        String getPlayerTwoName=getIntent().getStringExtra("playerTwo");

        binding.playerOneName.setText(getPlayerOneName);
        binding.playerTwoName.setText(getPlayerTwoName);

        binding.imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxselectable(0)){
                    perfromAction((ImageView)view,0);
                }
            }
        });

        binding.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxselectable(1)){
                    perfromAction((ImageView)view,1);
                }
            }
        });

        binding.imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxselectable(2)){
                    perfromAction((ImageView)view,2);
                }
            }
        });

        binding.imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxselectable(3)){
                    perfromAction((ImageView)view,3);
                }
            }
        });

        binding.imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxselectable(4)){
                    perfromAction((ImageView)view,4);
                }
            }
        });

        binding.imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxselectable(5)){
                    perfromAction((ImageView)view,5);
                }
            }
        });

        binding.imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxselectable(6)){
                    perfromAction((ImageView)view,6);
                }
            }
        });

        binding.imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxselectable(7)){
                    perfromAction((ImageView)view,7);
                }
            }
        });

        binding.imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxselectable(8)){
                    perfromAction((ImageView)view,8);
                }
            }
        });

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity1.this,Landscape.class);
                startActivity(intent);
            }
        },3000);

    }

    private void perfromAction(ImageView imageView,int selectedBoxPosition){
        boxPositions[selectedBoxPosition]=playerTurn;

        if(playerTurn==1){
            imageView.setImageResource(R.drawable.xximage);
            imageView.setBackgroundResource(R.drawable.black_box);
            if(checkResult()) {
                ResultDialog resultDialog = new ResultDialog(MainActivity1.this, binding.playerOneName.getText().toString()
                        + "Is a Winner!", MainActivity1.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            }else if(totalSelectedBoxes==9){
                ResultDialog resultDialog=new ResultDialog(MainActivity1.this,"Match Draw!",MainActivity1.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            }
            else {
                changePlayerTurn(2);
                totalSelectedBoxes++;

            }
        }else{
            imageView.setImageResource(R.drawable.ooimage);
            imageView.setBackgroundResource(R.drawable.black_box);
            if(checkResult()) {
                ResultDialog resultDialog = new ResultDialog(MainActivity1.this, binding.playerTwoName.getText().toString()
                        + "Is a Winner!", MainActivity1.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            }else if(totalSelectedBoxes==9){
                ResultDialog resultDialog=new ResultDialog(MainActivity1.this,"Match Draw!",MainActivity1.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            }
            else {
                changePlayerTurn(1);
                totalSelectedBoxes++;

            }
        }
    }

    private void changePlayerTurn(int currentPlayerTurn){

        playerTurn=currentPlayerTurn;

        if(playerTurn==1){
            binding.playerOneLayout.setBackgroundResource(R.drawable.black_border);
            binding.playerTwoLayout.setBackgroundResource(R.drawable.white_box);
        }else{
            binding.playerTwoLayout.setBackgroundResource(R.drawable.black_border);
            binding.playerOneLayout.setBackgroundResource(R.drawable.white_box);
        }

    }

    private boolean checkResult(){
        boolean response=false;
        for(int i=0;i<combinationList.size();i++){
            final int[] combination =combinationList.get(i);

            if(boxPositions[combination[0]]==playerTurn && boxPositions[combination[1]]==playerTurn &&
            boxPositions[combination[2]]==playerTurn){
                response=true;
            }
        }
        return response;
    }

    private boolean isBoxselectable(int boxPosition){
        boolean response=false;
        if(boxPositions[boxPosition]==0){
            response=true;
        }
        return  response;
    }

    public void restartMatch(){
        boxPositions=new int[] {0,0,0,0,0,0,0,0,0};
        playerTurn=1;
        totalSelectedBoxes=1;

        binding.imageView1.setImageResource(R.drawable.white_box);
        binding.imageView2.setImageResource(R.drawable.white_box);
        binding.imageView3.setImageResource(R.drawable.white_box);
        binding.imageView4.setImageResource(R.drawable.white_box);
        binding.imageView5.setImageResource(R.drawable.white_box);
        binding.imageView6.setImageResource(R.drawable.white_box);
        binding.imageView7.setImageResource(R.drawable.white_box);
        binding.imageView8.setImageResource(R.drawable.white_box);
        binding.imageView9.setImageResource(R.drawable.white_box);


    }


}


