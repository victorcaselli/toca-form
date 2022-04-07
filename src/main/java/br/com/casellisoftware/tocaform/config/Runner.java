package br.com.casellisoftware.tocaform.config;

import br.com.casellisoftware.tocaform.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
    public void run(String... args) throws Exception {

    }
}
