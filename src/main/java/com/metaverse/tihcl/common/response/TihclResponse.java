package com.metaverse.tihcl.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class TihclResponse {
    protected Integer status;
    protected String message;
    protected Object data;
}
