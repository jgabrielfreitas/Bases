package com.jgabrielfreitas.core.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;

import com.jgabrielfreitas.core.fragment.BaseFragment;
import com.jgabrielfreitas.core.util.LogUtil;
import com.jgabrielfreitas.core.util.Util;

/**
 * Created by JGabrielFreitas on 13/07/16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected int containerId = 0; // ID from fragments container
    private String TAG = getClass().getSimpleName();
    protected boolean animationOnIntent = true; // to do the "flip" animation between activities on intent
    protected boolean animationBack = true; // to do the "flip" animation between activities on back pressed
    public int animIn = android.R.anim.slide_out_right;
    public int animOut = android.R.anim.slide_in_left;
    protected boolean killAfterIntent = true;
    protected Parcelable parcelableObject;
    private boolean isButterKnifeBinded = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getIntent().getExtras() != null)
            parcelableObject = getIntent().getExtras().getParcelable(Util.PARCELABLE);
    }

    protected void onStart() {
        super.onStart();
        modifyViews();
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {

        try {
            super.onSaveInstanceState(outState);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    protected void modifyViews() {}

    public void doIntent(Class<?> classToIntent) {

        intentAndKill(classToIntent, null, 0);
    }

    public void doIntent(Class<?> classToIntent, Parcelable parcelable) {

        intentAndKill(classToIntent, parcelable, 0);
    }

    public void doIntentWithRequest(Class<?> classToIntent, Parcelable parcelable, int requestCode) {

        intentAndKill(classToIntent, parcelable, requestCode);
    }

    private void intentAndKill(Class<?> classToIntent, Parcelable parcelable, int requestCode) {

        closeKeyboard();

        Intent intent = new Intent(this, classToIntent);

        if (parcelable != null)
            intent.putExtra(Util.PARCELABLE, parcelable);

        if (requestCode == 0)
            startActivity(intent);
        else
            startActivityForResult(intent, requestCode);

        if (animationOnIntent)
            overridePendingTransition(animOut, animIn);

        if (killAfterIntent)
            killThisActivity();
    }

    protected void finishResult(String extraKey, Parcelable parcelable) {

        Intent returnIntent = new Intent();
        returnIntent.putExtra(extraKey, parcelable);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }

    public void closeKeyboard() {
        if (getCurrentFocus() != null && getCurrentFocus().getWindowToken() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    public void onClick(View v) {}

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {}

    public void onBackPressed() {

        // back activity
        // (if has no fragment in stack)
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
            if (animationBack)
                overridePendingTransition(animOut, animIn);
        } else
            getSupportFragmentManager().popBackStack();
    }

    public void replaceFragment(BaseFragment fragmentToReplace) {
        loge("Replacing: " + fragmentToReplace.getClass().getSimpleName());
        getSupportFragmentManager().beginTransaction().replace(containerId, fragmentToReplace).commit();
    }

    public void addFragmentAtStack(BaseFragment fragmentToAdd) {
        loge("Adding: " + fragmentToAdd.getClass().getSimpleName());
        getSupportFragmentManager().beginTransaction().replace(containerId, fragmentToAdd).addToBackStack(null).commit();
    }

    protected void killThisActivity() {
        finish();
    }

    public void loge(String toLog) {
        Log.e(TAG, ">>> " + toLog);
    }

    public void logi(String toLog) {
        Log.i(TAG, ">>> " + toLog);
    }

    protected void configToolbarBackButton(Toolbar toolbar) {

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void catchDefaultException(Throwable e) {

        try {

            LogUtil.logException(e);

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

}
