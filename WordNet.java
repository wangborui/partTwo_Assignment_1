/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partTwo_Assignment_1;

/**
 *
 * @author Borui Wang
 */
public class WordNet {

   // constructor takes the name of the two input files
   public WordNet(String synsets, String hypernyms)
   {
       if(synsets == null) throw new java.lang.NullPointerException("synsets are null");
       if(hypernyms == null) throw new java.lang.NullPointerException("hypernyms are null");
   }

   // returns all WordNet nouns
   public Iterable<String> nouns()
   {
       return null;
   }

   // is the word a WordNet noun?
   public boolean isNoun(String word)
   {
       if(word == null) throw new java.lang.NullPointerException("isNoun() word is null");
       return false;
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
       
   }
}