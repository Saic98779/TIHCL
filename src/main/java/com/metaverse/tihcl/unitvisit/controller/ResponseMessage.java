package com.metaverse.tihcl.unitvisit.controller;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseMessage {
		private Integer statusCode;
		private String status;
		private String message;
		private Object data;

		public ResponseMessage(Integer statusCode, String status, String message, Object data) {
			super();
			this.statusCode = statusCode;
			this.status = status;
			this.message = message;
			this.data = data;
		}

		public ResponseMessage(Integer statusCode, String status, Object object) {
			super();
			this.statusCode = statusCode;
			this.status = status;
			this.data = object;
		}

		public ResponseMessage(Integer statusCode, String status ) {
			super();
			this.statusCode = statusCode;
			this.status = status;

		}

		public ResponseMessage(Integer statusCode, String status, String message) {
			super();
			this.statusCode = statusCode;
			this.status = status;
			this.message = message;
		}
}
