package app.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Review;

public interface ReviewRepo extends JpaRepository<Review, Integer>{

}
