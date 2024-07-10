package com.flawless.backend.weddingPlanner.helper;


import com.flawless.backend.weddingPlanner.entites.Users;
import org.springframework.context.ApplicationEvent;

public class UserCreatedEvent extends ApplicationEvent {
    private Users users;

    public UserCreatedEvent(Object source, Users users) {
        super(source);
        this.users = users;
    }

    public Users getUser() {
        return users;
    }
}
