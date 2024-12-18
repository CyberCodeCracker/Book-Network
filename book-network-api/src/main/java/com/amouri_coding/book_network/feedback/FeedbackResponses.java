package com.amouri_coding.book_network.feedback;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackResponses {

    private Double note;
    private String comment;
    private boolean ownFeedback;
}
