package africa.semicolon.dtos.requests;

import lombok.Data;



@Data

public class CreateCommentRequest {
    private String postId;
    private String commenterName;

    private String commentBody;


}