package com.amsidh.mvc.service.impl;

import com.amsidh.mvc.entity.Person;
import com.amsidh.mvc.exception.PersonNotFoundException;
import com.amsidh.mvc.model.request.PersonDto;
import com.amsidh.mvc.repository.PersonRepository;
import com.amsidh.mvc.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final ObjectMapper objectMapper;

    @Override
    public PersonDto savePerson(PersonDto personDto) {
        log.info("Create person");
        Person person = objectMapper.convertValue(personDto, Person.class);
        Person p = personRepository.save(person);
        return objectMapper.convertValue(p, PersonDto.class);
    }

    @Override
    public PersonDto getPersonById(Integer id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(String.format("No person found with person id %d", id)));
        return objectMapper.convertValue(person, PersonDto.class);
    }

    @Override
    public PersonDto updatePerson(Integer id, PersonDto personDto) {
        return personRepository.findById(id).map(person -> {
            Optional.ofNullable(personDto.getName()).ifPresent(person::setName);
            Optional.ofNullable(personDto.getEmailId()).ifPresent(person::setEmailId);
            Optional.ofNullable(personDto.getMobileNumber()).ifPresent(person::setMobileNumber);
            return objectMapper.convertValue(person, PersonDto.class);
        }).orElseThrow(() -> new PersonNotFoundException(String.format("No person found with person id %d", id)));
    }

    @Override
    public boolean deletePerson(Integer id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<PersonDto> getAllPersons() {
        return personRepository.findAll().stream().parallel().map(person -> {
            PersonDto personDto = objectMapper.convertValue(person, PersonDto.class);
            log.info(personDto.toString());
            return personDto;
        }).collect(Collectors.toList());
    }
}
