package com.codeelit.alertdialog.Activity.Activity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.codeelit.alertdialog.Activity.ListenerCallBack.DialogClickListener;
import com.codeelit.alertdialog.R;

public class AlertDialog {
    private Dialog dialog;
    private TextView titleTV, subTitleTv, tvOk, tvCancel;
    private LinearLayout okButtonTv, cancelButtonTV;

    private DialogClickListener okButtonClickListener;
    private DialogClickListener cancelButtonClickListener;
    private boolean isNegativeBtnHide;

    public AlertDialog(Context context, String title, String subTitle, Typeface titlefont,
                       Typeface subtitleFont, boolean isCancelable, boolean isNegativeBtnHide) {

        this.isNegativeBtnHide = isNegativeBtnHide;
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_main);
        dialog.setCancelable(isCancelable);

        if (dialog.getWindow() != null)
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        initDialogView();
        setTitle(title);
        setSubtitle(subTitle);
        setSubTitleFont(subtitleFont);
        setTitleFont(titlefont);
        initClickEvents();
    }

    public void setPositive(String okLabel, DialogClickListener listener) {
        this.okButtonClickListener = listener;
        this.dismiss();
        setPositiveLabel(okLabel);
    }

    private void setPositiveLabel(String positive){
        tvOk.setText(positive);
    }

    public void setNegative(String cancelLabel, DialogClickListener listener){
        if (listener != null){
            this.cancelButtonClickListener = listener;
            this.dismiss();
            setNegativeLabel((cancelLabel));
        }
    }

    public void dismiss(){
        dialog.dismiss();
    }

    private void setNegativeLabel(String negative){
        tvCancel.setText(negative);
    }

    public void show()
    {
        if (isNegativeBtnHide){
            cancelButtonTV.setVisibility(View.GONE);
        }
        dialog.show();
    }
    private void initClickEvents() {
        okButtonTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (okButtonClickListener != null){
                    okButtonClickListener.onClick(AlertDialog.this);
                }

            }
        });
        cancelButtonTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cancelButtonClickListener != null){
                    cancelButtonClickListener.onClick(AlertDialog.this);
                }
            }
        });
    }

    private void setTitleFont(Typeface appleFont) {
        if (appleFont != null){
            titleTV.setTypeface(appleFont);
        }
    }

    private void setSubTitleFont(Typeface appleFont) {
        if (appleFont != null){
            subTitleTv.setTypeface(appleFont);
            tvOk.setTypeface(appleFont);
            tvCancel.setTypeface(appleFont);
        }
    }


   public void setSubtitle(String subtitle){
        subTitleTv.setText(subtitle);
   }


    public void setTitle(String title) {
        titleTV.setText(title);
    }

    private void initDialogView() {
        titleTV = dialog.findViewById(R.id.tv1);
        subTitleTv = dialog.findViewById(R.id.tv2);
        okButtonTv = dialog.findViewById(R.id.btnDialogOk);
        cancelButtonTV = dialog.findViewById(R.id.btnDialogCancel);
        tvOk = dialog.findViewById(R.id.tvok);
        tvCancel = dialog.findViewById(R.id.tvCan);
    }
}
