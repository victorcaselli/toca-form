package br.com.casellisoftware.tocaform.config;

import br.com.casellisoftware.tocaform.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@Configuration
public class Runner implements CommandLineRunner {

//    @Autowired
//    private DoormanService doormanService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;


    //TODO -  REMOVE RUNNER AT PROD VERSION
    @SuppressWarnings("RedundantThrows")
    @Override
    @Transactional
    public void run(String... args) throws Exception {

//        User user = new User();
//        user.setUsername("admin");
//        user.setPassword(encoder.encode("admin"));

//        userRepository.save(user);
    }
}
