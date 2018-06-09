package com.example.suryakiranvamsi.fun;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public Button b2,b4,bplayagain;
    public TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv,tvletterschecked,tvbest;
    private EditText et;
    public ImageView iv;
    MediaPlayer mediaPlayer;
    public TextView tv8,tv9;
    public String s, names[] = {"frazzle","dazzled","skyjack","attempt","brother","capture","charity","economy","evident","fashion","fortune","gateway","forever","improve","holiday","inspire","jointly","liberal","nuclear","sponsor"};
    public int g,n,i,x,sum=0,pos=0,points=0;
    int[] a = new int[26];
    int flag[]={0,0,0,0,0,0,0};
    int highscore=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b2= (Button)findViewById(R.id.button2);
        b4 = (Button)findViewById(R.id.button4);
        bplayagain = (Button)findViewById(R.id.button);
        tv1 = (TextView)findViewById(R.id.textView1);
        tv2 = (TextView)findViewById(R.id.textView2);
        tv3 = (TextView)findViewById(R.id.textView3);
        tv4 = (TextView)findViewById(R.id.textView4);
        tv5 = (TextView)findViewById(R.id.textView5);
        tv6 = (TextView)findViewById(R.id.textView6);
        tv7 = (TextView)findViewById(R.id.textView7);
        tv = (TextView)findViewById(R.id.textView8);
        tv9 = (TextView)findViewById(R.id.textView9);
        tvletterschecked = (TextView)findViewById(R.id.textView);
        et = (EditText)findViewById(R.id.editText);
        iv = (ImageView)findViewById(R.id.imageView);
        tvbest= (TextView)findViewById(R.id.textView11);
        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.iphone_x);

        SharedPreferences myScore = this.getSharedPreferences("myawesomescore", Context.MODE_PRIVATE);
        highscore = myScore.getInt("highscore",highscore);
        tvbest.setText("best score : " + highscore);


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                b4.animate().alpha(0).setDuration(100);
                b2.animate().alpha(1).setDuration(1000);
                et.animate().alpha(1).setDuration(3000);
                b2.setEnabled(true);
                tv.animate().alpha(1).setDuration(3000);
                tvletterschecked.animate().alpha(1).setDuration(3000);
                bplayagain.animate().alpha(1).setDuration(3000);
                iv.animate().alpha(0f).setDuration(4000);
                Random r = new Random();
                n = r.nextInt(20);
            }
        });

       /* et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b2.setEnabled(true);
            }
        }); */

        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (et.getText().equals("")) et.setText("enter letter");
                else {
                    s = names[n];
                    char c = et.getText().toString().toLowerCase().charAt(0);
                    if (c >= 'a' && c <= 'z') {
                        Toast.makeText(getApplicationContext(), "u entered a letter", Toast.LENGTH_SHORT).show();
                        g = 1;
                    } else {
                        et.setText("");
                        Toast.makeText(getApplicationContext(), "enter a letter ", Toast.LENGTH_LONG).show();
                    }
                    if (g == 1) {
                        int y = c;
                        if (a[y-97]==0 && s.charAt(0) != c && s.charAt(1) != c && s.charAt(2) != c && s.charAt(3) != c && s.charAt(4) != c && s.charAt(5) != c && s.charAt(6) != c) {
                            sum += 1;
                            tvletterschecked.append("  " + c + " , ");
                        }
                        if (a[y - 97] == 0) {
                            x = s.charAt(0);
                            if (x == c) {
                                tv1.setText("" + c);
                                pos += 1;
                                flag[0] = 1;
                            }
                            x = s.charAt(1);
                            if (x == c) {
                                tv2.setText("" + c);
                                pos += 1;
                                flag[1] = 1;
                            }
                            x = s.charAt(2);
                            if (x == c) {
                                tv3.setText("" + c);
                                pos += 1;
                                flag[2] = 1;
                            }
                            x = s.charAt(3);
                            if (x == c) {
                                tv4.setText("" + c);
                                pos += 1;
                                flag[3] = 1;
                            }
                            x = s.charAt(4);
                            if (x == c) {
                                tv5.setText("" + c);
                                pos += 1;
                                flag[4] = 1;
                            }
                            x = s.charAt(5);
                            if (x == c) {
                                tv6.setText("" + c);
                                pos += 1;
                                flag[5] = 1;
                            }
                            x = s.charAt(6);
                            if (x == c) {
                                tv7.setText("" + c);
                                pos += 1;
                                flag[6] = 1;
                            }
                        }
                        a[y - 97] = 1;
                    }
                    g = 0;
                    points = pos * 4 - sum;
                    et.setText("");
                    tv.setText("your score ::  " + points);
                    if (flag[0] == 1 && flag[1] == 1 && flag[2] == 1 && flag[3] == 1 && flag[4] == 1 && flag[5] == 1 && flag[6] == 1) {
                        b4.setAlpha(0);
                        b2.setAlpha(0);
                        b2.setEnabled(false);
                        b4.setEnabled(false);
                        bplayagain.setEnabled(true);
                        tvletterschecked.setText("");
                        et.setAlpha(0);
                        if(highscore < points) {
                            highscore = points;
                            SharedPreferences myScore = getSharedPreferences("myawesomescore", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = myScore.edit();
                            editor.putInt("highscore", highscore);
                            editor.commit();
                            tvbest.setText("best score : "+ highscore);
                        }
                        tv9.setText("  u won \n" + "  score : " + points);
                        mediaPlayer.start();
                    }
                }
            }
        });

        bplayagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b2.setAlpha(1);
                tvletterschecked.setText("checked letters are : ");
                et.setAlpha(1);
                tv9.setText("");
                b2.setEnabled(true);
                Random r = new Random();
                n= r.nextInt(20);
                et.setText("");
                tv.setText("your score :");
                tv1.setText("_");
                tv2.setText("_");
                tv3.setText("_");
                tv4.setText("_");
                tv5.setText("_");
                tv6.setText("_");
                tv7.setText("_");
                flag[0]=0;  flag[1]=0;  flag[2]=0;  flag[3]=0;  flag[4]=0;  flag[5]=0;  flag[6]=0;
                sum=0; pos=0; points=0;
                for(int z=0;z<26;z++)
                    a[z]=0;
                mediaPlayer.pause();
            }
        });
    }
}
