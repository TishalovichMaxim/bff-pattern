package by.tishalovichm.organization.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends Exception {

    private final String field;

    private final Object value;

    public ResourceNotFoundException(String field, Object value) {
        this.field = field;
        this.value = value;
    }

    public ResourceNotFoundException(Object value) {
        field = "id";
        this.value = value;
    }

}
