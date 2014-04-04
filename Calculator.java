import java.util.*;
import static org.junit.Assert.*;

public class Calculator
{
    public static void main (String [] args)
    {
        int addition = add(5,2);
        int indices = power(20,5);
        System.out.println(addition);
        System.out.println(indices);
    }
    
    
    public static int add(int a,int b)
    {
        return a+b;
    }
    
    public static int subtract(int a,int b)
    {
        return a-b;
    }
    
    public static int multiply(int a,int b)
    {
        return a*b;
    }
    
    public static int divide(int a,int b)
    {
        if (b==0)
        {
            return -999;
        }
        else
            return a/b;
    }
    public static int power(int a, int b)
    {
    	if (b==0){
    		return 1;
    	}
    	if (b==1){
    		return a;
    	}
    	else{
    		return insidepower(a,a*a,b-1);
    	}
    }
    public static int insidepower(int multiplier, int value, int count)
    {
    	if (count == 1){
    		return value;
    	}
    	else{
    		return insidepower(multiplier,value*multiplier,count-1);
    	}
    }
}
