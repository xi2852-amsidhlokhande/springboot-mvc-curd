package com.amsidh.mvc;

import com.amsidh.mvc.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class SpringbootCurdApplication implements CommandLineRunner {
    private PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCurdApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      //  if (personRepository.findAll().isEmpty()) {
       //     log.info("Loading initial person data");
        //    personRepository.saveAllAndFlush(() -> Arrays.asList(Person.builder().name("Amsidh").mobileNumber(8108551845L).emailId("amsidhlokhande@gmail.com").build(), Person.builder().name("Aditya").mobileNumber(8108551849L).emailId("adithilokhande@gmail.com").build(), Person.builder().name("Anjali").mobileNumber(8108551846L).emailId("anjalilokhande@gmail.com").build(), Person.builder().name("Adithi").mobileNumber(8108551847L).emailId("adithilokhande@gmail.com").build()).stream().iterator());
        //}
    }
}
