package africa.semicolon.Data.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@Document
public class Comment {
    private String commenterName;
    @Id
    private String postId;

    private String commentBody;
    private LocalDateTime commentTime = LocalDateTime.now();


}
