package br.com.casellisoftware.tocaform.services;

import br.com.casellisoftware.tocaform.dto.UserDTO;
import br.com.casellisoftware.tocaform.entities.User;
import br.com.casellisoftware.tocaform.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Transactional
    public UserDTO save(UserDTO userDTO){
        userDTO.setPassword(encoder.encode(userDTO.getPassword()));
        return UserDTO.toDto(userRepository.save(userDTO.toEntity()));
    }

    @Transactional
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }


    @Transactional(readOnly = true)
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByUsername(username).orElseThrow(() -> new IllegalArgumentException("Not found"));
    }
}
