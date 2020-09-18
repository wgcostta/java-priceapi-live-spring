package one.dio.cloud81s.service;

import lombok.AllArgsConstructor;
import one.dio.cloud81s.dto.request.PersonDTO;
import one.dio.cloud81s.entity.MessageResponseDTO;
import one.dio.cloud81s.entity.Person;
import one.dio.cloud81s.exception.PersonNotFoundException;
import one.dio.cloud81s.mapper.PersonMapper;
import one.dio.cloud81s.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
    private final PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return createdMessageResponse( "Created person with ID: " + savedPerson.getId());
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream().map(
                personMapper::toDTO
        ).collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExistis(id);
        return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExistis(id);

        personRepository.deleteById(id);
    }

    public MessageResponseDTO update(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExistis(id);

        Person personToUpdate = personMapper.toModel(personDTO);

        Person updatePerson = personRepository.save(personToUpdate);
        return createdMessageResponse("Update person with ID: " + updatePerson.getId());
    }

    private Person verifyIfExistis(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createdMessageResponse(String sMessage) {
        return MessageResponseDTO
                .builder()
                .message(sMessage)
                .build();
    }
}
