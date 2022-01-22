package me.whale.web.view

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size


data class UserVo(
    @field:NotBlank val userNo: String,
    @field:NotBlank val userName: String,
    val gender: String,
    val birthday: String,
    @field:Size(min = 8, max = 255) val password: String
)