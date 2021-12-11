package me.whale.data.api.view;

import jakarta.validation.constraints.NotBlank;

public record UserVo(
        @NotBlank String userNo,
        @NotBlank String userName,
        String gender,
        String birthday,
        String password) {
}
