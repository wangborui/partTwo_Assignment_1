/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partTwo_Assignment_1;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import edu.princeton.cs.algs4.StdOut;
 /**
 *
 * @author Borui Wang
 */
public class WordNet {

    private String synsets,hypernyms;
    //use hash table with word as key, its synset numbers as string arrays
    private SeparateChainingHashST<String, Bag<String>> nounsTable;
   // constructor takes the name of the two input files
   
   public WordNet(String synsets, String hypernyms)
   {
       if(synsets == null) throw new java.lang.NullPointerException("synsets are null");
       if(hypernyms == null) throw new java.lang.NullPointerException("hypernyms are null");
       
       this.synsets = synsets;
       this.hypernyms = hypernyms;
       this.nounsTable = new SeparateChainingHashST<>();
       
        In in = new In(synsets);
        while(!in.isEmpty()){
            String [] synset = in.readLine().split(",");
            for(String word: synset[1].split(" ")){
                if(nounsTable.contains(word)){
                    nounsTable.get(word).add(synset[0]);
                }
                else{
                    Bag<String> temp = new Bag<String>();
                    temp.add(synset[0]);
                    nounsTable.put(word, temp);
                }
            }
        }
   }

   // returns all WordNet nouns
   public Iterable<String> nouns()
   {
       return nounsTable.keys();
   }

   // is the word a WordNet noun?
   public boolean isNoun(String word)
   {
       if(word == null) throw new java.lang.NullPointerException("isNoun() word is null");
       return nounsTable.contains(word);
   }

   // distance between nounA and nounB (defined below)
   public int distance(String nounA, String nounB)
   {
       if(nounA == null) throw new java.lang.NullPointerException("nounA is null");
       if(nounB == null) throw new java.lang.NullPointerException("nounB is null");
       return -1;
   }

   // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
   // in a shortest ancestral path (defined below)
   public String sap(String nounA, String nounB)
   {
       if(nounA == null) throw new java.lang.NullPointerException("nounA is null");
       if(nounB == null) throw new java.lang.NullPointerException("nounB is null");
       return null;
   }

   // do unit testing of this class
   public static void main(String[] args)
   {
        WordNet wn = new WordNet("C:\\Users\\Borui Wang\\Desktop\\wordnet-testing\\wordnet\\synsets.txt","C:\\Users\\Borui Wang\\Desktop\\wordnet-testing\\wordnet\\hypernyms.txt");
//        for(String a: wn.nouns())
//            StdOut.println(a);
        StdOut.println(wn.isNoun("ACE_inhibitors"));
   }
}