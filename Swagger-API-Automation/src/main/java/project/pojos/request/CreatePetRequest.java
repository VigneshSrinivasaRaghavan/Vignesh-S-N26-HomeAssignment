
package project.pojos.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

@AllArgsConstructor  @NoArgsConstructor @Builder @Getter @Setter
public class CreatePetRequest {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("category")
    private CategoryRequest category;
    @JsonProperty("photoUrls")
    private List<String> photoUrls = null;
    @JsonProperty("tags")
    private List<TagRequest> tags = null;
    @JsonProperty("status")
    private String status;
}
