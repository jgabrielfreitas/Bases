package com.jgabrielfreitas.core.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;

import com.jgabrielfreitas.core.activity.BaseActivity;
import com.jgabrielfreitas.layoutid.fragments.InjectLayoutBaseFragment;

import butterknife.ButterKnife;

/**
 * Created by JGabrielFreitas on 13/07/16.
 */
public abstract class BaseFragment extends InjectLayoutBaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    BaseActivity flipBaseActivity;

    public BaseFragment() {}

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        flipBaseActivity = (BaseActivity) getActivity();
    }

    public void onStart() {
        super.onStart();

        ButterKnife.bind(this, getView());
        modifyViews();
    }

    public void onStop() {
        super.onStop();

        ButterKnife.unbind(this);
    }

    protected void modifyViews() {}

    public BaseActivity getFlipBaseActivity() {
        return flipBaseActivity;
    }

    protected void catchDefaultException(Exception e) {

        getFlipBaseActivity().catchDefaultException(e);
    }

    public void closeKeyboard() {
        if (getActivity().getCurrentFocus() != null && getActivity().getCurrentFocus().getWindowToken() != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
        }
    }


    public void onClick(View v) {
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

}
