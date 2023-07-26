package com.driver;

import java.util.ArrayList;
import java.util.Date;

public class Gmail extends Email {


    class Helper{
       Date date;
       String sender;
       String message;
       Helper(Date date, String sender, String message)
       {
           this.date=date;
           this.sender=sender;
           this.message=message;
       }
   }
    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)

    String emailId;
    ArrayList<Helper> inbox;
    ArrayList<Helper> trash;
    public Gmail(String emailId, int inboxCapacity) {
            super(emailId);
             this.inboxCapacity=inboxCapacity;
             inbox=new ArrayList<>();
             trash=new ArrayList<>();
    }

    public Gmail(String emailId) {
        super(emailId);
        this.inboxCapacity=Integer.MAX_VALUE;
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater t the dahan equal totes of mails received already.
           if(inbox.size()==inboxCapacity)
           {
                Helper h = inbox.remove(0);
                trash.add(h);
                inbox.add(new Helper(date, sender, message));
           }
           else
            inbox.add(new Helper(date, sender, message));



    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
              for(Helper h:inbox)
              {
                  if(h.message.equals(message))
                  {
                      trash.add(h);
                      inbox.remove(h);
                      break;
                  }
              }
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if(inbox.size()==0) return null;
        return inbox.get(inbox.size()-1).message;

    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(inbox.size()==0) return null;
        return inbox.get(0).message;

    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        if(inbox.size()==0) return 0;
            int cnt=0;
          for(int i=0; i<inbox.size(); i++)
          {
              Helper h =inbox.get(i);
              Date d =h.date;
              if(d.compareTo(start)>=0&&d.compareTo(end)<=0)
              {
                  cnt++;
              }
          }
         return cnt;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return inbox.size();

    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return trash.size();

    }

    public void emptyTrash(){
        // clear all mails in the tra
        trash.clear();

    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }
}
