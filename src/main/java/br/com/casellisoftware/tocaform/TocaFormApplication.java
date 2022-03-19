package br.com.casellisoftware.tocaform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TocaFormApplication {

    public static void main(String[] args) {
        //TODO - Temporary
        System.setProperty("user.timezone", "America/Sao_Paulo");

        SpringApplication.run(TocaFormApplication.class, args);
    }

}
