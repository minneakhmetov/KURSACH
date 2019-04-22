package com.kursach.repositories;

import com.kursach.models.Auth;

public interface AuthRepository {
    void save(Auth auth);
    void delete(Integer vkId);
    Auth read(Integer vkId);


}
