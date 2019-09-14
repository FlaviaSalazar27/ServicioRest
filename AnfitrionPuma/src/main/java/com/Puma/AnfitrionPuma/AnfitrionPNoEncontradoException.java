package com.Puma.AnfitrionPuma;

 public class AnfitrionPNoEncontradoException extends RuntimeException {
    AnfitrionPNoEncontradoException(Long id) {
        super("Anfitrion no encontrado" + id);
    }
}
