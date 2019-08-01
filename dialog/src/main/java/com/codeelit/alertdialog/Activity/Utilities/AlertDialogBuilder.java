package com.codeelit.alertdialog.Activity.Utilities;

import android.content.Context;
import android.graphics.Typeface;

import com.codeelit.alertdialog.Activity.Activity.AlertDialog;
import com.codeelit.alertdialog.Activity.ListenerCallBack.DialogClickListener;

public class AlertDialogBuilder {

    private Typeface titleTf, subTitleTf;
    private boolean isCancelable;
    private String title, subtitle, okButtonLabel, cancelButtonLabel;
    private Context context;
    private DialogClickListener okListener;
    private DialogClickListener cancelListener;
    private boolean isNegativeBtnHide;

    public AlertDialogBuilder(Context context) {
        this.context = context;
    }

    public AlertDialogBuilder setTitle(String title){
        this.title = title;
        return this;
    }

    public AlertDialogBuilder setSubtitle(String subTitle){
        this.subtitle = subTitle;
        return this;
    }

    public AlertDialogBuilder setTitleFont(Typeface titlefont){
        this.titleTf = titlefont;
        return this;
    }

    public AlertDialogBuilder setSubTitleFont(Typeface subTFont){
        this.subTitleTf = subTFont ;
        return this;
    }

    public AlertDialogBuilder setPositiveButton(String label, DialogClickListener listener){
        this.okListener = listener;
        this.okButtonLabel = label;
        return this;
    }

    public AlertDialogBuilder setNegativeButton(String label, DialogClickListener listener){
        this.cancelListener = listener;
        this.cancelButtonLabel = label;
        return this;
    }

    public AlertDialogBuilder setCancelable(boolean isCancelable){
        this.isCancelable = isCancelable;
        return this;
    }

    public AlertDialogBuilder setNegativeButtonHide(boolean isHide){
        this.isNegativeBtnHide = isHide;
        return this;
    }

    public AlertDialog build(){
        AlertDialog dialog = new AlertDialog(context, title, subtitle, titleTf, subTitleTf, isCancelable, isNegativeBtnHide);
        dialog.setNegative(cancelButtonLabel,cancelListener);
        dialog.setNegative(okButtonLabel,okListener);
        return dialog;
    }
}
