package ru.yandex.practicum.catsgram.service;

import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.dal.UserRepository;
import ru.yandex.practicum.catsgram.dto.UserDto;
import ru.yandex.practicum.catsgram.exception.ConditionsNotMetException;
import ru.yandex.practicum.catsgram.exception.DuplicatedDataException;
import ru.yandex.practicum.catsgram.mapper.UserMapper;
import ru.yandex.practicum.catsgram.model.User;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {
    private Map<Long, User> users = new HashMap<>();
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    private Long getNextId() {
        return users.keySet().stream().max(Long::compare).orElse(0L) + 1;
    }

    public User addUser(User user) {
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
        return user;
    }

    public User updateUser(User user) {
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
        return user;
    }

    public Optional<User> findById(long authorId) {
        return Optional.ofNullable(users.get(authorId));
    }
}
