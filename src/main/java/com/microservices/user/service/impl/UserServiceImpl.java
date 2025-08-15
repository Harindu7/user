package com.microservices.user.service.impl;

import com.microservices.user.model.dto.UserDTO;
import com.microservices.user.model.entity.User;
import com.microservices.user.repository.UserRepository;
import com.microservices.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final WebClient companyServiceWebClient;


    private void validateCompanyId(String companyId) {
        log.info("Validating company ID: {}", companyId);
        boolean companyExists = companyServiceWebClient.get()
                .uri("/api/companies/" + companyId)
                .retrieve()
                .toBodilessEntity()
                .map(response -> response.getStatusCode().equals(HttpStatus.OK))
                .onErrorReturn(false)
                .block();

        if (!companyExists) {
            log.error("Company with ID {} not found", companyId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found");
        }
        log.debug("Company validation successful for ID: {}", companyId);
    }

    @Override
    public User createUser(UserDTO userDTO) {
        log.info("Creating new user with company ID: {}", userDTO.getCompanyId());
        validateCompanyId(userDTO.getCompanyId());

        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        User savedUser = userRepository.save(user);
        log.info("Successfully created user with ID: {}", savedUser.getId());
        return savedUser;
    }

    @Override
    public User updateUser(String id, UserDTO userDTO) {
        log.info("Updating user with ID: {}", id);
        validateCompanyId(userDTO.getCompanyId());

        User existingUser = userRepository.findById(id)
            .orElseThrow(() -> {
                log.error("User not found with ID: {}", id);
                return new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
            });

        BeanUtils.copyProperties(userDTO, existingUser, "id", "createdAt", "active");
        User updatedUser = userRepository.save(existingUser);
        log.info("Successfully updated user with ID: {}", id);
        return updatedUser;
    }

    @Override
    public List<User> getAllUsers() {
        log.info("Fetching all users");
        List<User> users = userRepository.findAll();
        log.debug("Retrieved {} users from database", users.size());
        return users;
    }

    @Override
    public User deactivateUser(String id) {
        log.info("Deactivating user with ID: {}", id);
        User user = userRepository.findById(id)
            .orElseThrow(() -> {
                log.error("User not found with ID: {}", id);
                return new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
            });

        user.setActive(false);
        User deactivatedUser = userRepository.save(user);
        log.info("Successfully deactivated user with ID: {}", id);
        return deactivatedUser;
    }

    @Override
    public User getUserById(String id) {
        log.info("Fetching user with ID: {}", id);
        return userRepository.findById(id)
            .orElseThrow(() -> {
                log.error("User not found with ID: {}", id);
                return new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
            });
    }
}
