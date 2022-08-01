package com.example.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.threeten.bp.OffsetDateTime;

import com.example.configuration.CreditCardValidation;
import com.example.model.CreditCard;
import com.example.service.CreditCardServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-07-30T16:46:59.619Z[GMT]")
@RestController
public class CreditcardApiController implements CreditcardApi {

    private static final Logger log = LoggerFactory.getLogger(CreditcardApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private CreditCardServiceImpl creditCardServiceImpl;
    
    @org.springframework.beans.factory.annotation.Autowired
    public CreditcardApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addCreditCard(@Parameter(in = ParameterIn.HEADER, description = "RequestID is a unique identifier that is unique for a single request/response message and will be used to track consumer's request  through the system. UUID specification (RFC 4122, ITU-T Rec. X.667),used for auditing, and returned in the response. " ,required=true,schema=@Schema()) @RequestHeader(value="RequestID", required=true) String requestID,@Parameter(in = ParameterIn.HEADER, description = "Used to reflect the time when the message was created." ,required=true,schema=@Schema()) @RequestHeader(value="RequestTimestamp", required=false) OffsetDateTime requestTimestamp,@Parameter(in = ParameterIn.HEADER, description = "Identifies the originator System of the Business Process." ,required=true,schema=@Schema()) @RequestHeader(value="OriginatorID", required=true) String originatorID,@Parameter(in = ParameterIn.HEADER, description = "Application ID to identify the applicant." ,required=true,schema=@Schema()) @RequestHeader(value="AppID", required=true) String appID,@Parameter(in = ParameterIn.DEFAULT, description = "Request body for the service request", schema=@Schema()) @Valid @RequestBody CreditCard body) {
        String accept = request.getHeader("Accept");
        System.out.println(" The request payload, "+body.toString());
        if (accept != null && accept.contains("application/json")) {
			try {
				if (null != body.getCardNumber() && CreditCardValidation.luhnTest(body.getCardNumber())) {
					creditCardServiceImpl.saveCard(body);
					System.out.println("after save call");
					return new ResponseEntity<Void>(HttpStatus.CREATED);
				} else {
					System.out.println("Invalid card number not allowed to store"+body.getCardNumber());
					return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
				}
			} catch (Exception e) {
				  log.error("Throwable error from the system.",
				  e); return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR); 
			} catch (Throwable e) {
                log.error("Unexpected exception occurred", e);
                return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<List<CreditCard>> getAllCreditCards(@Parameter(in = ParameterIn.HEADER, description = "RequestID is a unique identifier that is unique for a single request/response message and will be used to track consumer's request  through the system. UUID specification (RFC 4122, ITU-T Rec. X.667),used for auditing, and returned in the response. " ,required=true,schema=@Schema()) @RequestHeader(value="RequestID", required=true) String requestID,@Parameter(in = ParameterIn.HEADER, description = "Used to reflect the time when the message was created." ,required=true,schema=@Schema()) @RequestHeader(value="RequestTimestamp", required=false) OffsetDateTime requestTimestamp,@Parameter(in = ParameterIn.HEADER, description = "Identifies the originator System of the Business Process." ,required=true,schema=@Schema()) @RequestHeader(value="OriginatorID", required=true) String originatorID,@Parameter(in = ParameterIn.HEADER, description = "Application ID to identify the applicant." ,required=true,schema=@Schema()) @RequestHeader(value="AppID", required=true) String appID) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	List<CreditCard> creditCards = creditCardServiceImpl.getAllCreditCards();
            	 ObjectMapper mapperObj = new ObjectMapper();
            	String creditCardsString = mapperObj.writeValueAsString(creditCards);
                return new ResponseEntity<List<CreditCard>>(objectMapper.readValue(creditCardsString, List.class), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<CreditCard>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<CreditCard>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
