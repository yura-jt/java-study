package com.bank.controller;


import com.bank.view.InputData;
import com.bank.view.View;

import java.util.ResourceBundle;

public class InputController {
    private View view;
    private ResourceBundle bundle;

    public InputController(View view, ResourceBundle bundle) {
        this.view = view;
        this.bundle = bundle;
    }

    public void setBundle(ResourceBundle bundle) {
        this.bundle = bundle;
    }

    public int getIntFromConsole(int upLimit) {
        boolean isOperationSuccessful = false;
        int number = 0;
        while (!isOperationSuccessful) {
            String str = InputData.input();
            if (str != null && str.equalsIgnoreCase("back")) {
                return -1;
            }

            if (Validator.isValidIntForMenu(str, upLimit)) {
                number = Integer.parseInt(str);
                isOperationSuccessful = true;
            } else {
                view.printMessage(bundle.getString("int_not_valid"));
            }
        }
        return number;
    }

    public int getIntFromConsole() {
        String str = InputData.input();
        return Integer.parseInt(str);
    }

    public String getStringFromConsole() {
        boolean isOperationSuccessful = false;
        String str = "";
        while (!isOperationSuccessful) {
            str = InputData.input();
            if (str != null && str.equalsIgnoreCase("back")) {
                return "";
            }

            if (Validator.isValidString(str)) {
                isOperationSuccessful = true;
            } else {
                view.printMessage(bundle.getString("string_not_valid"));
            }
        }
        return str.trim();
    }
}
