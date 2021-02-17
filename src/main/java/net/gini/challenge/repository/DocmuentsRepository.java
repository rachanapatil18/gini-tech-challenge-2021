package net.gini.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.gini.challenge.model.Documents;

@Repository
public interface DocmuentsRepository extends JpaRepository<Documents, Long> {

}
