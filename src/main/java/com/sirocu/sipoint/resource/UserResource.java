package com.sirocu.sipoint.resource;

import com.sirocu.sipoint.domain.Response;
import com.sirocu.sipoint.domain.UserRequest;
import com.sirocu.sipoint.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static com.sirocu.sipoint.utils.RequestUtils.getResponse;
import static java.util.Collections.emptyMap;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = {"/user"})
public class UserResource {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<Response> saveUser(@RequestBody @Valid UserRequest user, HttpServletRequest request) {
        userService.createUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
        return ResponseEntity.created(getUri()).body(getResponse(request,
                emptyMap(),
                "Account created. check your email to enable your account",
                CREATED));
    }

    @GetMapping("/verify/account")
    public ResponseEntity<Response> verifyAccount(@RequestParam("key") String key, HttpServletRequest request) {
        userService.verifyAccountKey(key);
        return ResponseEntity.ok().body(getResponse(request, emptyMap(), "Account verified", OK));
    }

//    @PostMapping("/login")
//    public ResponseEntity<Response> login (@RequestBody UserRequest user) {
//        Authentication authenticate = authenticationManager.authenticate(UsernamePasswordAuthenticationToken.unauthenticated(user.getEmail(), user.getPassword()));
//        return ResponseEntity.ok().build();
//    }

    private URI getUri() {
        return URI.create("");
    }
}
