package com.example.emailapp.service;

import com.example.emailapp.model.Mail;
import com.example.emailapp.model.MailStatus;
import com.example.emailapp.repo.MailRepository;
import com.example.emailapp.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MailService {
    private final MailRepository mailRepository;
    private final UserRepository userRepository;

    public void sendMail(Mail mail) {
        mail.setStatus(mail.getStatus() == null ? MailStatus.NORMAL : mail.getStatus());
        mail.setId(UUID.randomUUID().toString());
        mail.setRead(false);
        mailRepository.save(mail);
    }

    public void updateMail(String id) {
        Optional<Mail> mailOptional = mailRepository.findById(id);
        if (mailOptional.isPresent()) {
            Mail mailToSave = mailOptional.get();
            mailToSave.setRead(true);
            mailRepository.save(mailToSave);
        }
    }

    public Mail getMail(String id) {
        return mailRepository.findById(id).orElseThrow(IllegalStateException::new);
    }

    public void updateMailStatus(String id, MailStatus status) {
        if (mailRepository.findById(id).isPresent()){
            Mail mailToSave = mailRepository.findById(id).get();
            mailToSave.setStatus(mailToSave.getStatus() == status ? MailStatus.NORMAL : status);
            mailRepository.save(mailToSave);
        }
    }
}
