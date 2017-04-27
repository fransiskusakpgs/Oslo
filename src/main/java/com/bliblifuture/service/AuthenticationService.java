package com.bliblifuture.service;

import com.bliblifuture.model.User;
import com.bliblifuture.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    // Untuk memastikan apakah pada session tertentu ada user yang sedang login atau tidak
    public boolean isLoggedIn() {
        // User yang sedang login disimpan didalam SecurityContextHolder
        // getAuthentication mengembalikan sebuah class Authentication yang memiliki fungsi isAuthenticated
        // Fungsi is Authenticated inilah yang mengembalikan sebuah boolean untuk mengetahui
        //      apakah user yang sudah login itu terauthentifikasi atau tidak
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        boolean loggedIn = auth.isAuthenticated() &&
                // Spring memiliki opsi untuk login sebagai anonim
                // Untuk memastikan bahwa yang login itu bukan anonim
                !(auth instanceof AnonymousAuthenticationToken);
        return loggedIn;
    }

    // Untuk mendapatkan user yang sedang login dan telah terautentifikasi
    public User getAuthenticatedUser() {
        // Jika ada user yang sedang login (isLoggedIn() bernilai true) maka dapatkan usser
        // User yang telah terautentifikasi tersimpan didalam class Authentication.
        // Untuk mengakses usernamenya digunakan fungsi .getName()
        if (isLoggedIn()) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            return userRepository.findByUsername(auth.getName());
        }
        return null;
    }
}