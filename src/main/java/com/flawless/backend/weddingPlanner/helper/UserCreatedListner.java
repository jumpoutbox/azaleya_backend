package com.flawless.backend.weddingPlanner.helper;

import com.flawless.backend.weddingPlanner.entites.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserCreatedListner {

    //TODO Fazer os métodos e queries que vão preencher a tabela do novo usuário
    /*
        1. Fazer as queries que vão preencher essas tabelas
        2. Fazer o método para preencher essas tabelas
     */

    @EventListener
    public void handleUserCreatedEvent(UserCreatedEvent event) {
        Users users = event.getUser();

        System.out.println("Funcionou!");
    }
}
