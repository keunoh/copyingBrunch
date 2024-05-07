package com.brunch.kaltz.board.repo;

import com.brunch.kaltz.board.domain.Developer;

import java.util.Optional;

public interface DeveloperRepository {

    Optional<Developer> findById(Long id);

}
