package rs.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.model.Vote;

public interface VoteRepository extends JpaRepository<Vote, UUID> {

}
