//package pl.akademiaspecjalistowit.podstawyspringsecurity.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import java.util.HashSet;
//
//
//@Getter
//@NoArgsConstructor
//@Entity(name = "users")
//public class UserEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String username;
//    private String password;
//    private boolean enabled;
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "user_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//
//    private Set<RoleEntity> roles = new HashSet<>();
//
//
//    public UserEntity(String username, String password, boolean enabled, Set<RoleEntity> roles) {
//        this.username = username;
//        this.password = password;
//        this.enabled = enabled;
//        this.roles = roles;
//    }
//
//}
