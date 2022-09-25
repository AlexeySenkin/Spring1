package ru.senkin.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import ru.senkin.model.User;
import ru.senkin.model.dto.UserDto;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserDtoMapper {

    @Mapping(target = "password",ignore = true)
    @Mapping(target = "matchingPassword", ignore = true)
    UserDto map(User user);

    @Mapping(target = "id", ignore = true)
    User map(UserDto dto);

}
