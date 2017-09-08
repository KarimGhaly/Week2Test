package com.example.admin.week2test;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView1);
        List<Integer> Numbers = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            Numbers.add(r.nextInt());
        }
        int Sum = AddOdds(Numbers);
        Toast.makeText(this, ""+Sum, Toast.LENGTH_SHORT).show();

        boolean email = CheckEmail("k@5w55.cc.cc");
        Toast.makeText(this, String.valueOf(email), Toast.LENGTH_SHORT).show();

        SingletonClass sc = SingletonClass.getInstance();
    }

    public void GenerateRandomNumber(View view) {
        Handler handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                textView.setText(msg.getData().getString("RNDKEY"));
                return false;
            }
        });
        RandomGenerator randomGenerator = new RandomGenerator(handler);
        randomGenerator.start();
    }
    public int AddOdds(List<Integer> list)
    {
        int sum = 0;
        for(int n :list)
        {
            if(n%2 == 1)
            {
                sum+=n;
            }
        }
        return sum;
    }

    public boolean CheckEmail(String email)
    {
        boolean status = false;
        if(email.indexOf('@') >0 && email.indexOf('@') == email.lastIndexOf('@') && email.indexOf('.')>2 && email.lastIndexOf('.') < email.length()-1  && email.indexOf(" ")<0) {
            int dotindex = email.indexOf('.');
            String sub = email.substring(dotindex).replace(".","");
            if(sub.matches("^[a-zA-Z ]+$")) {
                status = true;
            }
        }
        return status;
    }
}
