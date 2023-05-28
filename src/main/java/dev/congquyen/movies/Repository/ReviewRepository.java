package dev.congquyen.movies.Repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dev.congquyen.movies.model.Review;
@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
	
}
