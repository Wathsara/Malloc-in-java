/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malloc;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author wathsara
 */
public class Malloc {

    /**
     * @param args the command line arguments
     */
    public byte buf[] = new byte[25000];
    Map<String, Integer> mapindex = new HashMap<String, Integer>();
    Map<String, Integer> mapsize = new HashMap<String, Integer>();
    Map<Integer, Integer> mapbest = new HashMap<Integer, Integer>();
    ArrayList<Integer> sizer = new ArrayList<>();

    public void myMalloc(int a, String name) {
        int ss = 0;
        for (int i = 0; i < buf.length ; i++) {
            if(buf[i]==0){
                ss++;
            }
            
        }
        
        for (int i = 0; i < buf.length - a; i++) {
            int count = 0;

            for (int j = i; j < buf.length; j++) {
                if (buf[j] == 0) {
                    count++;
                    if (j == buf.length - 1) {
                        mapbest.put(count, i);
                        sizer.add(count);
                        count = 0;
                        i = j+1;
                        break;
                    }
                } else if (count >= a) {
                    mapbest.put(count, i);
                    sizer.add(count);
                    count = 0;
                    i = j-1;
                    break;
                } else {
                    i = j+1;
                }

            }

        }
        Collections.sort(sizer);
        
        if(sizer.size()>0){
        for (int j = mapbest.get(sizer.get(0)); j < mapbest.get(sizer.get(0)) + a; j++) {

            buf[j] = 1;
        }
        
        mapindex.put(name, mapbest.get(sizer.get(0)));
        mapsize.put(name, a);
        System.out.println("Allocated at the index " + mapbest.get(sizer.get(0))+" to "+(mapbest.get(sizer.get(0))+a-1));

        }else{
          System.out.println("No way to Allocate As Memory doesnt has space to allocate");
          
        }
        sizer.clear();
    }

    public void myFree(String name) {

        for (int i = mapindex.get(name); i < mapindex.get(name) + mapsize.get(name); i++) {
            buf[i] = 0;
        }

    }

}

