package com.bliblifuture.security;

import com.bliblifuture.model.UserRole;
import com.bliblifuture.repository.UserRepository;
import com.bliblifuture.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Profile(value={"development"})
class SecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    UserRepository userRepo;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    UserDetailsService userDetailsService() {
        return new UserDetailsService() {

            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                // Mencari user dari username melalui repository
                com.bliblifuture.model.User user = userRepo.findByUsername(username);
                // Mencari role user dari user yang telah didapatkan sebelumnya
                UserRole userRoleList = userRoleRepository.findByUsername(user.getUsername());
                // Membuat list granted authority: yang akan dicocokkan dengan input user oleh spring security
                List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
                // Untuk setiap user role dalam list user role, dimasukkan kedalam grantedAuthority list menggunakan
                // class Simple Granted Authority
//                for (UserRole userRole: userRoleList) {
                    grantedAuthorityList.add(new SimpleGrantedAuthority(userRoleList.getRole()));
//                }
                // Jika usernya ditemukan maka kembalikan:
                if(user != null) {

                    return new User(user.getUsername(), user.getPassword(),
                            true, true, true, true,
                            grantedAuthorityList);
                } else {
                    // Jika user tidak ditemukan kembalikan:
                    throw new UsernameNotFoundException("could not find the user '"
                            + username + "'");
                }
            }

        };
    }
}
