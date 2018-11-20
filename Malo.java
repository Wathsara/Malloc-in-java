/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author wathsara
 */
import java.util.Scanner;
import malloc.*;
public class Malo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Malloc mc = new Malloc();
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.print("Enter the Type  : ");
            String type= s.next();
            
            
            if(type.equals("a")){
                System.out.println("Memory Allocation");
                System.out.print("Enter the programe name : ");
                String pro=s.next();
                System.out.println("programe Name "+pro);
                System.out.print("Enter the Size of Program : ");
                int proS=s.nextInt();
                System.out.println("programe Size "+proS);
                mc.myMalloc(proS, pro);
                
            }
            else if(type.equals("f")){
                System.out.println("Memory Free");
                System.out.print("Enter the programe name : ");
                String pro=s.next();
                System.out.println(pro+"Program Cleared ");
                mc.myFree(pro);
                
                
            }else{
                return;
            }
        }
        
    }
    
}
