package com.meli.Sports.config;

import org.modelmapper.ModelMapper;

@org.springframework.context.annotation.Configuration
public class Configuration {

    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);

        return modelMapper;
    }
}
