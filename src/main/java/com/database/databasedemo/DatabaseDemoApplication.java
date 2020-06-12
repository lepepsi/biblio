package com.database.databasedemo;

import com.database.databasedemo.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

    private EmailService emailService;
    @Autowired
    public void setEmailService(EmailService emailService){
        this.emailService = emailService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DatabaseDemoApplication.class, args);
    }

   @Override
    public void run(String... strings) throws Exception{

        emailService.prepareAndSendEmail("stephane_ngameni@yahoo.fr");

   }


}
