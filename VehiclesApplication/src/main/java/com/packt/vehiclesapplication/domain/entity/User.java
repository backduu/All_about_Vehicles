package com.packt.vehiclesapplication.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "DT_USER")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "USER_SEQ", allocationSize = 1)
    @Column(name = "USER_SEQ")
    private Long userSeq;
    private String id;
    private String username;
    private String age;
    @Column(name="USER_TYPE")
    private String userType;
    private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "DT_AUTHORITIES",
            joinColumns = @JoinColumn(name = "SEQ")
    )
    @Column(name = "authority")
    private List<String> authority;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 리스트 형태로 권한을 반환한다.
        return authority.stream()
                .map(authority -> new SimpleGrantedAuthority(authority))
                .collect(Collectors.toList());
        //return Collections.singleton((GrantedAuthority) () -> authority);
    }

    public Boolean isAdmin() {
        return authority != null && authority.stream().anyMatch(authority -> authority.equals("ROLE_ADMIN"));
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
