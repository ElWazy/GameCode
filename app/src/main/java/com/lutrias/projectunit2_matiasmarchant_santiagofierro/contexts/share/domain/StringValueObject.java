package com.lutrias.projectunit2_matiasmarchant_santiagofierro.contexts.share.domain;

public abstract class StringValueObject {
    protected String value;

    public StringValueObject(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StringValueObject)) return false;

        StringValueObject that = (StringValueObject) o;

        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
