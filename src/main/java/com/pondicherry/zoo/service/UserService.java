package com.pondicherry.zoo.service;

import com.pondicherry.zoo.domain.Sex;
import com.pondicherry.zoo.domain.User;
import org.joda.time.LocalDate;

import java.util.Date;

/**
 * A service for administering {@link com.pondicherry.zoo.domain.User users}.
 */
public interface UserService {

    /**
     * Register a new user. The user data must already have been validated as this service does not
     * provide any validation capability. The newly created user will have been assigned a userId.
     *
     * @param username the username
     * @param password the password
     * @param sex      the sex
     * @param dob      the date of birth
     * @param postcode postcode
     * @return the newly created user
     */
    User register(String username, String password, Sex sex, Date dob, String postcode);

    /**
     * Validate the username.
     *
     * @param userName the username to validate
     * @throws IllegalArgumentException if the username is null or empty
     */
    default void validateName(String userName) {
        if (userName == null || userName.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
    }

    /**
     * Authenticate a user's credentials.
     *
     * @param username the username
     * @param password the password
     * @return true if the credentials are valid, otherwise false
     */
    boolean authenticate(String username, String password);

    /**
     * Does a user with the given username exist on the database.
     *
     * @param username the username
     * @return true if a user with this username already exists, otherwise false
     */
    boolean exists(String username);
}
