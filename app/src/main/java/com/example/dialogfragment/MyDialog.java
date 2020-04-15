package com.example.dialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class MyDialog extends BottomSheetDialogFragment {

    private MyDialogEventListener eventListener;

    @Override
    public void onAttach(@NonNull Context context) {
        eventListener = (MyDialogEventListener) context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.my_dialog, null, false);


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


        return view;
    }

    public interface MyDialogEventListener {
        void onOkButtonClicked(String data);

        void onCancelButtonClicked();
    }
}
