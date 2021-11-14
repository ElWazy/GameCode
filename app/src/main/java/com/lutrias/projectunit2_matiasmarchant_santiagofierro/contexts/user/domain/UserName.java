package com.lutrias.projectunit2_matiasmarchant_santiagofierro.contexts.user.domain;

import com.lutrias.projectunit2_matiasmarchant_santiagofierro.contexts.share.domain.StringValueObject;

public final class UserName extends StringValueObject {
    public UserName(String value) throws Exception {
        super(value);
        isEmpty(value);
        toShort(value);
    }

    private void isEmpty(String value) throws Exception {
        if ( value.isEmpty() ) {
            throw new Exception("El nombre de usuario está vacio");
        }
    }

    private void toShort(String value) throws Exception {
        if (value.length() < 3) {
            throw new Exception("El nombre es demasiado corto");
        }
    }
}
