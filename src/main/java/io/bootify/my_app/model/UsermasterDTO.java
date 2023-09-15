package io.bootify.my_app.model;

import jakarta.validation.constraints.Size;


public class UsermasterDTO {

    private Long id;

    @Size(max = 255)
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

}
