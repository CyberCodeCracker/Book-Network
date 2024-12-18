package com.amouri_coding.book_network.feedback;

import com.amouri_coding.book_network.book.Book;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class FeedbackMapper {

    public Feedback toFeedback(@Valid FeedbackRequest request) {
        return Feedback.builder()
                .note(request.note())
                .comment(request.comment())
                .book(Book.builder()
                        .id(request.bookId())
                        .archived(false)
                        .shareable(false)
                        .build()
                )
                .build()
                ;
    }

    public FeedbackResponses toFeedbackResponse(Feedback feedback, Integer userId) {
        return FeedbackResponses.builder()
                .note(feedback.getNote())
                .comment(feedback.getComment())
                .ownFeedback(Objects.equals(feedback.getCreatedBy(), userId))
                .build()
                ;
    }
}
