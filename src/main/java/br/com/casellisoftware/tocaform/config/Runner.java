package br.com.casellisoftware.tocaform.config;

import br.com.casellisoftware.tocaform.entities.Phone;
import br.com.casellisoftware.tocaform.enums.ChurchStatusType;
import br.com.casellisoftware.tocaform.enums.PhoneType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Runner implements CommandLineRunner {


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
    }
}
