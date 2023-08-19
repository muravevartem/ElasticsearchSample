package ru.muravev.search.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.muravev.search.document.SystemIndex;
import ru.muravev.search.repository.SystemRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/systems")
@RequiredArgsConstructor
public class SystemController {
    private final SystemRepository systemRepository;


    @PostMapping
    public SystemIndex create(@RequestBody SystemIndex system) {
        return systemRepository.save(system);
    }

    @GetMapping(params = "keyword")
    public List<SystemIndex> getByDescription(@RequestParam String keyword) {
        return systemRepository.findAllByDescriptionMatches(keyword);
    }
}
