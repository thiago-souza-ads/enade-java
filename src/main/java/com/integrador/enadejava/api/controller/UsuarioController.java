package com.integrador.enadejava.api.controller;

import com.integrador.enadejava.domain.dto.UsuarioDto;
import com.integrador.enadejava.domain.model.Usuario;
import com.integrador.enadejava.domain.repository.UsuarioRepository;
import com.integrador.enadejava.domain.service.UsuarioService;
import jakarta.annotation.security.PermitAll;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity<List<UsuarioDto>> listar() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDto> usuarioDTOS = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            UsuarioDto dto = modelMapper.map(usuario, UsuarioDto.class);
            usuarioDTOS.add(dto);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDTOS);
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> create(@RequestBody UsuarioDto usuarioDTO) {
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        usuario = usuarioService.create(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(usuario, UsuarioDto.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> findById(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok(modelMapper.map(usuario, UsuarioDto.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> update(@PathVariable Long id, @RequestBody UsuarioDto usuarioDTO) {
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        usuario.setId(id);
        usuario = usuarioService.update(usuario);
        return ResponseEntity.ok(modelMapper.map(usuario, UsuarioDto.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PermitAll
    @PostMapping("/atualizar-avatar")
    public ResponseEntity<?> atualizarAvatar(@RequestBody UsuarioDto usuarioDto) {
        usuarioService.atualizarAvatar(usuarioDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }
}
