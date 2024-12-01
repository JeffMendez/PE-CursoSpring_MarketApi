package com.jeffmendez.market.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.jeffmendez.market.domain.model.CategoryDTO;
import com.jeffmendez.market.persistence.entity.Categoria;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    
    @Mapping(source = "idCategoria", target = "categoryId")
    @Mapping(source = "descripcion", target = "name")
    @Mapping(source = "estado", target = "active")
    CategoryDTO toDto(Categoria categoria);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toEntity(CategoryDTO categoryDTO);
}
