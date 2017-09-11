package com.hw.fe2.ui;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import lombok.val;


@SpringUI(path = "/login")
public class Login extends UI {

    private TextField user;
    private PasswordField password;
    @Override
    protected void init(VaadinRequest request) {
        val window = new Window("Login");
        window.center();
        window.setModal(true);
        window.setClosable(false);
        window.setResizable(false);
        addWindow(window);

        user = new TextField("User");
        user.setIcon(VaadinIcons.USER);
        user.focus();
        val form = new FormLayout();
        form.setMargin(true);
        form.setSizeUndefined();
        form.addComponent(user);

        password = new PasswordField("Password");
        password.setIcon(VaadinIcons.PASSWORD);
        form.addComponent(password);

        val loginBtn = new Button("Login");
        loginBtn.addClickListener(event -> doLogin(getSession(), getNavigator()));
        form.addComponent(loginBtn);
        window.setContent(form);
    }

    private void doLogin(VaadinSession session, Navigator navigator) {
        Notification.show("Logging in", Notification.Type.HUMANIZED_MESSAGE);
        session.setAttribute("user", user.getValue());
        session.setAttribute("password", password.getValue());

        navigator.navigateTo("");
    }
}
