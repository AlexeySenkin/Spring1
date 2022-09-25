package ru.senkin.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import ru.senkin.model.User;
import org.springframework.data.domain.Pageable;


@Repository
public interface UserRepository extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User> {

   // Page<User> findAllByUsernameLike(String userNameFilter, Pageable pageable);

    @Query(value = """
            select u.* from  users u 
            where (:usernameFilter is null or u.username like :usernameFilter)
                and (:emailFilter is null or u.email like :emailFilter)
            """,
            countQuery = """
            select count(*) from users u
            where (:usernameFilter is null or u.username like :usernameFilter)
            and (:emailFilter is null or u.email like :emailFilter)
            """,
            nativeQuery = true)
    Page<User> usersByFilter(String usernameFilter, String emailFilter, Pageable pageable);


}
