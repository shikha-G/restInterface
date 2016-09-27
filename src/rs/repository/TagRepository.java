package rs.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.model.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, UUID> {

}
