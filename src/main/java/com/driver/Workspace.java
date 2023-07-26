package com.driver;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId);
        calendar = new ArrayList<>();

    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
           LocalTime start = meeting.getStartTime();
           LocalTime end = meeting.getEndTime();
        calendar.add(new Meeting(start, end));

    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am

             if(calendar.size()==0) return 0;
          int cntMeetings=0;
          Collections.sort(calendar, (a,b)->

                    a.getStartTime().compareTo(b.getEndTime())
                  );




                 LocalTime lastmeetEndDate=calendar.get(0).getEndTime();

                 int cnt=0;
                 int cnt1=calendar.size()-1;

                 for(int i=1; i<calendar.size(); i++)
                 {
                    Meeting m=calendar.get(i);

                    LocalTime cs = m.getStartTime();
                    LocalTime ce = m.getEndTime();

                    if(cs.compareTo(lastmeetEndDate)<0)
                    {
                        cnt++;
                        if(ce.compareTo(lastmeetEndDate)<0)
                            lastmeetEndDate=ce;
                    }
                    else
                        lastmeetEndDate=ce;


                 }

                 return calendar.size()-cnt;
    }
}
