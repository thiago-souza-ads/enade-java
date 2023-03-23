package com.integrador.enadejava.config;

import com.integrador.enadejava.domain.dto.UsuarioDto;
import com.integrador.enadejava.domain.model.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(UsuarioDto.class, Usuario.class)
                .addMapping(UsuarioDto::getSenha, Usuario::setSenhaCriptografada);
        return modelMapper;
    }
}
