package ru.specialist.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component("userVM")
public class UserVM {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHello(){
        return (getUserName() == null || getUserName().isEmpty())? "Привет!" :
                String.format("Привет, %s!", getUserName());
    }
}

