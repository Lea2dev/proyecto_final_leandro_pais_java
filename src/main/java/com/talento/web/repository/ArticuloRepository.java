package com.talento.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talento.web.model.Articulo;


@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {

}
