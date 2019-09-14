package com.Puma.AnfitrionPuma;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnfitrionControlador {
    private final RepositorioAnfitrion repository;

    AnfitrionControlador(RepositorioAnfitrion repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/AnfitrionP")
    List<AnfitrionP> all() {
        return repository.findAll();
    }

    @PostMapping("/AnfitrionP")
    AnfitrionP newAnfitrion(@RequestBody AnfitrionP newAnfitrion) {
        return repository.save(newAnfitrion);
    }

    // Single item

    @GetMapping("/AnfitrionP/{id}")
    AnfitrionP one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new AnfitrionPNoEncontradoException(id));
    }


    @PutMapping("/AnfitrionP/{id}")
    AnfitrionP reemplazarAnfitrion(@RequestBody AnfitrionP newAnfitrion, @PathVariable Long id) {

        return repository.findById(id)
                .map(AnfitrionP -> {
                    AnfitrionP.setNombre(newAnfitrion.getNombre());
                    AnfitrionP.setEmail(newAnfitrion.getEmail());
                    AnfitrionP.setTelefono(newAnfitrion.getTelefono());
                    AnfitrionP.setCi(newAnfitrion.getCi());
                    return repository.save(AnfitrionP);
                })
                .orElseGet(() -> {
                    newAnfitrion.setId(id);
                    return repository.save(newAnfitrion);
                });
    }

    @DeleteMapping("/AnfitrionP/{id}")
    void eliminarAnfitrion(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
