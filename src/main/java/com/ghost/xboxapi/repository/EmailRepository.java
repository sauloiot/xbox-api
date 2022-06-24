package com.ghost.xboxapi.repository;

import com.ghost.xboxapi.models.Email;
import com.ghost.xboxapi.models.enums.StatusEmailEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmailRepository extends JpaRepository<Email, Long> {

    @Query("select email from Email email where email.statusEmail = :statusEmailEnum order by email.createdAt asc")
    List<Email> findEmailByStatusEmail(StatusEmailEnum statusEmailEnum);

}
