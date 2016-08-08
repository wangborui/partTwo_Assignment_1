/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partTwo_Assignment_1;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
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
    private SeparateChainingHashST<String, Bag<Integer>> nounsTable;
    private SeparateChainingHashST<Integer, String> synsetsTable;
    private SAP sap;
    
   // constructor takes the name of the two input files
   public WordNet(String synsets, String hypernyms)
   {
       if(synsets == null) throw new java.lang.NullPointerException("synsets are null");
       if(hypernyms == null) throw new java.lang.NullPointerException("hypernyms are null");
       
       this.synsets = synsets;
       this.hypernyms = hypernyms;
       this.nounsTable = new SeparateChainingHashST<>();
       this.synsetsTable = new SeparateChainingHashST<>(); 
       addSynsetDictionary();
       addHypernymsDictionary();
   }
   private void addHypernymsDictionary(){
        In in = new In(hypernyms);
        Digraph g = new Digraph(synsetsTable.size());
        //add edges to digraph
        while(!in.isEmpty()){
            String [] synset = in.readLine().split(",");
            for(int i = 1; i < synset.length ; i++){
               g.addEdge(Integer.parseInt(synset[0]), Integer.parseInt(synset[1])); 
            }
        }
        this.sap = new SAP(g);
   }
   private void addSynsetDictionary(){
       In in = new In(synsets);
        //put all synsets into nouns table
        while(!in.isEmpty()){
            String [] synset = in.readLine().split(",");
    
            //add synsets to nounsTable
            for(String word: synset[1].split(" ")){
                if(nounsTable.contains(word)){
                     nounsTable.get(word).add(Integer.parseInt(synset[0]));
                }
                else{
                    Bag<Integer> temp = new Bag<Integer>();
                    temp.add(Integer.parseInt(synset[0]));
                    nounsTable.put(word, temp);
                }
            }
            //add words to synsets tables
            synsetsTable.put(Integer.parseInt(synset[0]), synset[1]);
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
       
       if(nounsTable.contains(nounA) && nounsTable.contains(nounB))
       {
           return sap.length(nounsTable.get(nounA), nounsTable.get(nounB));
       }
       else{
            return -1;
       }
   }

   // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
   // in a shortest ancestral path (defined below)
   public String sap(String nounA, String nounB)
   {
       if(nounA == null) throw new java.lang.NullPointerException("nounA is null");
       if(nounB == null) throw new java.lang.NullPointerException("nounB is null");
       if(nounsTable.contains(nounA) && nounsTable.contains(nounB))
       {
           return  synsetsTable.get(sap.ancestor(nounsTable.get(nounA), nounsTable.get(nounB)));
       }
       else{
            return null;
       }
   }

   // do unit testing of this class
   public static void main(String[] args)
   {
        WordNet wn = new WordNet("C:\\Users\\Borui Wang\\Desktop\\wordnet-testing\\wordnet\\synsets.txt","C:\\Users\\Borui Wang\\Desktop\\wordnet-testing\\wordnet\\hypernyms.txt");
//        for(String a: wn.nouns())
//            StdOut.println(a);
//        StdOut.println(wn.isNoun("ACE_inhibitors"));
          StdOut.println(wn.distance("Black_Plague", "black_marlin"));
          StdOut.println(wn.sap("Black_Plague", "black_marlin"));
   }
}