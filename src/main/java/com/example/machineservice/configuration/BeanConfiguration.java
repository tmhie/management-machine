package com.example.machineservice.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanConfiguration {
    @Bean(name = "standardModelMapper")
    @Primary
    public ModelMapper standardModelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setSkipNullEnabled(true)
                .setPreferNestedProperties(false)
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        return modelMapper;
    }
}
