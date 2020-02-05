package com.dass.LearnMorseCode.models;

import org.springframework.data.jpa.repository.*;

public interface MessageRepository extends JpaRepository<Message,Long> {
}
