package com.pension.process.restClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import com.pension.process.model.TokenValidationResponse;

@FeignClient(name = "Authorization-Microservice", url = "${AUTHORIZATION_MICRO_SERVICE_URI:http://localhost:8100}")
public interface AuthClient {

	@PostMapping("/auth/api/v1/authorizeuser")
	public TokenValidationResponse authorizeTheRequest(@RequestHeader(value = "Authorization", required = true) String requestTokenHeader);
}
