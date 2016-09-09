package rs.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, UUID> {

}
