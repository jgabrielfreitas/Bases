package com.jgabrielfreitas.core.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;

import com.jgabrielfreitas.core.activity.BaseActivity;

/**
 * Created by JGabrielFreitas on 13/07/16.
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    BaseActivity flipBaseActivity;

    public BaseFragment() {}

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        flipBaseActivity = (BaseActivity) getActivity();
    }

    public void onStart() {
        super.onStart();

        modifyViews();
    }

    protected void modifyViews() {}

    public BaseActivity getFlipBaseActivity() {
        return flipBaseActivity;
    }

    protected void catchDefaultException(Exception e) {

        getFlipBaseActivity().catchDefaultException(e);
    }

//    protected void showProgress() {
//
//        getFlipBaseActivity().showProgress();
//    }
//
//    protected void removeProgress() {
//
//        getFlipBaseActivity().removeProgress();
//    }

    public <T extends View> T findView(int viewId) {
        return (T) flipBaseActivity.findViewById(viewId);
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
