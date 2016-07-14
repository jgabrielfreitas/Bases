package com.jgabrielfreitas.core.activity;

import android.app.ProgressDialog;


/**
 * Created by JGabrielFreitas on 13/07/16.
 */
public abstract class BaseWithDialogActivity extends BaseActivity {

    private ProgressDialog progressDialog;
    protected String progressDialogMessage;

    public void showProgress() {
        showProgress(progressDialogMessage);
    }

    public void showProgress(String message) {

        if (progressDialog == null)
            progressDialog = ProgressDialog.show(this, "", message, false, false);
    }

    public void dismissDialog() {

        if (progressDialog != null && progressDialog.isShowing()) {

            progressDialog.dismiss();
        }
    }

}
