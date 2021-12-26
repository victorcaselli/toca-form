package br.com.casellisoftware.tocaform.util;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 *
 * ModelMapper implementation
 *
 * @author V. D. Caselli
 * @since 1.0
 */

@Component
@RequiredArgsConstructor
@SuppressWarnings("unused") // TODO - remove it late
public class ModelMapperUtil {

    private final ModelMapper modelMapper;
    private ModelMapper staticModelMapper;

    @PostConstruct
    public void initialize(){
        staticModelMapper = this.modelMapper;
    }

    /**
     * Used for the DTO's transformations
     *
     * @param source source entity
     * @param destination destination class that will generate a new entity of the source entity
     */
    public <S,D> D map(S source, Class<D> destination){
        return staticModelMapper.map(source,destination);
    }
}
