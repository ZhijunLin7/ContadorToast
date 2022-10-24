# Layouts

<details>
<summary>Codigo java</summary>
<br>
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
</details>


## Codigo de xml LinearLayout
<details>
<summary>LinearLayout</summary>
<br>
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:gravity="center"
    android:orientation="vertical">


    <Button
        android:id="@+id/button_toast"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Toast"
        />

    <TextView
        android:id="@+id/show_count"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:background="@color/yellow"
        android:textColor="@color/design_default_color_primary_dark"
        android:text="0"
        android:textSize="160sp"
        android:layout_weight="2"/>

    <Button
        android:id="@+id/button_count"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Count"
        />

</LinearLayout>
</details>

![](https://github.com/ZhijunLin7/ContadorToast/blob/master/Camera%20Roll/1.1.PNG)

## Codigo de xml RelativeLayout
<details>
<summary>RelativeLayout</summary>
<br>
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:gravity="center"
    android:orientation="vertical">


    <Button
        android:id="@+id/button_toast"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"
        android:text="Toast" />

    <Button
        android:id="@+id/button_count"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"
        android:layout_below="@+id/button_toast"
        android:layout_alignParentLeft="true"
        android:layout_alignParentStart="true"
        android:text="Count"/>

    <TextView
        android:id="@+id/show_count"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"
        android:background="@color/yellow"
        android:gravity="center"
        android:text="0"
        android:textColor="@color/design_default_color_primary"
        android:textSize="160sp"
        android:textStyle="bold"
        android:layout_alignParentTop="true"
        android:layout_toRightOf="@+id/button_toast"
        android:layout_toEndOf="@+id/button_toast" />


</RelativeLayout>
</details>

![](https://github.com/ZhijunLin7/ContadorToast/blob/master/Camera%20Roll/1.2.PNG)

## Codigo de xml ConstraintLayout
<details>
<summary>ConstraintLayout</summary>
<br>
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/linearLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    tools:context=".MainActivity">


    <Button
        android:id="@+id/button_toast"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="16dp"
        android:layout_marginTop="16dp"
        android:text="Toast"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/show_count"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginLeft="8dp"
        android:layout_marginTop="16dp"
        android:layout_marginRight="16dp"
        android:background="@color/yellow"
        android:gravity="center"
        android:text="0"
        android:textSize="160sp"
        android:textStyle="bold"
        app:layout_constraintLeft_toRightOf="@+id/button_count"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />


    <Button
        android:id="@+id/button_count"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="16dp"
        android:text="Count"
        android:textColor="@android:color/white"
        app:layout_constraintBaseline_toBaselineOf="@+id/show_count"
        app:layout_constraintLeft_toLeftOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
</details>

![](https://github.com/ZhijunLin7/ContadorToast/blob/master/Camera%20Roll/1.3.PNG)


