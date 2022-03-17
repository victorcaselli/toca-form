package br.com.casellisoftware.tocaform.services;

import br.com.casellisoftware.tocaform.dto.ReleaseGateDTO;
import br.com.casellisoftware.tocaform.dto.UserDTO;
import br.com.casellisoftware.tocaform.entities.Doorman;
import br.com.casellisoftware.tocaform.entities.Role;
import br.com.casellisoftware.tocaform.entities.User;
import br.com.casellisoftware.tocaform.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final DoormanService doormanService;

    @Transactional
    public UserDTO save(UserDTO userDTO){
        userDTO.setPassword(encoder.encode(userDTO.getPassword()));
        return UserDTO.toDto(userRepository.save(userDTO.toEntity()));
    }

    @Transactional
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    @Transactional
    public void releaseGate(ReleaseGateDTO rgDTO){

        if(doormanService.findByTime().getFree()) {
            throw new IllegalArgumentException("There is already a release gate created");
        }

        this.doormanService.save(
                Doorman.builder()
                        .createAt(LocalDateTime.now())
                        .startDate(rgDTO.getStartDate())
                        .endDate(rgDTO.getEndDate())
                        .free(true)
                        .build()
        );
    }


    @Transactional(readOnly = true)
    public Optional<User> findByUsername(String username){
        Optional<User> user = userRepository.findByUsername(username);

        if(user.isPresent()) {
            for(Role role : user.get().getRoles()) {
                System.out.println(doormanService.findByTime().getFree());
                if(role.getAuthority().equals("ROLE_DOORMAN") && doormanService.findByTime().getFree()) {
                    return userRepository.findByUsername(username);
                }else if(role.getAuthority().equals("ROLE_DOORMAN")) {
                    return Optional.empty();
                }
            }
        }

        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByUsername(username).orElseThrow(() -> new IllegalArgumentException("Not found"));
    }

}
