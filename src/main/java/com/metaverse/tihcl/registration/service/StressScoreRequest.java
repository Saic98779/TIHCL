package com.metaverse.tihcl.registration.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StressScoreRequest {
    private String issue;
    private String riskCategorisation;
}
