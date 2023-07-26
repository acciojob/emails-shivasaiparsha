package com.driver;
import java.util.*;
public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public Email() {
        this.emailId = emailId;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character

          if(!oldPassword.equals(password)||newPassword.length()<8)
              return ;

          boolean checkUpperCase=checkingUpper(newPassword);
          boolean lowerCase=checkingLower(newPassword);
          boolean numbers=checkingNumbers(newPassword);
          boolean specialChar=checkingSpecialChar(newPassword);

          if(checkUpperCase&&lowerCase&&numbers&&specialChar)
          {
              password=newPassword;
          }

    }

    public boolean check(HashSet<Character> chset,String password)
    {
        for(int i=0; i<password.length(); i++)
        {
            char c=password.charAt(i);
            if(chset.contains(c)) return true;
        }
        return false;
    }

    public boolean checkingUpper(String password)
    {
        HashSet<Character> set = new HashSet<>();

          for(char c='A'; c<='Z'; c++)
          {
              set.add(c);
          }

          return check(set, password);
    }

    public boolean checkingLower(String pass)
    {
        HashSet<Character> set = new HashSet<>();

        for(char c='a'; c<='z'; c++)
        {
            set.add(c);
        }
        return check(set, password);
    }
    public boolean checkingNumbers(String pass)
    {
        HashSet<Character> set = new HashSet<>();

        for(char c='0'; c<='9'; c++)
        {
            set.add(c);
        }
        return check(set, password);
    }
    public boolean checkingSpecialChar(String pass)
    {
        HashSet<Character> uppercharset = new HashSet<>();
        for(char c='A'; c<='Z'; c++)
            uppercharset.add(c);

        HashSet<Character> lowerCharset = new HashSet<>();
        for(char c='a'; c<='z'; c++)
            lowerCharset.add(c);

        HashSet<Character> numberset = new HashSet<>();
        for(char c='0'; c<='9'; c++)
            numberset.add(c);

          for(int i=0; i<pass.length(); i++)
          {
              char c=pass.charAt(i);
              if(!lowerCharset.contains(c)&&!uppercharset.contains(c)&&!numberset.contains(c))
                  return true;
          }
        return false;
    }

}
