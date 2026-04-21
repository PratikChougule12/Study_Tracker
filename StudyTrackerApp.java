import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.*;


class StudyLog
{
    private LocalDate Date;
    private String Subject;
    private double Duration;
    private String Description;
    
    public StudyLog(LocalDate a, String b, double c, String d)
    {
        this.Date = a;
        this.Subject = b;
        this.Duration = c;
        this.Description = d;
    }

    public LocalDate getDate()
    {
        return this.Date;
    }

    public String getSubject()
    {
        return this.Subject;
    }

    public double getDuration()
    {
        return this.Duration;
    }

    public String getDescription()
    {
        return this.Description;
    }

    @Override
    public String toString()
    {
        return Date+" | "+Subject+" | "+Duration+" | "+Description;
    }
}       // End of class StudyLog

class StudyTracker
{
    public ArrayList <StudyLog> Database = new ArrayList<StudyLog>();

    public void InsertLog()
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("---------------------------------------------------------------");
        System.out.println("-------------- Enter Valid Details of Your Study --------------");
        System.out.println("---------------------------------------------------------------");

        LocalDate Dateobj = LocalDate.now();

        System.out.println("Please enter the name of Subject like C/C++/Java/Python");
        String sub = sobj.nextLine();

        System.out.println("Enter the time period of your study in hours");
        double dur = sobj.nextDouble();
        sobj.nextLine();

        System.out.println("Please provide descritoption of your study");
        String desc = sobj.nextLine();

        StudyLog studyobj = new StudyLog(Dateobj, sub, dur, desc);

        Database.add(studyobj);

        System.out.println("Study Log gets stored Succefully");
        System.out.println("---------------------------------------------------------------");
    }

    public void DisplayLog()
    {
        System.out.println("---------------------------------------------------------------");

        if(Database.isEmpty())
        {
            System.out.println("------------------ Nothing To Display ----------------------");
            System.out.println("-------------------------------------------------------------");
            return;
        }


        System.out.println("-----------------og Repost of Study Tracker ------------------");
        System.out.println("---------------------------------------------------------------");

          for(StudyLog s: Database)
          {
                System.out.println(s);
          }

          System.out.println("---------------------------------------------------------------");
    }

    public void ExportCSV()
    {
        if(Database.isEmpty())
        {
            System.out.println("------------------------------------------------------------");
            System.out.println("------------------ Nothing To Export -----------------------");
            System.out.println("------------------------------------------------------------");
            return;
        }

        String Filename = "StudyTracker.csv";

        try(FileWriter fwobj = new FileWriter(Filename))
        {
            fwobj.write("Date,Subject,Duration,Description \n");
            
            for(StudyLog s:Database)
            {
                fwobj.write(    s.getDate()+","+
                                s.getSubject().replace(",", " ")+","+
                                s.getDuration()+","+
                                s.getDescription().replace(",", " ")+"/n"
                           );
            }

            System.out.println("Data gets Exported in csv :"+Filename);
        }
        catch(Exception eobj)
        {
            System.out.println("Exception occured in CSV Handling");
        }
    }

    public void SummaryByDate()
    {
        System.out.println("---------------------------------------------------------------");

        if(Database.isEmpty())
        {
            System.out.println("------------------ Nothing To Display ----------------------");
            System.out.println("-------------------------------------------------------------");
            return;
        }

       System.out.println("--------------Summary by Date from study tracker----------------");
       System.out.println("-------------------------------------------------------------------");

       TreeMap<LocalDate, Double>tobj = new TreeMap<LocalDate,Double>();

       LocalDate l = null;
       double d = 0.0,old = 0.0;

       for(StudyLog sobj: Database)
       {
            l = sobj.getDate();
            d = sobj.getDuration();

            if(tobj.containsKey(l))
            {
                old = tobj.get(l);
                tobj.put(l,d+old);
            }
            else
            {
                tobj.put(l,d);
            }
       }

       // Display the details as per subject 

       for(LocalDate da : tobj.keySet())
       {
            System.out.println("Date : "+da+" Total study Dusration "+tobj.get(da));
            
       }
       System.out.println("-------------------------------------------------------------------");

    }   

    public void SummaryBySubject()
    {
        System.out.println("---------------------------------------------------------------");

        if(Database.isEmpty())
        {
            System.out.println("------------------ Nothing To Display ----------------------");
            System.out.println("-------------------------------------------------------------");
            return;
        }

       System.out.println("--------------Summary by Subject from study tracker----------------");
       System.out.println("-------------------------------------------------------------------");

       TreeMap<String, Double>tobj = new TreeMap<String,Double>();

       String s = null;
       double d = 0.0,old = 0.0;

       for(StudyLog sobj: Database)
       {
            s = sobj.getSubject();
            d = sobj.getDuration();

            if(tobj.containsKey(s))
            {
                old = tobj.get(s);
                tobj.put(s,d+old);
            }
            else
            {
                tobj.put(s,d);
            }
       }

       // Display the details as per subject 

       for(String str : tobj.keySet())
       {
            System.out.println("Subject : "+str+"Total study Dusration"+tobj.get(str));
            
       }
       System.out.println("-------------------------------------------------------------------");

    }

}       // End of Class StudyTracker

class program902
{
    public static void main(String A[]) 
    {
        Scanner sobj = new Scanner(System.in);
        int iChoice = 0;
        
        StudyTracker stobj = new StudyTracker();

        System.out.println("=======================:: Wel-Come ::==========================");
        System.out.println("---------------------------------------------------------------");
        System.out.println("------------------------ Study Tracker ------------------------");
        System.out.println("---------------------------------------------------------------");

        do
        {
            System.out.println("Please Select your Option");
            System.out.println("1 : Inserte new Study Log");
            System.out.println("2 : View all study Log");
            System.out.println("3 : Export study log by date");
            System.out.println("4 : Summary of study log by Date");
            System.out.println("5 : Summary of study log by Subject");
            System.out.println("6 : Exite");

            iChoice = sobj.nextInt();

            switch (iChoice) 
            {
                // 
                case 1:
                    stobj.InsertLog();
                    break;

                case 2:
                    stobj.DisplayLog();
                    break;

                case 3:
                    stobj.ExportCSV();
                    break;

                case 4:
                    stobj.SummaryByDate();
                    break;

                case 5:
                    stobj.SummaryBySubject();
                    break;
                    
                case 6:
                    System.out.println("------------------------------------------------------------");
                    System.out.println("-------------- Thanks for using Study Tracker --------------");
                    System.out.println("------------------------------------------------------------");
                    
                default:
                    System.out.println("Please Enter valid Option");
                    break;
            }
        }
        while(iChoice != 6);    // end of do while

        sobj.close();
    }       // end of main
}       //end of starter class