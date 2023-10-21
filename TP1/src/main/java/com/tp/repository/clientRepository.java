package com.tp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tp.entities.client;

@Repository
public interface clientRepository extends JpaRepository<client, Long>
{


}
