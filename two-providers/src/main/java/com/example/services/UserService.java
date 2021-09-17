package com.example.services;

import com.example.models.User;
import com.example.repositories.UserRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Service
public class UserService extends AbstractService<User> {
    private Map<String, AuthenticationProviderMapper> authProviderToUserMap =new HashMap<String,AuthenticationProviderMapper>() {{

        put("google",  principal -> new User(principal.getAttribute("name"), principal.getAttribute("email"),
                                             principal.getAttribute("locale"), new Date()));

        put("github",  principal -> new User(principal.getAttribute("login"), principal.getAttribute("login")+"@github.com",
                                             principal.getAttribute("locale"), new Date()));
    }};



 //   @Autowired
    public UserService(UserRepository mainRepository) {
        super(mainRepository);
    }

    public User update(User user){
        if(user.getId() !=null){
            Optional<User> optOldUser = mainRepository.findById(user.getId());
            if(optOldUser.isPresent()){
                User oldUser = optOldUser.get();

                oldUser.setFullname(user.getFullname()) ;
                oldUser.setEmail(user.getEmail()) ;
                oldUser.setLocale(user.getLocale()); ;
                return ((User) mainRepository.save(oldUser));
            }
        }
        return ((User) mainRepository.save(user));
    }


    public User getUserFromPrincipal(OAuth2User principal){
        // TODO : get issuer directly from principal
        String authProviderName = principal.getAttribute("iss") == null ? "github" : "google";
        Optional<AuthenticationProviderMapper> authProviderMapperOpt = Optional.ofNullable(this.authProviderToUserMap.get(authProviderName));
        if(authProviderMapperOpt.isPresent()){
            return authProviderMapperOpt.get().getUser(principal);
        }
        throw new SecurityException("Unable to determine the correct authentication provider");
    }

    interface AuthenticationProviderMapper{
        User getUser(OAuth2User principal);
    }

}


