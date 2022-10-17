package com.example.emailapp.repo;

import com.example.emailapp.model.Mail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MailRepository extends MongoRepository<Mail, String> {
    List<Mail> findByTo(String email);

    List<Mail> findByFrom(String email);
}
