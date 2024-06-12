package com.docinhos.webdev.models;


import java.util.Collection;
import java.util.UUID;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario") 
public class UserModel implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private UUID idUsuario; 

    @Column(nullable = false, length = 100) 
    private String nome;

    @Column(nullable = false, length = 14) 
    private String cpf;  

    @Column(nullable = false, length = 20) 
    private String telefone;  

    @Column(nullable = false, length = 255)
    private String endereco;

    @Column(nullable = false, length = 50)
    private String email; 

    @Column(nullable = false, length = 50, unique = true)
    private String username; 

    @Column(nullable = false, length = 60) 
    private String password;  
    
    @ManyToMany
    @JoinTable(name = "TB_USER_ROLES",
        joinColumns =  @JoinColumn(name = "idUduario"),
        inverseJoinColumns = @JoinColumn(name = "roleId") 
    )
    private List<RoleModel> roles;
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }
    @Override
    public String getPassword() {
       return this.password;
    }
    @Override
    public String getUsername() {
        return this.username;
    }
    @Override
    public boolean isAccountNonExpired(){
        return false;
    }
    @Override
    public boolean isAccountNonLocked(){
        return false;
    }
    @Override
    public boolean isCredentialsNonExpired(){
        return false;
    }
    @Override
    public boolean isEnabled(){
        return true;
    }
}
