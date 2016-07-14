package com.jgabrielfreitas.bases.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById EditText writeSomethingEditText;

    @Click(R.id.showMessageButton)
    public void showMessage() {
        Toast.makeText(MainActivity.this, writeSomethingEditText.getText().toString(), Toast.LENGTH_SHORT).show();
    }

}
