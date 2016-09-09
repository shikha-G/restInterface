package rs.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.model.Tag;

public interface TagRepository extends JpaRepository<Tag, UUID> {

}
