package br.com.casellisoftware.tocaform.config;

import br.com.casellisoftware.tocaform.entities.User;
import br.com.casellisoftware.tocaform.repositories.UserRepository;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenEnhancer implements TokenEnhancer {

	private final UserRepository userRepository;
	
	public JwtTokenEnhancer(UserRepository userRepository) {
		this.userRepository = userRepository; 
		
	}
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

		User user = userRepository.findByUsername(authentication.getName()).get();

		
		Map<String, Object> map = new HashMap<>();
		map.put("userEmail", user.getUsername());
		map.put("userId", user.getId());
		map.put("role", user.getAuthorities());

		DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;
		token.setAdditionalInformation(map);
		
		return accessToken;
	}
}