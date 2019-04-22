package com.kursach.services;

import com.kursach.models.Auth;
import com.kursach.repositories.AuthRepository;

public class AuthServiceImpl implements AuthService {

    private AuthRepository authRepository;

    public AuthServiceImpl(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public boolean isExistByCookie(Auth auth) {
        Auth a = authRepository.read(auth.getUserId());
        return auth.equals(a);
    }

    public void delete(Integer vkId){
        authRepository.delete(vkId);
    }
}
