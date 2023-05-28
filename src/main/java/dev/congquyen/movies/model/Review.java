package dev.congquyen.movies.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
	@Id
	private ObjectId _id; 
	@Field
	private String body;
	
	
	public Review(String body) {
		this.body = body;
	}
	public ObjectId getId() {
		return _id;
	}
	public void setId(ObjectId id) {
		this._id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
}
