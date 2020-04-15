package com.example.dialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyDialog extends DialogFragment {

    private MyDialogEventListener eventListener;

    @Override
    public void onAttach(@NonNull Context context) {
        eventListener = (MyDialogEventListener) context;
        super.onAttach(context);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.my_dialog, null, false);
        builder.setView(view);

        Button okBtn = view.findViewById(R.id.btn_ok);
        Button cancelBtn = view.findViewById(R.id.btn_cancel);
        final EditText editText = view.findViewById(R.id.et_enter);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventListener.onOkButtonClicked(editText.getText().toString());
                dismiss();
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventListener.onCancelButtonClicked();
                dismiss();
            }
        });
        return builder.create();
    }


    public interface MyDialogEventListener {
        void onOkButtonClicked(String data);

        void onCancelButtonClicked();
    }
}
