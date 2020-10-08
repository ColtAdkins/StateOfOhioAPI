package com.ohio.state.services;

import org.springframework.data.repository.CrudRepository;

import com.ohio.state.models.Senator;

public interface SenatorRepository extends CrudRepository<Senator, Long> {}