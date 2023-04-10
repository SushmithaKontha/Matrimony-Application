package com.matrimony;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.matrimony.dao.RoleDao;
import com.matrimony.entity.Role;
import com.matrimony.service.RoleService;

@SpringBootTest
public class RoleServiceTest {

    @Mock
    private RoleDao roleDao;
    
    @InjectMocks
    private RoleService roleService;
    
    @Test
    public void testCreateNewRole() {
        // Arrange
        Role role = new Role();
        role.setRoleName("TEST_ROLE");
        when(roleDao.save(role)).thenReturn(role);
        
        // Act
        Role createdRole = roleService.createNewRole(role);
        
        // Assert
        assertThat(createdRole).isNotNull();
        assertThat(createdRole.getRoleName()).isEqualTo("TEST_ROLE");
    }
    
}
