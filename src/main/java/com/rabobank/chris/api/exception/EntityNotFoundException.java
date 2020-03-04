package com.rabobank.chris.api.exception;

import lombok.Getter;

public class EntityNotFoundException extends RuntimeException {

    @Getter
    private final Object id;

    @Getter
    private final Class cls;

    public EntityNotFoundException(Object id, Class cls) {
        super(String.format("Entity %s not found", id));
        this.id = id;
        this.cls = cls;
    }
}
