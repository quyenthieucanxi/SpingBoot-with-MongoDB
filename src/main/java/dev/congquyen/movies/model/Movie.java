package dev.congquyen.movies.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
	@Id
	private ObjectId id ;
	@Field
	private String imdbId;
	public Movie(String imdbId, String title, String releaseDate, String trailerLink, String poster,
			List<String> genres, List<String> backdrops, List<Review> reviewIds) {
		this.imdbId = imdbId;
		this.title = title;
		this.releaseDate = releaseDate;
		this.trailerLink = trailerLink;
		this.poster = poster;
		this.genres = genres;
		this.backdrops = backdrops;
		this.reviewIds = reviewIds;
	}
	@Field
	private String title;
	@Field
	private String releaseDate;
	@Field
	private String trailerLink;
	@Field
	private String poster;
	@Field
	private List<String> genres;
	@Field
	private List<String> backdrops;
	@Field
	@DocumentReference	
	private List<Review> reviewIds;
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getTrailerLink() {
		return trailerLink;
	}
	public void setTrailerLink(String trailerLink) {
		this.trailerLink = trailerLink;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public List<String> getGenres() {
		return genres;
	}
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}
	public List<String> getBackdrops() {
		return backdrops;
	}
	public void setBackdrops(List<String> backdrops) {
		this.backdrops = backdrops;
	}
	public List<Review> getReviewIds() {
		return reviewIds;
	}
	public void setReviewIds(List<Review> reviewIds) {
		this.reviewIds = reviewIds;
	}

}
