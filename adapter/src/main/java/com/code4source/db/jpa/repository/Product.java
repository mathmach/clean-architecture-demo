package com.code4source.db.jpa.repository;

import com.code4source.db.jpa.model.ProductDb;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface Product extends JpaRepository<ProductDb, UUID>, JpaSpecificationExecutor {

    public Optional<ProductDb> findByName(String name);

}
