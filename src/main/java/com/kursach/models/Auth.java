package com.kursach.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


@Getter
@Setter
@Builder
@EqualsAndHashCode
public class Auth {
    Integer userId;
    String auth;
}
