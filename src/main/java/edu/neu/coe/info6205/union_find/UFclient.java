package edu.neu.coe.info6205.union_find;
import java.util.Random;
public class UFclient {
    public static int count(int n){
        Random rand = new Random();
        int p = rand.nextInt(n);
        int q = rand.nextInt(n);
        UF u = new UF_HWQUPC(n);
        int count = 0;
        while(u.components()>1){
            if(p != q){
                if(u.isConnected(p,q) == false){
                    u.union(p,q);
                }
                count += 1;
            }

            p = rand.nextInt(n);
            q = rand.nextInt(n);

        }
        return count;
    }

//    public static boolean allConnected(UF u, int size){
//        for(int i = 1; i < size; i++){
//           if(u.isConnected(0,i) == false){
//               return false;
//           }
//        }
//        return true;
//    }



    public static void main(String[] args) {
        if (args.length == 0)
            throw new RuntimeException("Syntax: no argument");
        int n = Integer.parseInt(args[0]);
        for (int i =0; i < 6; i++){
            System.out.println("n = "+n+" conection = "+count(n));
            n = n*2;
        }


    }
}

