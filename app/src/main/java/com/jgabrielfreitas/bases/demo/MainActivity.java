package com.jgabrielfreitas.bases.demo;

import android.widget.EditText;
import android.widget.Toast;

import com.jgabrielfreitas.core.activity.BaseWithDialogActivity;
import com.jgabrielfreitas.layoutid.annotations.InjectLayout;

import butterknife.Bind;
import butterknife.OnClick;


@InjectLayout(layout = R.layout.activity_main)
public class MainActivity extends BaseWithDialogActivity {

    @Bind(R.id.writeSomethingEditText) EditText writeSomethingEditText;

    @OnClick(R.id.showMessageButton)
    public void showMessage() {
        Toast.makeText(MainActivity.this, writeSomethingEditText.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
