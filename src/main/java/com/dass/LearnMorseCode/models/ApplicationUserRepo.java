package com.dass.LearnMorseCode.models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepo extends JpaRepository<ApplicationUser, Long> {
    public ApplicationUser findByUsername(String username);
}
