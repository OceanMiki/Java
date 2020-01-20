import java.io.File;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main  
{  
    static Calendar begin, end;  
  
    public static void main(String[] args) throws Exception  
    {  
        Scanner s = new Scanner(new File("input.in"));  
        DateFormat f = new SimpleDateFormat("yyyy-MM-ddhh:mm:ss");  
        String[] firstLine = s.nextLine().split(" ");  
        begin = new GregorianCalendar();  
        begin.setTime(f.parse(firstLine[0] + firstLine[1]));  
        end = new GregorianCalendar();  
        end.setTime(f.parse(firstLine[2] + firstLine[3]));  
  
        ArrayList<Submission> submissions = new ArrayList<Submission>();  
        HashSet<String> nameSet = new HashSet<String>();  
        TreeSet<Integer> problemIDSet = new TreeSet<Integer>();  
  
        firstLine = s.nextLine().split(" ");  
        for (int i = 0; i < firstLine.length; i++)  
        {  
            problemIDSet.add(Integer.parseInt(firstLine[i]));  
        }  
  
        while (s.hasNext())  
        {  
            Submission cur = new Submission(s.nextLine().split(" "), f);  
            submissions.add(cur);  
            nameSet.add(cur.name);  
        }  
        s.close();  
        Collections.sort(submissions, (a, b) -> a.time.compareTo(b.time));;  
  
        TreeSet<User> userSet = new TreeSet<User>();  
        for (String name : nameSet)  
        {  
            User cur = new User(name, problemIDSet);  
            for (Submission submission : submissions)  
            {  
                if (name.equals(submission.name))  
                {  
                    if (begin.before(submission.time) && end.after(submission.time))  
                    {  
                        cur.omitted = false;  
                        cur.funcProblem(submission);  
                    }  
                }  
            }  
            userSet.add(cur);  
        }  
  
        userSet.removeIf(user -> user.omitted);  
  
        PrintWriter writer = new PrintWriter("output.out");  
          
        StringBuilder sb = new StringBuilder();  
        sb.append("Rank Name Solved ");  
        for (int id : problemIDSet)  
        {  
            sb.append(id).append(" ");  
        }  
        sb.append("Penalty");  
        writer.println(sb);  
  
        int t = 0;  
        DateFormat df = new SimpleDateFormat(":mm:ss");  
        for (User user : userSet)  
        {  
            sb = new StringBuilder();  
            t++;  
            sb.append(t).append(" ");  
            sb.append(user.name + " ");  
            sb.append(user.solvedNum).append(" ");  
  
            Calendar c = new GregorianCalendar();  
            for (int id : problemIDSet)  
            {  
                long time = user.problemMap.get(id);  
  
                if (time > 0)  
                {  
                    c.setTime(new Date(time));  
                    c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY) - 8);  
                    sb.append(c.get(Calendar.HOUR_OF_DAY) + c.get(Calendar.DAY_OF_MONTH) * 24 - 24);  
                    sb.append(df.format(c.getTime()));  
                } else  
                {  
                    sb.append(time);  
                }  
  
                sb.append(" ");  
            }  
  
            c.setTime(new Date(user.penalty));  
            c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY) - 8);  
            sb.append(c.get(Calendar.HOUR_OF_DAY) + c.get(Calendar.DAY_OF_MONTH) * 24 - 24);  
            sb.append(df.format(c.getTime()));  
  
            writer.println(sb);  
        }  
        writer.flush();  
        writer.close();  
    }  
}  
  
class Submission  
{  
    String name;  
    int problemID;  
    boolean accepted;  
    Calendar time;  
  
    public Submission(String[] src, DateFormat f) throws ParseException  
    {  
        name = src[1];  
        problemID = Integer.parseInt(src[2]);  
        accepted = (src[3].equals("Accepted")) ? true : false;  
        if (time == null)  
        {  
            time = new GregorianCalendar();  
        }  
        time.setTime(f.parse(src[7] + src[8]));  
    }  
}  
  
class User implements Comparable<User>  
{  
    String name;  
    HashMap<Integer, Long> problemMap;  
    int solvedNum;  
    long penalty;  
    boolean omitted;  
  
    public User(String name, Set<Integer> problemIDSet)  
    {  
        this.name = name;  
        problemMap = new HashMap<>();  
        for (int id : problemIDSet)  
        {  
            problemMap.put(id, 0L);  
        }  
        penalty = 0;  
        solvedNum = 0;  
        omitted = true;  
    }  
  
    public void funcProblem(Submission submission)  
    {  
        if(problemMap.get(submission.problemID) > 0)  
        {  
            return;  
        }  
        if (submission.accepted)  
        {  
            long curTime = submission.time.getTimeInMillis() - Main.begin.getTimeInMillis();  
  
            penalty += curTime - problemMap.get(submission.problemID) * 20 * 60 * 1000;  
            problemMap.put(submission.problemID, curTime);  
            solvedNum++;  
  
        }   
        else  
        {  
            problemMap.put(submission.problemID, problemMap.get(submission.problemID) - 1);  
        }  
    }  
  
    @Override  
    public int compareTo(User o)  
    {  
        if (this.solvedNum > o.solvedNum)  
        {  
            return -1;  
        }  
        else if (this.solvedNum < o.solvedNum)  
        {  
            return 1;  
        }   
        else  
        {  
            if (this.penalty < o.penalty)  
            {  
                return -1;  
            }   
            else if (this.penalty > o.penalty)  
            {  
                return 1;  
            }   
            else  
            {  
                return this.name.compareTo(o.name);  
            }  
        }  
    }  
}  
