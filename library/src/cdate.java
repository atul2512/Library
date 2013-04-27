import java.*;
import java.util.*;
import java.io.*;

public class cdate{

public static String days[]={" ","sun","mon","tue","wed","thur","fri","sat"};
public static String month[]={"jan" ,"feb","march","april","may","june","july","aug","sep","oct","nov","dec"};
public static StringBuffer todaydate=new StringBuffer();
public static StringBuffer returndate=new StringBuffer();
public static StringBuffer todaydatee=new StringBuffer();;
public static StringBuffer returndatee=new StringBuffer();;
public static void main(String[] args){
cdate dddd=new cdate();
dddd.ccdate();

System.out.println(todaydate);
System.out.println(todaydatee);
System.out.println(returndate);
System.out.println(returndatee);

}


public void  ccdate(){

try{
//todaydate=new StringBuffer();
//returndate=new StringBuffer();

GregorianCalendar g=new GregorianCalendar();

int da=g.get(Calendar.DAY_OF_WEEK);
String daay=days[da];

int todate=g.get(Calendar.DAY_OF_MONTH);


int valofmonth=g.get(Calendar.MONTH);
String mon=month[valofmonth];

int valofyear=g.get(Calendar.YEAR);
//System.out.println(valofday);
//System.out.println(valofmonth);
//System.out.println(valofyear);
todaydate.append(daay +"-");
todaydate.append(todate);
todaydate.append("-"+mon);
todaydate.append("-"+valofyear);

todaydatee.append(todate);
todaydatee.append("-"+valofmonth);
todaydatee.append("-"+valofyear);
//System.out.println(todaydatee.toString());

g.add(Calendar.DAY_OF_MONTH,21);
int val=g.get(Calendar.DAY_OF_MONTH);

int valmonth=g.get(Calendar.MONTH);
int valyear=g.get(Calendar.YEAR);
//System.out.println(val);
//System.out.println(valmonth);
//System.out.println(valyear);

returndate.append(val);
returndate.append("-"+valmonth);
returndate.append("-"+valyear);
//System.out.println(returndate.toString());




}catch(Exception e){e.printStackTrace();}
}


}
