package com.integrador.enadejava.domain.service;

import com.integrador.enadejava.domain.dto.FotoDto;
import com.integrador.enadejava.domain.dto.FotoInputDTO;
import com.integrador.enadejava.domain.exception.EntidadeNaoEncontradaException;
import com.integrador.enadejava.domain.model.Foto;
import com.integrador.enadejava.domain.repository.FotoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FotoService {

    @Autowired
    private FotoRepository fotoRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<FotoDto> listar() {
        List<Foto> fotos = fotoRepository.findAll();
        return fotos.stream()
                .map(foto -> modelMapper.map(foto, FotoDto.class))
                .collect(Collectors.toList());
    }

    public FotoDto buscar(Long id) {
        Foto foto = verificarExistencia(id);
        return modelMapper.map(foto, FotoDto.class);
    }

    public FotoDto salvar(FotoInputDTO fotoInputDTO) {
        Foto foto = modelMapper.map(fotoInputDTO, Foto.class);
        foto = fotoRepository.save(foto);
        return modelMapper.map(foto, FotoDto.class);
    }

    public FotoDto atualizar(Long id, FotoInputDTO fotoInputDTO) {
        Foto foto = verificarExistencia(id);
        modelMapper.map(fotoInputDTO, foto);
        foto = fotoRepository.save(foto);
        return modelMapper.map(foto, FotoDto.class);
    }

    public void excluir(Long id) {
        Foto foto = verificarExistencia(id);
        fotoRepository.delete(foto);
    }

    private Foto verificarExistencia(Long id) {
        return fotoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Foto não encontrada"));
    }
}

