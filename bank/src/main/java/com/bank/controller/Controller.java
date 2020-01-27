package com.bank.controller;

import com.bank.domain.User;
import com.bank.injector.ApplicationInjector;
import com.bank.service.UserService;
import com.bank.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class Controller {
    private View view;
    private UserService userService;
    private ResourceBundle bundle;
    private InputController inputController;

    public Controller(ApplicationInjector applicationInjector) {
        this.view = applicationInjector.getView();
        this.userService = applicationInjector.getUserService();
        bundle = ResourceBundle.getBundle("Menu");
        inputController = new InputController(view, bundle);
    }

    public void run() {
        appMenu();
    }

    private void appMenu() {
        boolean isExit = false;
        while (!isExit) {
            view.printMessage(bundle.getString("app_menu"));
            int key = inputController.getIntFromConsole(4);
            if (key == 1) {
                loginMenu();
            } else if (key == 2) {
                registerMenu();
            } else if (key == 3) {
                languageMenu();
            } else if (key == 4) {
                isExit = true;
            }
        }
    }

    private void loginMenu() {
        boolean isLoggedIn = false;
        while (!isLoggedIn) {
            view.printMessage(bundle.getString("email_prompt"));
            String email = inputController.getStringFromConsole();
            view.printMessage(bundle.getString("pass_prompt"));
            String password = inputController.getStringFromConsole();

            isLoggedIn = userService.login(email, password);
            if (!isLoggedIn) {
                view.printMessage(bundle.getString("login_fail"));
                String key = inputController.getStringFromConsole();
                if ("exit".equals(key)) {
                    return;
                }
            }
        }
        view.printMessage(bundle.getString("login_success"));
        loggedMainMenu();
    }

    private void loggedMainMenu() {
        boolean isExit = false;
        while (!isExit) {
            view.printMessage(bundle.getString("main_menu"));
            int key = inputController.getIntFromConsole(4);
            if (key == 1) {
                findAllUsersMenu();
            } else if (key == 2) {
                findByIdMenu();
            } else if (key == 3) {
                findByEmailMenu();
            } else if (key == 4) {
                isExit = true;
            }
        }
    }

    private void findAllUsersMenu() {
        view.printMessage(bundle.getString("page_number_prompt"));
        int pageNumber = inputController.getIntFromConsole();
        List<User> list = userService.findAll(pageNumber);
        String message = StringConverter.listToString(list);
        view.printMessage(message);
    }

    private void findByEmailMenu() {
        view.printMessage(bundle.getString("id_prompt"));
        String email = inputController.getStringFromConsole();
        User user = userService.findByEmail(email);
        view.printMessage(user.toString());
    }

    private void findByIdMenu() {
        view.printMessage(bundle.getString("id_prompt"));
        int id = inputController.getIntFromConsole();
        User user = userService.findById(id);
        view.printMessage(user.toString());
    }

    private void registerMenu() {
        view.printMessage(bundle.getString("email_prompt"));
        String email = inputController.getStringFromConsole();
        view.printMessage(bundle.getString("pass_prompt"));
        String password = inputController.getStringFromConsole();
        User user = User.builder()
                .withEmail(email)
                .withPassword(password)
                .withAccounts(new ArrayList<>())
                .build();
        userService.register(user);
        view.printMessage(bundle.getString("register_success"));
    }

    private void languageMenu() {
        view.printMessage(bundle.getString("language_menu"));

        int key = inputController.getIntFromConsole(4);
        if (key == 1) {
            bundle = ResourceBundle.getBundle("Menu", Locale.US);
        } else if (key == 2) {
            bundle = ResourceBundle.getBundle("Menu", new Locale("uk", "UA"));
        } else if (key == 3) {
            bundle = ResourceBundle.getBundle("Menu", new Locale("ru", "RU"));
        }
        inputController.setBundle(bundle);
    }
}