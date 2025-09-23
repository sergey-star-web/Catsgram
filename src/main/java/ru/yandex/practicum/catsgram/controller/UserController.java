package ru.yandex.practicum.catsgram.controller;

import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.exception.ConditionsNotMetException;
import ru.yandex.practicum.catsgram.exception.DuplicatedDataException;
import ru.yandex.practicum.catsgram.model.User;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private Map<Long, User> users = new HashMap<>();

    @GetMapping
    public List<User> getUsers() {
        // Здесь должен быть код для получения списка пользователей
        return new ArrayList<>(users.values()); // Замените на реальный код
    }

    private Long getNextId() {
        return users.keySet().stream().max(Long::compare).orElse(0L) + 1;
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        if (user.getEmail() == null) {
            throw new ConditionsNotMetException("Имейл должен быть указан");
        }
        if (users.values().stream().anyMatch(u -> u.getEmail().equals(user.getEmail()))) {
            throw new DuplicatedDataException("Этот имейл уже используется");
        }
        Long id = getNextId();
        user.setId(id);
        user.setRegistrationDate(new Date().toInstant());
        users.put(id, user);
    }

    @PutMapping
    public void updateUser(@RequestBody User user) {
        if (user.getId() == null) {
            throw new ConditionsNotMetException("Id должен быть указан");
        }
        User existingUser = users.get(user.getId());
        if (existingUser == null) {
            throw new RuntimeException("Пользователь не найден");
        }
        if (user.getEmail() != null) {
            if (users.values().stream().anyMatch(u -> u.getEmail().equals(user.getEmail()) && !u.getId().equals(user.getId()))) {
                throw new DuplicatedDataException("Этот имейл уже используется");
            }
            existingUser.setEmail(user.getEmail());
        }
        if (user.getUsername() != null) {
            existingUser.setUsername(user.getUsername());
        }
        if (user.getPassword() != null) {
            existingUser.setPassword(user.getPassword());
        }
    }
}
