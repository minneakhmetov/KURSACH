package com.kursach.services;

import com.kursach.models.Auth;

public interface AuthService extends Service {
    boolean isExistByCookie(Auth auth);
    void delete(Auth auth);
}
