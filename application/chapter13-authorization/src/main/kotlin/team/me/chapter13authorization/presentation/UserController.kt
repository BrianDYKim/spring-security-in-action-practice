package team.me.chapter13authorization.presentation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/users")
class UserController {
    @GetMapping("/me")
    fun getMyInfo(): UserInfoResponse {
        return UserInfoResponse("john")
    }

    data class UserInfoResponse(val nickname: String)
}
