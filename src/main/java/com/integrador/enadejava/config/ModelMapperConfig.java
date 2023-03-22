package com.integrador.enadejava.config;

import com.integrador.enadejava.domain.dto.UsuarioDTO;
import com.integrador.enadejava.domain.model.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(UsuarioDTO.class, Usuario.class)
                .addMapping(UsuarioDTO::getSenha, Usuario::setSenhaCriptografada);
        return modelMapper;
    }
}
