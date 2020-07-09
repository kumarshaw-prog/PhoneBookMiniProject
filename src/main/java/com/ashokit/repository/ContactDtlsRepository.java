package com.ashokit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.ContactDtlsEntity;

public interface ContactDtlsRepository extends JpaRepository<ContactDtlsEntity, Serializable> {

}
