import java.util.*;
import java.io.*;
public class Main
{
    static int gcd(int m,int n)
    {
        int r=m%n;
        m=n;
        n=r;
        return m;
        
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int p=0,q=0,e=0,n=0,d=0,phi=0;
        int i=0,j=0,nofelem=0;
        int nummes[]=new int[100];
        int encrypted[]=new int[100];
        int decrypted[]=new int[100];
        System.out.println("enter the message to be encrypted");
        String message=sc.nextLine();
        System.out.println("enter p and q");
        p=sc.nextInt();
        q=sc.nextInt();
        n=p*q;
        phi=(p-1)*(q-1);
        for(i=2;i<phi;i++)
        
            if(gcd(i,phi)==1)
            break;
        e=i;
        for(i=2;i<phi;i++)
        
            if((e*i-1)%phi==0)
            break;
        d=i;
        
        for(i=0;i<message.length();i++)
        {
            char c=message.charAt(i);
            int a=(int)c;
            nummes[i]=c-96;
            
        }
        
    System.out.println("num mes is ");
    for(i=0;i<message.length();i++)
    {
        System.out.println(nummes[i]);
    }
    nofelem=message.length();
    for(i=0;i<nofelem;i++)
    {
        encrypted[i]=1;
        for(j=0;j<e;j++)
        encrypted[i]=(encrypted[i]*nummes[i])%n;
        
    }
    System.out.println("encrypted message is");
    
    for(i=0;i<nofelem;i++)
    {
      System.out.print(encrypted[i]+"\t");
      System.out.println((char)(encrypted[i]+96));
    }
    
    for(i=0;i<nofelem;i++)
    {
        decrypted[i]=1;
        for(j=0;j<d;j++)
        decrypted[i]=(decrypted[i]*encrypted[i])%n;
        
    }
    System.out.println("decrypted message is");
    
    for(i=0;i<nofelem;i++)
    {
      System.out.print((char)(decrypted[i]+96));
    }   
     return;
    }
}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
       