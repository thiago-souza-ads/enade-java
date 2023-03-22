package com.integrador.enadejava.api.controller;

import com.integrador.enadejava.domain.dto.UsuarioDTO;
import com.integrador.enadejava.domain.model.Usuario;
import com.integrador.enadejava.domain.repository.UsuarioRepository;
import com.integrador.enadejava.domain.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> usuarioDTOS = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            usuarioDTOS.add(modelMapper.map(usuario, UsuarioDTO.class));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDTOS);
    }
    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        usuario = usuarioService.create(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(usuario, UsuarioDTO.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok(modelMapper.map(usuario, UsuarioDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        usuario.setId(id);
        usuario = usuarioService.update(usuario);
        return ResponseEntity.ok(modelMapper.map(usuario, UsuarioDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
