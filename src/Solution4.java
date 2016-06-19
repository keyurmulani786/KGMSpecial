import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author geekguy
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        BufferedReader br = null;

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/apple-fruit.txt"));
            HashMap<String, Integer> hm1 = new HashMap<String, Integer>();
            String t1 = "apple this the be to of and a in that have I it for not on with he as you do at Word this but his by from they we say her she or an will my one all would there their what Word so up out if about who get which go me when make can like time no just him know take Word people into year your good some could them see other than then now look only come its over think also Word back after use two how our work first well way even new want because any these give day most us";
            t1 = t1.toLowerCase();

            HashSet<String> hs = new HashSet<String>();
            String arr_t1[] = t1.split(" ");
            for (int x = 0; x < arr_t1.length; x++) {
                hs.add(arr_t1[x]);
            }
            while ((sCurrentLine = br.readLine()) != null) {
                //System.out.println(sCurrentLine);
                sCurrentLine = clean(sCurrentLine);
                String srr[] = sCurrentLine.split("\\s");
                for (int x = 0; x < srr.length; x++) {
                    //    System.out.println(srr[x]);
                    if (!hs.contains(srr[x].toLowerCase())) {
                        if (hm1.containsKey(srr[x])) {
                            hm1.put(srr[x], hm1.get(srr[x]) + 1);
                        } else {
                            hm1.put(srr[x], 1);
                        }
                    }
                }

            }

            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/apple-computers.txt"));
            HashMap<String, Integer> hm2 = new HashMap<String, Integer>();

            while ((sCurrentLine = br.readLine()) != null) {
                //System.out.println(sCurrentLine);
                sCurrentLine = clean(sCurrentLine);
                String srr[] = sCurrentLine.split("\\s");
                for (int x = 0; x < srr.length; x++) {
                   // System.out.println(srr[x]);
                    if (!hs.contains(srr[x].toLowerCase())) {
                        if (hm2.containsKey(srr[x])) {
                            hm2.put(srr[x], hm2.get(srr[x]) + 1);
                        } else {
                            hm2.put(srr[x], 1);
                        }
                    }
                }

            }
            br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                String s1 = br.readLine();
               // System.out.println(s1);
                if(s1.contains("apple") || s1.contains("apples") || s1.toUpperCase().contains("APPLES"))
                {
                    System.out.println("fruit");
                    continue;
                }
                String srr[] = clean(s1).split("\\s");
                int a = 0, b = 0;
                for (int x = 0; x < srr.length; x++) {
                    if (!hs.contains(srr[x].toLowerCase())) {
                        if (hm1.containsKey(srr[x])) {
                            //System.out.println(srr[x]+" "+hm1.get(srr[x]));
                            a +=1;
                        }
                        if (hm2.containsKey(srr[x])) {
           //                   System.out.println(srr[x]+" "+hm2.get(srr[x]));
                            b +=1;
                        }
                    }

                }
                
              //  System.out.println(a + " "+b);
                if (a > b) {
                    System.out.println("fruit");
                } else {
                    System.out.println("computer-company");
                }
                

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    static String clean(String line) {
        line = line.toLowerCase();

        line.replaceAll("[\\[\\]{}<>]", "");
        line.replaceAll("['\",.;]", "");
        line.replaceAll("-", " ");
        line.replaceAll("\\s+", " ");
//        s = s.toLowerCase();
        return line;
    }

}