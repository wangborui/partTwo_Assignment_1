/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partTwo_Assignment_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 *
 * @author Borui Wang
 */
public class Outcast {
    private WordNet wn;
   public Outcast(WordNet wordnet)         // constructor takes a WordNet object
   {
       this.wn = wordnet;
   }
   public String outcast(String[] nouns)   // given an array of WordNet nouns, return an outcast
   {
       String outcast = "";
       int maxDistance = Integer.MIN_VALUE;
       
       for(int i = 0;i < nouns.length; i ++){
           int distance = 0;
           for(int j = 0; j < nouns.length; j++){
               if(i != j){
                   distance += wn.distance(nouns[i], nouns[j]);
               }
           }
           if(maxDistance < distance){
               maxDistance = distance;
               outcast = nouns[i];
           }
       }
       return outcast;
   }
   public static void main(String[] args)  // see test client below
   {
        WordNet wordnet = new WordNet("C:\\Users\\Borui Wang\\Desktop\\wordnet-testing\\wordnet\\synsets.txt","C:\\Users\\Borui Wang\\Desktop\\wordnet-testing\\wordnet\\hypernyms.txt");
       Outcast outcast = new Outcast(wordnet);
  
           In in = new In("C:\\Users\\Borui Wang\\Desktop\\wordnet-testing\\wordnet\\outcast11.txt");
           String[] nouns = in.readAllStrings();
           StdOut.println("outcast11.txt" + ": " + outcast.outcast(nouns));
     
   }
}