package com.omar.mssccokeservice.repositories;

import com.omar.mssccokeservice.domain.Coke;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface CokeRepository extends PagingAndSortingRepository<Coke, UUID> {
}
