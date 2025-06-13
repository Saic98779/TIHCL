package com.metaverse.tihcl.unitvisit.controller;

import java.util.List;

import org.springframework.http.HttpStatusCode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMessage {

		
		
		private Integer statusCode;
		private String status;
		private String message;
		private Object data;
		private List<?> list;
		
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
		
		public ResponseMessage(Integer statusCode, String status, List<Object> object) {
			super();
			this.statusCode = statusCode;
			this.status = status;
			this.data = object;
		}
 
		public ResponseMessage(Integer statusCode, String status, String message, List<?> list) {
			super();
			this.statusCode = statusCode;
			this.status = status;
			this.message = message;
			this.list = list;
		}

		 
		
		
		

	

}
