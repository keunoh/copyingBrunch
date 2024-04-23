package com.brunch.kaltz.domain;


import java.util.Optional;

public interface SearchRepository  {

    Search save(Search search);

    Optional<Search> findById(Long id);
}
