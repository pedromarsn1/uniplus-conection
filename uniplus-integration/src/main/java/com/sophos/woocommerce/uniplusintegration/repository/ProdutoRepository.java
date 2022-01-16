package com.sophos.woocommerce.uniplusintegration.repository;

import com.sophos.woocommerce.uniplusintegration.domain.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
    Optional<ProdutoEntity> findFirstByCodigo(String codigo);
}
