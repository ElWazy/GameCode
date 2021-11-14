package com.lutrias.projectunit2_matiasmarchant_santiagofierro.contexts.share.domain;

public abstract class IntegerValueObject {
    protected int value;

    public IntegerValueObject(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntegerValueObject)) return false;

        IntegerValueObject that = (IntegerValueObject) o;

        return value == that.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
