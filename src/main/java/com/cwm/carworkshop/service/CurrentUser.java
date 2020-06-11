package com.cwm.carworkshop.service;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
public class CurrentUser extends User {
    private final com.cwm.carworkshop.model.User user;
    public CurrentUser(String username, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       com.cwm.carworkshop.model.User user) {
        super(username, password, authorities);
        this.user = user;
    }
    public com.cwm.carworkshop.model.User getUser() {return user;}
}