package com.matrimony;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;

import com.matrimony.dao.UserDao;
import com.matrimony.entity.JwtRequest;
import com.matrimony.entity.JwtResponse;
import com.matrimony.entity.Role;
import com.matrimony.entity.User;
import com.matrimony.service.JwtService;
import com.matrimony.util.JwtUtil;

@RunWith(MockitoJUnitRunner.class)
public class JwtTests {

	
}
	  
	   
