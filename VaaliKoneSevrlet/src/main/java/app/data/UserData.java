package app.data;

import java.io.Serializable;

public class UserData implements Serializable{
         private int id;
         private String username;
         private String password;
         
         public String getUsername() {
        	 return username;
         }
         public void setUsername(String newUsername) {
        	 this.username = newUsername;
         }
         
         public String getPassword() {
        	 return password;
         }
         public void setPassword(String newPassword) {
        	 this.password = newPassword;
         }
         
}
