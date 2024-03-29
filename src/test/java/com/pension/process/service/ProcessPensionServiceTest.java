package com.pension.process.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pension.process.model.Bank;
import com.pension.process.model.PensionDetail;
import com.pension.process.model.PensionerDetail;
import com.pension.process.model.ProcessPensionInput;
import com.pension.process.repository.PensionDetailsRepository;
import com.pension.process.restClients.AuthClient;
import com.pension.process.restClients.PensionerDetailClient;


@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class ProcessPensionServiceTest {

	@MockBean
	private PensionerDetailClient pensionerDetailClient;

	@MockBean
	private AuthClient authorizeClient;

	@InjectMocks
	private ProcessPensionServiceImpl processPensionServiceImpl;

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PensionDetailsRepository pensionrepo;

	@Test
	void testPensionerDetailClientNotNull() {
		assertThat(pensionerDetailClient).isNotNull();
	}

	@Test
	void testMockMvcNotNull() {
		assertThat(mockMvc).isNotNull();
	}

	String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

	@Test
	 void testGetPensionValidAadharWithTypeSelf() throws Exception {
		String token = "@token";
		ProcessPensionInput pensionerInput = new ProcessPensionInput(420559429029l);
		PensionDetail pensionDetail = new PensionDetail(24400, 550);
		Bank bank = new Bank("SBI", "private","4059586623");
		PensionerDetail pensionerDetail = new PensionerDetail(420559429029l, "Nabeel", LocalDate.of(1999, 12, 03),
				"BSDPS1495K", 29000, 1200, "self", bank);
		Mockito.when(pensionerDetailClient.getPensionerDetailByAadhaar(token, 420559429029l)).thenReturn(pensionerDetail);
		assertEquals(processPensionServiceImpl.processPension(token,pensionerInput),pensionDetail);
	}
	
	@Test
	 void testGetPensionValidAadharWithTypeFamily() throws Exception {
		String token = "@token";
		ProcessPensionInput pensionerInput = new ProcessPensionInput(420559429029l);
		PensionDetail pensionDetail = new PensionDetail(15700, 500);
		Bank bank = new Bank("SBI", "public","4059586623");
		PensionerDetail pensionerDetail = new PensionerDetail(420559429029l, "Nabeel", LocalDate.of(1999, 12, 03),
				"BSDPS1495K", 29000, 1200, "family", bank);
		Mockito.when(pensionerDetailClient.getPensionerDetailByAadhaar(token, 420559429029l)).thenReturn(pensionerDetail);
		assertEquals(processPensionServiceImpl.processPension(token,pensionerInput),pensionDetail);
	}

	@Test
	void testGetPensionInValidAadhar() throws Exception {
		String token = "@token";
		ProcessPensionInput pensionerInput = new ProcessPensionInput(420559429027l);
		new PensionDetail(24950, 550);
		Bank bank = new Bank("SBI", "private","4059586623");
		new PensionerDetail(420559429029l, "Nabeel", LocalDate.of(1999, 12, 03), "BSDPS1495K", 29000, 1200, "self",
				bank);
		assertNull(pensionerDetailClient.getPensionerDetailByAadhaar(token, pensionerInput.getAadharNumber()));
	}
	
}
