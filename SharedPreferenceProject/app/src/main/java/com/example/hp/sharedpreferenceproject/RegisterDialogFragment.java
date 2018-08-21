package com.example.hp.sharedpreferenceproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Objects;

public class RegisterDialogFragment extends DialogFragment {

    private EditText textName;
    private EditText textSurname;
    private ImageButton imageButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_style, container, false);
        findViews(view);
        setListeners();
        return view;
    }

    private void findViews(View view) {
        textName = view.findViewById(R.id.add_name);
        textSurname = view.findViewById(R.id.add_surname);
        imageButton = view.findViewById(R.id.add_user);
    }

    private void setListeners() {
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserModel userModel = new UserModel(textName.getText().toString(), textSurname.getText().toString());
                ((MainActivity) Objects.requireNonNull(getActivity())).getList().add(userModel);
                dismiss();
            }
        });
    }

}
