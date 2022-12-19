package com.demo.market.persistence.mapper;

import com.demo.market.domain.CategoryDomain;
import com.demo.market.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring") // indica que se integra MapStruc con Spring
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "categoryId", target = "categoryId"),
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "state", target = "active")
    })
    CategoryDomain toCategoryDomain(Category category); // Se convertirá un entity de tipo Category a un dominio de tipo CategoryDomain

    // para hacer la converción inversa
    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    Category toCategory(CategoryDomain category);
}
