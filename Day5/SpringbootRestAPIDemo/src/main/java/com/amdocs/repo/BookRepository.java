package com.amdocs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.model.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

	
}
