package com.example.university.pl.models;

import com.example.university.dal.models.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserDTO {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String email;

    public static UserDTO fromEntity(User entity) {
        return UserDTO.builder()
                .name(entity.getName())
                .surname(entity.getSurname())
                .birthDate(entity.getBirthDate())
                .email(entity.getEmail())
                .build();
    }
}
