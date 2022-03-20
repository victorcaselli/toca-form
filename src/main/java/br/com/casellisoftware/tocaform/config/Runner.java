package br.com.casellisoftware.tocaform.config;

import br.com.casellisoftware.tocaform.repositories.DiscipleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Runner implements CommandLineRunner {

//    @Autowired
//    private DoormanService doormanService;
    @Autowired
    private DiscipleRepository discipleRepository;


    //TODO -  REMOVE RUNNER AT PROD VERSION
    @SuppressWarnings("RedundantThrows")
    @Override
    public void run(String... args) throws Exception {
//        Phone phone = Phone.builder()
//                .phoneType(1)
//                .ddd(21)
//                .number(989859785L)
//                .build();
//
//        System.out.println(PhoneType.toEnum(phone.getPhoneType()));
//
//        System.out.println(doormanService.findByTime().getFree());

//        System.out.println(discipleRepository
//                .findByNameLikeIgnoreCase("", "Marechal").isEmpty()
//        );
    }
}
