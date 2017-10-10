package com.nirav.rest.rest_experiment.service;


import com.nirav.rest.rest_experiment.database.DatabaseClass;
import com.nirav.rest.rest_experiment.model.Comment;
import com.nirav.rest.rest_experiment.model.Message;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommentService {
	
	private Map<Integer, Message> messages = DatabaseClass.getMessages();
	
	public List<Comment> getAllComments(long messageId) {
		Map<Integer, Comment> comments = messages.get(messageId).getCommentsMap();
		return new ArrayList<>(comments.values());
	}
	
/*	public Comment getComment(long messageId, long commentId) {
		ErrorMessage errorMessage = new ErrorMessage("Not found", 404, "http://javabrains.koushik.org");
		Response response = Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
		
		Message message = messages.get(messageId);
		if (message == null) {
			throw new WebApplicationException(response);
		}
		Map<Integer, Comment> comments = messages.get(messageId).getCommentsMap();
		Comment comment = comments.get(commentId);
		if (comment == null) {
			throw new NotFoundException(response);
		}
		return comment;
	}*/
	
	public Comment addComment(long messageId, Comment comment) {
		Map<Integer, Comment> comments = messages.get(messageId).getCommentsMap();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(long messageId, Comment comment) {
		Map<Integer, Comment> comments = messages.get(messageId).getCommentsMap();
		if (comment.getId() <= 0) {
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long messageId, long commentId) {
		Map<Integer, Comment> comments = messages.get(messageId).getCommentsMap();
		return comments.remove(commentId);
	}
		
}
