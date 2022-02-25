package com.example.insurancecompany.repository;

import com.example.insurancecompany.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

        @Autowired
        private UserRepository userRepository;

        @BeforeEach
        void setUp() {
                User user1 = new User(null, "Ivan", "Dychko", "Dychko876", 26, 8, 2001, "ivan67dychko@gmail.com", 885674008, "ILikeApples564", new ArrayList<>(), new ArrayList<>());
                User user2 = new User(null, "Tyson", "Fury", "Fury0484", 19, 4, 1988, "gypsy76king@gmail.com", 334768597, "DeontayWilder76585", new ArrayList<>(), new ArrayList<>());
                User user3 = new User(null, "Adam", "Lambert", "Bambert", 4, 2, 1996, "adam444lambert@gmail.com", 567900341, "PotatoApple8767", new ArrayList<>(), new ArrayList<>());
                User user4 = new User(null, "Sergio", "Aguero", "Ugup784", 8, 11, 1978, "seergito8697@gmail.com", 976004630, "AgueroMan87697", new ArrayList<>(), new ArrayList<>());
                userRepository.save(user1);
                userRepository.save(user2);
                userRepository.save(user3);
                userRepository.save(user4);
        }

        @AfterEach
        void tearDown() {
                userRepository.deleteAll();
        }

        @Test
        void itShouldReturnUsersSortedAndPaginated() {

                List<User> users = userRepository.findUsers(PageRequest.of(0,3));

                assertThat(users).hasSize(3);


        }

}