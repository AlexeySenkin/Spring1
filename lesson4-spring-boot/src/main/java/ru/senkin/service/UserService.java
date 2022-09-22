package ru.senkin.service;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.senkin.model.dto.UserDto;
import ru.senkin.model.mapper.UserDtoMapper;
import ru.senkin.repository.UserRepository;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDtoMapper mapper;
    private final UserRepository userRepository;

    public Page<UserDto> findAllByFilter(String usernameFilter, String emailFilter, int page, int size) {

        usernameFilter = usernameFilter == null || usernameFilter.isBlank() ? null : "%" + usernameFilter.trim() + "%";
        emailFilter = emailFilter == null || emailFilter.isBlank() ? null : "%" + emailFilter.trim() + "%";
        return userRepository.usersByFilter(usernameFilter, emailFilter, PageRequest.of(page, size))
                .map(mapper::map);


//        return StreamSupport.stream(userRepository.findAll(predicate, PageRequest.of(page, size)).spliterator(),true)
//                .map(mapper::map).collect(Collectors.toList());
    }

    public Optional<UserDto> findUserById(Long id) {
        return userRepository.findById(id).map(mapper::map);

    }

    public void save(UserDto dto) {
        userRepository.save(mapper.map(dto));
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }




}
