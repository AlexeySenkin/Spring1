package ru.senkin.service;

import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.senkin.model.QUser;
import ru.senkin.model.dto.UserDto;
import ru.senkin.model.mapper.UserDtoMapper;
import ru.senkin.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDtoMapper mapper;
    private final UserRepository userRepository;

    public List<UserDto> findAllByFilter(String usernameFilter, String emailFilter) {
        QUser user = QUser.user;
        BooleanBuilder predicate = new BooleanBuilder();
        if (usernameFilter != null && !usernameFilter.isBlank()) {
            predicate.and(user.username.contains(usernameFilter.trim()));
        }

        if (emailFilter != null && !emailFilter.isBlank()) {
            predicate.and(user.username.contains(emailFilter.trim()));
        }

        return StreamSupport.stream(userRepository.findAll(predicate).spliterator(),true)
                .map(mapper::map).collect(Collectors.toList());
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
