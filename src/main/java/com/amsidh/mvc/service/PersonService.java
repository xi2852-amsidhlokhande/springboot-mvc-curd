package com.amsidh.mvc.service;

import com.amsidh.mvc.model.request.PersonDto;

import java.util.List;

public interface PersonService {
    PersonDto savePerson(PersonDto personDto);

    PersonDto getPersonById(Integer id);

    PersonDto updatePerson(Integer id, PersonDto personDto);

    boolean deletePerson(Integer id);

    List<PersonDto> getAllPersons();

}
