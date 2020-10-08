package com.ohio.state.services;

import org.springframework.data.repository.CrudRepository;

import com.ohio.state.models.Representative;

public interface RepresentativeRepository extends CrudRepository<Representative, Long> {}
