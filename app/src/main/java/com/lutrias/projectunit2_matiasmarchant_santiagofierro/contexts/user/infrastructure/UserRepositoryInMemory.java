package com.lutrias.projectunit2_matiasmarchant_santiagofierro.contexts.user.infrastructure;

import com.lutrias.projectunit2_matiasmarchant_santiagofierro.contexts.user.domain.User;
import com.lutrias.projectunit2_matiasmarchant_santiagofierro.contexts.user.domain.UserName;
import com.lutrias.projectunit2_matiasmarchant_santiagofierro.contexts.user.domain.UserPassword;
import com.lutrias.projectunit2_matiasmarchant_santiagofierro.contexts.user.domain.UserRepository;

public final class UserRepositoryInMemory implements UserRepository {
    private final int AMOUNT = 3;

    private String[] names;
    private String[] passwords;
    private User[] users;


    public UserRepositoryInMemory() throws Exception {
        names = new String[] {"admin", "Santiago", "Matias"};
        passwords = new String[] {"admin", "1324", "1234"};
        users = new User[AMOUNT];

        for (int i = 0; i < AMOUNT; i++) {
            users[i] = new User(
                new UserName(names[i]),
                new UserPassword(passwords[i])
            );
        }
    }

    @Override
    public User[] getAll() {
        return users;
    }
}
