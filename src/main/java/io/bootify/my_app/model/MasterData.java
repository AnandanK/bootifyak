package io.bootify.my_app.model;

import jakarta.validation.constraints.Size;


public class MasterData {

    @Size(max = 255)
    private String forUser;

    public String getForUser() {
        return forUser;
    }

    public void setForUser(final String forUser) {
        this.forUser = forUser;
    }

}
