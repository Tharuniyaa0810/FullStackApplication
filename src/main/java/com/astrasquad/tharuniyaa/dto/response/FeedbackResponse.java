package com.astrasquad.tharuniyaa.dto.response;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackResponse {
	
	   private Long fid;

    private String name;
    private int rating;
    private String message;
}
