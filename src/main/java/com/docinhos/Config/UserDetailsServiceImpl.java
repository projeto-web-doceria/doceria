package com.docinhos.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.docinhos.webdev.models.UserModel;
import com.docinhos.webdev.repositories.UserRepository;

@Service
@Transactional  
public class UserDetailsServiceImpl implements UserDetailsService {

    final
    UserRepository userRepository;
    
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Usuário nã encontrado: "+username));
        
        return new User(userModel.getUsername(), userModel.getPassword(), false, false, false, false, userModel.getAuthorities());
    }
    
}
