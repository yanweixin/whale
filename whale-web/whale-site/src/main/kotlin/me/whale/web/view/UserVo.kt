package me.whale.web.view

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size


data class UserVo(
    @field:NotBlank val userNo: String,
    @field:NotBlank val userName: String,
    val gender: String,
    val birthday: String,
    @field:Size(min = 8, max = 255) val password: String
)