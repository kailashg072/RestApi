package BikeRepair.Services;

import BikeRepair.Controller.repository.RegistrationRepo;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import BikeRepair.Controller.entity.UserData;
import org.springframework.stereotype.Service;

@Service("UserDetailsService")
public class customUserDetailService implements UserDetailsService {

    @Autowired
    RegistrationRepo registrationRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserData user = registrationRepo.findByUsername(username).orElseThrow(()-> new ResourceNotFoundException("user not found"));
        System.out.println(user);
        GrantedAuthority  authorities = (GrantedAuthority) () -> "admin";
       return user;
       //return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), (Collection<? extends GrantedAuthority>) authorities);
       // return new org.springframework.security.core.userdetails.    (user.getUsername() ,user.getPassword());

    }
}
