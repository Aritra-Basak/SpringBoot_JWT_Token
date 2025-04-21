/**
 * 
 */
package com.java.springBoot_jwt_demo.dto;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * @author Aritra
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@Builder
@ToString
public class ServiceResponse {
	
	@JsonProperty(value="Response_Status")
	HttpStatus status;
	@JsonProperty(value="Response_Entity_count")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	long entityCount;
	@JsonProperty(value="Response_Value")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	Object resObject;
	@JsonProperty(value="Response_Message")
	String resMessage;
	@JsonProperty(value="Response_Status_Code")
	int statusCode;
	

}

