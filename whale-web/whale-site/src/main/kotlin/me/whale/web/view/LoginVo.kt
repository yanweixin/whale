package me.whale.web.view

import jakarta.validation.constraints.NotBlank
import me.whale.common.enums.personal.IdentityType

data class LoginVo(
    val identityType: IdentityType,
    @field:NotBlank val identity: String,
    @field:NotBlank val password: String
)
