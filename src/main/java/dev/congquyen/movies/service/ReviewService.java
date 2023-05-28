package dev.congquyen.movies.service;

import java.util.Optional;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import dev.congquyen.movies.Repository.ReviewRepository;
import dev.congquyen.movies.model.Movie;
import dev.congquyen.movies.model.Review;
@Service
public class ReviewService {
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public Review createReview(String body, String imdbId) {
		Review review =  reviewRepository.insert(new Review(body));
		mongoTemplate.update(Movie.class).matching(Criteria.where("imdbId").is(imdbId)).apply(new Update().push("reviewIds", review)).first();
		return review;
	
	}

	public Review deleteReview(String IdReview,String IdMovie) {
		ObjectId reviewId = new ObjectId(IdReview);
	    ObjectId movieId = new ObjectId(IdMovie);
	    
	    Optional<Review> reviewOptional = reviewRepository.findById(reviewId);
	    if (reviewOptional.isPresent()) {
	        Review review = reviewOptional.get();
	        reviewRepository.delete(review);
	        
	        Query query = new Query(Criteria.where("_id").is(movieId));
	        Update update = new Update().pull("reviewIds", reviewId);
	        mongoTemplate.updateFirst(query, update, Movie.class);	
	        return review;
	    } else {
	        return null;
	    }
	}

		public Review updateReview(String IdReview,String body) {
			ObjectId idReview = new ObjectId(IdReview);
			Optional<Review> reviewOptional = reviewRepository.findById(idReview);
			if (reviewOptional.isPresent()) {
				Review review = reviewOptional.get();
				review.setBody(body);
				reviewRepository.save(review);	
		        return review;
			}
			return null;			
		}
	

}
