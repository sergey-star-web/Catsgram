//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ru.yandex.practicum.catsgram.model;

import java.time.Instant;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = { "email" })
public class User {
    Long id;
    String username;
    String email;
    String password;
    Instant registrationDate;

    public User() {
    }
}
