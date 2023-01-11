package africa.semicolon.dtos.requests;

import lombok.Data;


@Data

public class CreatePostRequest {
    private String title;
    private String body;
    private String id;


}
