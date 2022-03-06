package com.example.insurancecompany.service;

import com.example.insurancecompany.domain.ConfirmationToken;
import com.example.insurancecompany.repository.ConfirmationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class ConfirmationTokenService {

        private final ConfirmationTokenRepository confirmationTokenRepository;

        public void saveConfirmationToken(ConfirmationToken token) {
                confirmationTokenRepository.save(token);
        }

        public ConfirmationToken getToken(String token) {
                ConfirmationToken confirmationToken = confirmationTokenRepository.findByToken(token)
                        .orElseThrow(() -> new EntityNotFoundException("Token Not Found!"));
                return confirmationToken;
        }

        public int setConfirmedAt(String token) {
                return confirmationTokenRepository.updateConfirmedAt(
                        token, LocalDateTime.now());
        }

}
