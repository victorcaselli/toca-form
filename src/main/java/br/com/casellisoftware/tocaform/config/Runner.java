package br.com.casellisoftware.tocaform.config;

import br.com.casellisoftware.tocaform.entities.Phone;
import br.com.casellisoftware.tocaform.enums.ChurchStatusType;
import br.com.casellisoftware.tocaform.enums.PhoneType;
import br.com.casellisoftware.tocaform.services.DoormanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Runner implements CommandLineRunner {

//    @Autowired
//    private DoormanService doormanService;


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
    }
}
