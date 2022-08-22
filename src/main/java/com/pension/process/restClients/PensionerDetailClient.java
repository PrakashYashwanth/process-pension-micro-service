package com.pension.process.restClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pension.process.exception.AadharNumberNotFound;
import com.pension.process.exception.AuthorizationException;
import com.pension.process.model.PensionerDetail;

@FeignClient(name ="PensionerDetail-Microservice",url = "${PENSIONER_DETAIL_MICRO_SERVICE_URI:http://localhost:8200}")
public interface PensionerDetailClient {
	
	@GetMapping("/pensioner/api/v1/findPensionerDetailByAadhaar/{aadharNumber}")
	public PensionerDetail getPensionerDetailByAadhaar(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader,
			@PathVariable long aadharNumber) throws AuthorizationException, AadharNumberNotFound;

}
