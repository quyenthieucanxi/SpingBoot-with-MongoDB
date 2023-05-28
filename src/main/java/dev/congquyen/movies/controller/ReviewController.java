package dev.congquyen.movies.controller;

import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.congquyen.movies.model.Review;
import dev.congquyen.movies.service.ReviewService;

@RestController
@RequestMapping("api/v1/reviews")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@PostMapping("/create")
	public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload)
	{
		return new ResponseEntity<Review>(reviewService.createReview(payload.get("body"), payload.get("imdbId")),HttpStatus.OK);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<Review> deleteReview(@RequestBody Map<String, String> payload)
	{	
		System.out.println(payload.get("IdReview")+" "+payload.get("IdMovie"));
		Review reviewDeleteReview = reviewService.deleteReview(payload.get("IdReview"),payload.get("IdMovie"));
		
		if (reviewDeleteReview == null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Review>(reviewService.deleteReview(payload.get("IdReview"),payload.get("IdMovie")),HttpStatus.OK);
	}
}
