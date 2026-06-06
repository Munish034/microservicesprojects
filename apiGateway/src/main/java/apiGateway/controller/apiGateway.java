package apiGateway.controller;


import apiGateway.models.AuthResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class apiGateway {

    Logger logger = LoggerFactory.getLogger(apiGateway.class);
public ResponseEntity<AuthResponse> login(@RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient oAuth2AuthorizedClient, @AuthenticationPrincipal OidcUser oidcUser, Model  model) {

    logger.info("user email id : {} ", oidcUser.getEmail());

    //creating auth response object
    AuthResponse authResponse = new AuthResponse();

    //setting email to authresponse
    authResponse.setUserId(oidcUser.getEmail());

    //setting toke to auth response
    authResponse.setAccessToken(oAuth2AuthorizedClient.getAccessToken().getTokenValue());

    authResponse.setRefreshToken(oAuth2AuthorizedClient.getRefreshToken().getTokenValue());

    authResponse.setExpiresIn(oAuth2AuthorizedClient.getAccessToken().getExpiresAt().getEpochSecond());

    List<String> authorities = oidcUser.getAuthorities().stream().map(grantedAuthority -> {
        return grantedAuthority.getAuthority();
    }).collect(Collectors.toList());


    authResponse.setAuthorities(authorities);

    return new ResponseEntity<>(authResponse, HttpStatus.OK);

}
    @GetMapping("/test")
    public String apiGateway() {
        return "API Gateway Application Started";
    }
}
