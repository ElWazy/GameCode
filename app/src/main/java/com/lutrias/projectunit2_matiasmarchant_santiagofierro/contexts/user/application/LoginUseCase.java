package com.lutrias.projectunit2_matiasmarchant_santiagofierro.contexts.user.application;

import com.lutrias.projectunit2_matiasmarchant_santiagofierro.contexts.user.domain.User;
import com.lutrias.projectunit2_matiasmarchant_santiagofierro.contexts.user.domain.UserName;
import com.lutrias.projectunit2_matiasmarchant_santiagofierro.contexts.user.domain.UserPassword;
import com.lutrias.projectunit2_matiasmarchant_santiagofierro.contexts.user.domain.UserRepository;

public final class LoginUseCase {
    private UserRepository repository;

    public LoginUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public User canLogin(UserName username, UserPassword password) {
        User logged = new User(username, password);

        User[] users = repository.getAll();

        for (User user : users) {
            if ( user.equals(logged) ) {
                return user;
            }
        }

        return null;
    }
}
