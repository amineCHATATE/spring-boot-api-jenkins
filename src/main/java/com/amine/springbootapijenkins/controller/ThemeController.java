package com.amine.springbootapijenkins.controller;

import com.amine.springbootapijenkins.entity.Theme;
import com.amine.springbootapijenkins.repository.ThemeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class ThemeController {
    private final ThemeRepository themeRepository;

    public ThemeController(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    @GetMapping(value = "/theme", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Theme> getThemes() {
        return themeRepository.findAll();
    }

    @GetMapping(value = "/theme/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Theme getTheme(@PathVariable long id){
        return themeRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid theme id %s", id)));
    }

    @PostMapping(value = "/theme", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Theme createTheme(@Valid @RequestBody Theme themeTheme) {
        return themeRepository.save(themeTheme);
    }
}
