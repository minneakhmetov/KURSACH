/*
 * Developed by Razil Minneakhmetov on 10/24/18 9:52 PM.
 * Last modified 10/24/18 9:52 PM.
 * Copyright © 2018. All rights reserved.
 */

package com.kursach.models;

import lombok.*;

@Getter
@Setter
@Builder
@Data
@EqualsAndHashCode
public class User {
    String name;
    String surname;
    String photoURL;
    Integer vkId;
}