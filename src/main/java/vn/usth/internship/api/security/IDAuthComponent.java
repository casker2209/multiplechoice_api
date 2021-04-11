package vn.usth.internship.api.security;


import org.springframework.stereotype.Component;

@Component
public class IDAuthComponent {
    public boolean hasIDPermission(User user,String id){
        if(user.getId().equals(id)){
            return true;
        }
        return false;
    }
}
