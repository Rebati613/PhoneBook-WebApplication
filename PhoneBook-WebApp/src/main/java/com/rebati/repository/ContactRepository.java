package com.rebati.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rebati.entity.ContactEntity;

public interface ContactRepository extends JpaRepository<ContactEntity, Serializable> {

}
