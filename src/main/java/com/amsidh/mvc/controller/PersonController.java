package com.amsidh.mvc.controller;

import com.amsidh.mvc.model.request.PersonDto;
import com.amsidh.mvc.service.PersonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/persons")
@Slf4j
public class PersonController {

    private final PersonService personService;
    private final ObjectMapper objectMapper;

    @Operation(summary = "This api is exposed to register a new person in our system", description = "Register person")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Person registration request accepted", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = PersonDto.class))
            })
    })
    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public PersonDto createPerson(@RequestBody PersonDto personDto) throws JsonProcessingException {
        log.info("Received request to save person with details {}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(personDto));
        return personService.savePerson(personDto);
    }

    @Operation(summary = "This api is exposed to see the person details using person id", description = "Get Person by person id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Get Person", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = PersonDto.class))
            })
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDto getPersonByPersonId(@PathVariable Integer id) {
        log.info("Getting person with person Id {}", id);
        return personService.getPersonById(id);
    }

    @Operation(summary = "This api is exposed to update the person details", description = "Update person by person id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Update Person", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = PersonDto.class))
            })
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDto updatePerson(@PathVariable Integer id, @RequestBody PersonDto personDto) {
        log.info("Update person withId {} and details {}", id, personDto);
        return personService.updatePerson(id, personDto);
    }

    @Operation(summary = "This api is exposed to delete the person using person id", description = "Delete person by person id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Delete Person", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = String.class))
            })
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deletePersonByPersonId(@PathVariable Integer id) {
        log.info("Deleting person with person Id {}", id);
        personService.deletePerson(id);
        return "Person Deleted successfully";
    }


    @Operation(summary = "This api is exposed to get all person details", description = "Get all person details")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Get all persons", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = PersonDto.class))
            })
    })
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDto> getPersons() {
        log.info("Getting all the persons");
        return personService.getAllPersons();
    }

}
