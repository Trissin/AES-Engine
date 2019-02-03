import java.util.*;
/**
 * Write a description of class TimeStamper here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TimeStamper
{
    public static void main (String [] args)
    {
       int millisecond, second, minute, hour;
       GregorianCalendar date = new GregorianCalendar();
      
       /*-----------------------------Timestamp before encrypting-------------------------------*/
       millisecond = date.get(Calendar.MILLISECOND);
       second = date.get(Calendar.SECOND);
       minute = date.get(Calendar.MINUTE);
       hour = date.get(Calendar.HOUR);
       System.out.println("Time before encryption is  "+ hour +" : " + minute + " : " + second + " : " + millisecond);
       /*---------------------------------------------------------------------------------------*/
      
      
      
      
      
       /*-----------------------------Timestamp after encrypting-------------------------------*/
       millisecond = date.get(Calendar.MILLISECOND);
       second = date.get(Calendar.SECOND);
       minute = date.get(Calendar.MINUTE);
       hour = date.get(Calendar.HOUR);
       System.out.println ("Time after encryption is "+ hour +" : " + minute + " : " + second + " : " + millisecond);
       /*---------------------------------------------------------------------------------------*/
    }
}
