package ru.muravev.search.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.muravev.search.document.UserIndex;
import ru.muravev.search.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository repository;


    @PostMapping
    public UserIndex create(@RequestBody UserIndex system) {
        return repository.save(system);
    }

    @GetMapping(params = "keyword")
    public List<UserIndex> getByDescription(@RequestParam String keyword) {
        return repository.findAllByKeyword(keyword);
    }
}
