package com.metaverse.tihcl.registration.service;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StressScoreResponse {
    private String stressScoreId;
    private String issue;
    private String riskCategorisation;
}
