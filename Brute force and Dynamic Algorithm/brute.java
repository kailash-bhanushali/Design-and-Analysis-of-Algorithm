import java.util.Scanner;
import java.util.concurrent.TimeUnit;
class brute {
    String result=" ";
        boolean searchLoop(String[] strings, String searchString) {
            for (int i=0;i<strings.length;i++) {
                if (strings[i] != null && !strings[i].isEmpty())
                    if (strings[i].equals(searchString)){
                        return false;
                    }             
            }
            return true;
        }
        public void brute(String cases, String e){
            String[] index=new String[cases.length()];
            int indexcounter=0;
            String tempi= " ";           
            if(cases != " "){
            for(int k=0;k<cases.length()-1;k++){
                if(String.valueOf(cases.charAt(k)) != null && !String.valueOf(cases.charAt(k)).isEmpty()){
                int count = 0;
                    for(int l=k + 1;l<e.length();l++){
                        if(String.valueOf(e.charAt(l)) != null && !String.valueOf(e.charAt(l)).isEmpty()){    
                              if(((cases.contains(String.valueOf(l)) == false) && (searchLoop(index, String.valueOf(l)) != false ) && (searchLoop(index, String.valueOf(cases.charAt(k))) != false ))){
                                   if(String.valueOf(e.charAt(Integer.valueOf(String.valueOf(cases.charAt(k+1))))).equals(String.valueOf(e.charAt(l))) && (count ==0)){
                                    tempi=tempi+String.valueOf(e.charAt(l));
                                    count = 1;
                                    index[indexcounter] = String.valueOf(l);
                                    indexcounter++;
                                  }
                              }
                        }
                    }
                }
            }
            if((result.length() < tempi.length()) || (result == " ")){
                result = tempi;
            }     
        }else{
            if(result.length() < 1 || (result == " "))
                System.out.print("The input is considered to be as: Invalid input");
            else
                System.out.print("Longest Repeated Sequence using Brute force Technique: "+result); 
        }      
        }
        public void subsetsRest(String e, boolean[] isIn, int iStart) {
            String temp=" ";          
            if (iStart == e.length()) {
                int j=0;
            for (j = 0; j < e.length(); j++)
                if(isIn[j]) {
                    temp = temp+String.valueOf(j);
                }
                brute(temp, e);
            }
            else {
            isIn[iStart] = true;
            subsetsRest(e, isIn, iStart+1);  
            isIn[iStart] = false; 
            subsetsRest(e, isIn, iStart+1);  
            }
        }
        void longestRepeatedSubSeq(String str){
            //String input = str;
            subsetsRest(str, new boolean[str.length()], 0);   
        }
        public static void main (String[] args) {
            brute g =new brute();
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the input to sort using brute force: ");
            String str=sc.nextLine();
            //long starttime = System.nanoTime(); // start time of performing algorithm
            g.longestRepeatedSubSeq(str);
            //long endtime = System.nanoTime(); // end time of performing algorithm
            //long totaltime = TimeUnit.NANOSECONDS.toMillis(endtime) - TimeUnit.NANOSECONDS.toMillis(starttime); // total time taken by algorithm for sorting
            //System.out.println("\n\nTime taken by the algorithm running above is: "+totaltime+" ms");
        
        }
    }