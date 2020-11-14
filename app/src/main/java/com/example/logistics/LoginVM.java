package com.example.logistics;

import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableField;

public class LoginVM extends BaseObservable {
    public final ObservableField<String> name;

    public LoginVM(ObservableField<String> name) {
        this.name = name;
    }
    public ObservableField<String> getName(){
        return name;
    }

}
