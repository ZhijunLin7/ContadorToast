package com.example.contadortoast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button_toast;
    private TextView show_count;
    private Button button_count;

    private int num=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_toast=(Button) findViewById(R.id.button_toast);
        show_count =(TextView) findViewById(R.id.show_count);
        button_count=(Button) findViewById(R.id.button_count);

        if (savedInstanceState != null) {
            num= savedInstanceState.getInt("num");
            show_count.setText(String.valueOf(num));
        }


        button_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Has hecho "+num+" click", Toast.LENGTH_SHORT).show();
            }
        });

        button_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num+=1;
                show_count.setText(String.valueOf(num));
            }
        });


    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putInt("num",num);
        super.onSaveInstanceState(savedInstanceState);
    }
}