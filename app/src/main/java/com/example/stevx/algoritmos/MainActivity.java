package com.example.stevx.algoritmos;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView[] txtnum;
    private int []numbers = {4,18,3,2,7};
    private Handler handler = new Handler();
    int loop=0,n;


    private TextView[] txtint;
    private int[] integers = {8,15,9,5,1};

    private Button graficas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnum = new TextView[5];
        txtnum[0] = findViewById(R.id.txtnum1);
        txtnum[1] = findViewById(R.id.txtnum2);
        txtnum[2] = findViewById(R.id.txtnum3);
        txtnum[3] = findViewById(R.id.txtnum4);
        txtnum[4] = findViewById(R.id.txtnum5);

        txtint = new TextView[5];
        txtint[0] = findViewById(R.id.txtint1);
        txtint[1] = findViewById(R.id.txtint2);
        txtint[2] = findViewById(R.id.txtint3);
        txtint[3] = findViewById(R.id.txtint4);
        txtint[4] = findViewById(R.id.txtint5);

        graficas = findViewById(R.id.graficas);
        graficas.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                entrarGraficas();
            }
        });


        for(int i=0;i<numbers.length;i++){
            txtnum[i].setText(String.valueOf(numbers[i]));

            findViewById(R.id.bsort).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    BubbleSort();
                }
            });

            }

        for(int i=0;i<integers.length;i++){
            txtint[i].setText(String.valueOf(integers[i]));

            findViewById(R.id.ssort).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    insertionsort();
                }
            });

        }

    }

    public void entrarGraficas(){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

    private void BubbleSort() {
            animat(0,1);
    }

    public void animat(final int m,final int n){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(Integer.valueOf(txtnum[m].getText().toString())>Integer.valueOf(txtnum[n].getText().toString())){
                    String temp = txtnum[m].getText().toString();
                    txtnum[m].setText(txtnum[n].getText().toString());
                    txtnum[n].setText(temp);
                }
                txtnum[m].setBackgroundResource(R.drawable.circle_shape_blue);
                txtnum[n].setBackgroundResource(R.drawable.circle_shape_blue);
                int j=n+1;
                int i=m+1;
                if(j==numbers.length-loop){
                    i = 0;
                    j=i+1;
                    loop++;
                }
                if(loop<numbers.length-1){

                    animat(i,j);
                }

            }
        },3000);
        txtnum[m].setBackgroundResource(R.drawable.circle_shape_orange);
        txtnum[n].setBackgroundResource(R.drawable.circle_shape_orange);
    }


    public void insertionsort(){
        animateInsertion(1);
    }

    public void animateInsertion(final int m){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(m!=n){
                    String temp = txtint[m].getText().toString();
                    for(int k=m;k>n;k--){
                        txtint[k].setText(txtint[k-1].getText().toString());
                    }
                    txtint[n].setText(temp);
                }
                txtint[m].setBackgroundResource(R.drawable.circle_shape_blue);
                txtint[n].setBackgroundResource(R.drawable.circle_shape_blue);

                int i=m+1;
                if(i<integers.length){

                    animateInsertion(i);
                }

            }
        },3000);

        txtint[m].setBackgroundResource(R.drawable.circle_shape_orange);

        n = findInsertMin(m);

        txtint[n].setBackgroundResource(R.drawable.circle_shape_orange);
    }


    int findInsertMin(int v){
        int mi = v;
        for(int k=0;k<=mi;k++){
            if(Integer.valueOf(txtint[k].getText().toString())>Integer.valueOf(txtint[mi].getText().toString())){
                mi=k;
            }
        }
        return mi;
    }
}

