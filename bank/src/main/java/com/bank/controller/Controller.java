package com.bank.controller;

import com.bank.injector.ApplicationInjector;
import com.bank.service.UserService;
import com.bank.view.View;

public class Controller {
    private View view;
    private UserService userService;

    public Controller(ApplicationInjector applicationInjector) {
        this.view = applicationInjector.getView();
        this.userService = applicationInjector.getUserService();
    }

    public void run() {

    }
}
