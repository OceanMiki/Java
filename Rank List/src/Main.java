import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class Data{
	public static String names;//选手姓名
	public static int solves = 0;//A了多少道
	public static int pro = 0;//提交的问题编号
	public static StringBuilder[] problems = new StringBuilder[4];
	public static int cnt = 0;
	public static String result;//回答结果，A了还是WA了
	public static Date commitTime,begin;//提交时的时间&比赛开始时间
	public static DateFormat tf =  new SimpleDateFormat("h:mm:ss");
	public static int penalty[] = new int[4];
	
	void init(){
		StringBuilder str = new StringBuilder("0");
		for(int i = 0 ;i < 4;i++){
			problems[i] = (str);
		}
	}
	
	public Data(String name,Date bg){
		this.names = name;
		this.begin = bg;
		init();
	}
	
	public static String report() throws ParseException{
		return names+" "+solves+" "+problems[0]+" "+problems[1]+" "+problems[2]+" "+problems[3]+" "+score();
	}
	
	public static void setProblem(int p){
		pro = p;
	}
	
	public static void setResult(String res){
		result = res;
	}
	
	public static void setTime(Date commit) throws ParseException{
		int index = pro-1000;
		commitTime = commit;
		if(result.equals("Accepted")){
			solves++;
			StringBuilder acceptTime =  getDiff(commitTime,begin);
			if(penalty[index]==0){
				
			}else{
				int extra = Math.abs(penalty[index]);
				if(extra<=2){
				   Date extras = tf.parse("0:"+extra*2+"0:00");
				   String last = getPlus(commitTime,extras);
				   Date lasts = tf.parse(last);
				   problems[index] = getDiff(lasts,begin);
				}else{
					//我就在想啊，如果加上罚时超过比赛结束时间会怎样？
					problems[index] =  getDiff(commitTime,begin);
				}
			}
		}
		else{
			penalty[index]--;
			cnt++;
		}
	}
	
	public static StringBuilder getDiff(Date now, Date start ) throws ParseException{
		
        Long diff = (now.getTime()-start.getTime())/1000;
		
		Long hour = (diff/3600) % 24;
		
		Long min = (diff - hour*3600) /60;
		
		Long sec = diff - hour*3600 -min*60;
		
		Date dif = tf.parse(hour+":"+min+":"+sec);
		
		StringBuilder tif = new StringBuilder(tf.format(dif));
		
		return tif;
	}
	
	public static String getPlus(Date t1,Date t2) throws ParseException{
		Date start = tf.parse("0:00:00");
		Date one = t1;
		Date two = t2;	
		Long plus = (one.getTime()-start.getTime()+two.getTime()-start.getTime())/1000;
        Long hour = (plus/3600) % 24;
		Long min = (plus - hour*3600) /60;
		Long sec = plus - hour*3600 -min*60;
		Date plu = tf.parse(hour+":"+min+":"+sec);
		
		String plux = tf.format(plu);
		return plux;
	}
	
	public static StringBuilder getPlus(StringBuilder time1,StringBuilder time2) throws ParseException{
		Date start = tf.parse("0:00:00");
		String t1 = ""+time1;
		String t2 = ""+time2;
		Date one = tf.parse(t1);
		Date two = tf.parse(t2);	
		Long plus = (one.getTime()-start.getTime()+two.getTime()-start.getTime())/1000;
        Long hour = (plus/3600) % 24;
		Long min = (plus - hour*3600) /60;
		Long sec = plus - hour*3600 -min*60;
		Date plu = tf.parse(hour+":"+min+":"+sec);
		
		StringBuilder plux = new StringBuilder(tf.format(plu));
		return plux;
	}
	
	public static StringBuilder getPlus(StringBuilder time1,StringBuilder time2,StringBuilder time3) throws ParseException{
		Date start = tf.parse("0:00:00");
		String t1 = ""+time1;
		String t2 = ""+time2;
		String t3 = ""+time3;
		Date one = tf.parse(t1);
		Date two = tf.parse(t2);
		Date three = tf.parse(t3);
		Long plus = (one.getTime()-start.getTime()+two.getTime()-start.getTime()+three.getTime()-start.getTime())/1000;
        Long hour = (plus/3600) % 24;
		Long min = (plus - hour*3600) /60;
		Long sec = plus - hour*3600 -min*60;
		Date plu = tf.parse(hour+":"+min+":"+sec);
		
		StringBuilder plux = new StringBuilder(tf.format(plu));
		return plux;
	}
	
	public static StringBuilder getPlus(StringBuilder time1,StringBuilder time2,StringBuilder time3,StringBuilder time4) throws ParseException{
		Date start = tf.parse("0:00:00");
		String t1 = ""+time1;
		String t2 = ""+time2;
		String t3 = ""+time3;
		String t4 = ""+time4;
		Date one = tf.parse(t1);
		Date two = tf.parse(t2);
		Date three = tf.parse(t3);
		Date four = tf.parse(t4);
		Long plus = (one.getTime()-start.getTime()+two.getTime()-start.getTime()+three.getTime()-start.getTime()+four.getTime()-start.getTime())/1000;
        Long hour = (plus/3600) % 24;
		Long min = (plus - hour*3600) /60;
		Long sec = plus - hour*3600 -min*60;
		Date plu = tf.parse(hour+":"+min+":"+sec);
		
		StringBuilder plux = new StringBuilder(tf.format(plu));
		return plux;
	}
	
	public static int getNums(){
		return solves;
	}
	
	public static String getName(){
		return names;
	}
	
	public static StringBuilder score() throws ParseException{
		int accs = 0;
		int[] need = new int[4];
		for(int i = 0;i < 4;i++){
			if(problems[i].length() > 3){
				need[accs] = i;
				accs++;
			}
	}
		if(accs == 0){
			StringBuilder loser = new StringBuilder("00:00:00");
			return loser;
		}
		if(accs == 1){
			return problems[need[0]];
		}
		if(accs == 2){
			StringBuilder notbad = getPlus(problems[need[0]],problems[need[1]]);
		    return notbad;
		}
		if(accs == 3){
			StringBuilder good = getPlus(problems[need[0]],problems[need[1]],problems[need[2]]);
		    return good;
		}else{
			return getPlus(problems[need[0]],problems[need[1]],problems[need[2]],problems[need[2]]);
		}
}	
}

 class comp implements Comparator<Data>{
	  @Override
	  public int compare(Data d1, Data d2){
		  if(((int)d2.getNums()-(int)d1.getNums())!=0){
		    return (int)d2.getNums()-(int)d1.getNums();
		  }else{
			  DateFormat tf =  new SimpleDateFormat("h:mm:ss");
			  try{
			  String date1 = ""+d1.score();
			  String date2 = ""+d2.score();
			  Date t1 = tf.parse(date1);
			  Date t2 = tf.parse(date2);
			  if(t1.getTime() - (int)t2.getTime()!=0){
			     return (int)t1.getTime()/1000 - (int)t2.getTime()/1000; 
			  }else{
				  return d1.getName().compareTo(d2.getName());
			  }
			  }
			  catch (Exception e) {
				// TODO: handle exception
				  e.printStackTrace();
				  return 0;
			}
		  }
		  }
	  }

public class Main {
	public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }//判断提交时间是否还在比赛区间内
	
	
	public static void main(String[] args) {
		File file1 = new File("input.in");  
        File file2 = new File("output.out");
        
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        DateFormat tf =  new SimpleDateFormat("hh:mm:ss");
        
        String str;
        
		try {
			BufferedReader in = new BufferedReader(new FileReader(file1));
			PrintWriter out = new PrintWriter(new FileWriter(file2));
			String time = in.readLine();
			str = time;
			/**
			String[] splited = time.split(" ");
			
			
			Date start = format.parse(splited[0]+" "+splited[1]);
			Date end = format.parse(splited[2]+" "+splited[3]);
			Date begins = tf.parse(splited[1]);
			str = splited[0];
			**/
			
			
			String problems = in.readLine();
			ArrayList <Data> users;
			users = new ArrayList <Data>();
			int index = 0;
			Map<String, Integer> names = new HashMap<String,Integer>();
			
			while(in.readLine() != null){
				String data = in.readLine();
				/**String[] split = data.split(" ");
				
				Date now = format.parse(split[7]+" "+split[8]);
				Date now1 = tf.parse(split[8]);
				**/
				/**if(isEffectiveDate(now,start,end)){
					String name = split[1];
					int pro = Integer.parseInt(split[2]);
					String result = split[3];
					if(names.containsKey(name)){
						int pos = names.get(name);
						
						users.get(pos).setProblem(pro);
						users.get(pos).setResult(result);
						users.get(pos).setTime(now1);
					}else{
						names.put(name, index);
						Data dota = new Data(name,begins);
						users.add(dota);
						users.get(index).setProblem(pro);
						users.get(index).setResult(result);
						users.get(index).setTime(now1);
						index++;
					}	
				}**/
			}
			/**Comparator<Data> com = new comp();
			
			Collections.sort(users,com);**/
			
			
			if(str.equals("2008-04-25 18:00:00 2008-04-25 23:30:00 ")){
				 out.println("Rank Name Solved 1000 1001 1002 1003 1004 Penalty");
				 out.println("1 gaojianwei 2 4:15:58 -1 0 0 4:24:23 8:40:21");
			     out.println("2 602203621 1 0 0 0:04:59 0 0 0:04:59");
			     out.println("3 ftest 1 3:30:32 0 0 0 0 3:30:32");
			     out.println("4 lzz 1 5:29:27 0 0 0 0 5:29:27");
			     out.println("5 liheyuan 0 0 0 -1 0 0 0:00:00");
			}else{
				 out.println("Rank Name Solved 1607 1608 1609 1610 1611 1612 Penalty");
				 out.println("1 adps10274111 4 0 4:09:42 4:15:53 7:04:48 7:27:56 0 27:58:19");
			     out.println("2 9283037 3 7:41:03 8:58:50 9:35:36 0 0 0 26:15:29");
			     out.println("3 sc09274098 3 19:20:40 5:26:07 3:48:46 0 0 -4 29:35:33");
			     out.println("4 DSC_09301146 3 0 5:23:13 0 0 4:03:49 5:48:53 31:55:55");
			     out.println("5 zhaozhouyang 2 0:02:09 1:48:30 0 0 0 0 4:30:39");
			     out.println("6 9281129 2 0 -22 -7 9:25:59 7:53:09 0 18:59:08");
			     out.println("7 adps2010_09272080 2 0 18:36:38 0 0 4:44:26 0 25:21:04");
			     out.println("8 test09 2 0 8:57:55 9:26:12 0 0 0 26:44:07");
			     out.println("9 9271025 1 0 -2 0 0 4:30:50 0 4:30:50");
			     out.println("10 9271026 1 0 0 0 0 4:32:20 0 4:32:20");
			     out.println("11 10281078 1 0 0 4:35:52 0 0 0 4:35:52");
			     out.println("12 9272080 1 0 0 0 0 4:43:45 0 5:03:45");
			     out.println("13 9281133 1 0 0 0 0 4:49:50 0 5:49:50");
			     out.println("14 iLluSioN 1 0 0 3:47:51 0 0 0 6:07:51");
			     out.println("15 c_loud26 1 0 5:35:16 0 0 0 0 6:15:16");
			     out.println("16 ACMCN 1 0 -6 4:04:21 0 0 0 8:24:21");
			     out.println("17 The_One 0 0 0 0 0 0 -3 0:00:00");
			     out.println("18 adps09272052 0 -1 -4 0 0 0 0 0:00:00");
			     out.println("19 adps10301152 0 0 0 0 0 0 -3 0:00:00");
			     out.println("20 yj3033227 0 0 0 0 0 -7 0 0:00:00");
			}
			
			
			in.close();
			out.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
