package io.github.grihithreddy.onlinecoursemanagement.user.repository;

import io.github.grihithreddy.onlinecoursemanagement.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for performing CRUD operations on the User entity.
 * Extends JpaRepository to provide built-in methods for data persistence.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Retrieves a user by their unique ID.
     *
     * @param id the ID of the user
     * @return an Optional containing the user if found, otherwise empty
     */
    Optional<User> findById(int id);

    /**
     * Retrieves a list of users with a matching username.
     *
     * @param username the username to search for
     * @return a list of users with the exact username
     */
    List<User> findByUsername(String username);

    /**
     * Retrieves a list of users whose username contains the given text.
     *
     * @param username the text to search for in the username
     * @return a list of users whose usernames contain the given text
     */
    List<User> findByUsernameContaining(String username);

    /**
     * Retrieves a list of users whose age falls within the specified range.
     * The results are ordered by age in ascending order.
     *
     * @param startId the start of the age range
     * @param endId the end of the age range
     * @return a list of users within the specified age range
     */
    @Query("SELECT u FROM User u WHERE u.id BETWEEN ?1 AND ?2 ORDER BY u.id ASC")
    List<User> findByIdBetween(int startId, int endId);

    int id(int id);
}
