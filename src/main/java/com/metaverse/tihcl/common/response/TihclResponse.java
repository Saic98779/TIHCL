package com.metaverse.tihcl.common.response;

import lombok.*;

@Builder
@AllArgsConstructor
@Data
public class TihclResponse {
    protected Integer status;
    protected String message;
    protected Object data;
}
