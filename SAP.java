/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partTwo_Assignment_1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
import java.io.File;

import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 *
 * @author Borui Wang
 */
public class SAP {

    private Digraph dig;
   // constructor takes a digraph (not necessarily a DAG)
   public SAP(Digraph G)
   {
       if(G == null) throw new java.lang.NullPointerException("Digraph is null");
       this.dig = G;
  
   }

   // length of shortest ancestral path between v and w; -1 if no such path
   public int length(int v, int w)
   {
	   if(v < 0 || v > dig.V()) throw new java.lang.IndexOutOfBoundsException("v is out of range");
	   if(w < 0 || w > dig.V()) throw new java.lang.IndexOutOfBoundsException("w is out of range");
	   
	   BreadthFirstDirectedPaths dfdpV = new BreadthFirstDirectedPaths(dig,v);
	   BreadthFirstDirectedPaths dfdpW = new BreadthFirstDirectedPaths(dig,w);
	   
	   int path = Integer.MAX_VALUE;
	   for(int i = 0;i<dig.V();i++){
		   if(dfdpV.hasPathTo(i) && dfdpW.hasPathTo(i)){
			   if(path > dfdpV.distTo(i) + dfdpW.distTo(i)){
				   path = dfdpV.distTo(i) + dfdpW.distTo(i);
			   }
		   }
	   }

	   return path == Integer.MAX_VALUE?-1:path;
   }

   // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
   public int ancestor(int v, int w)
   {
	   if(v < 0 || v > dig.V()) throw new java.lang.IndexOutOfBoundsException("v is out of range");
	   if(w < 0 || w > dig.V()) throw new java.lang.IndexOutOfBoundsException("w is out of range");
       
           BreadthFirstDirectedPaths dfdpV = new BreadthFirstDirectedPaths(dig,v);
	   BreadthFirstDirectedPaths dfdpW = new BreadthFirstDirectedPaths(dig,w);
           
 	   int path = Integer.MAX_VALUE;
           int acestor = -1;
	   for(int i = 0;i<dig.V();i++){
		   if(dfdpV.hasPathTo(i) && dfdpW.hasPathTo(i)){
			   if(path > dfdpV.distTo(i) + dfdpW.distTo(i)){
				   path = dfdpV.distTo(i) + dfdpW.distTo(i);
                                   acestor = i;
			   }
		   }
	   }
	   return acestor;
   }

   // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
   public int length(Iterable<Integer> v, Iterable<Integer> w)
   {
	   if(v == null) throw new java.lang.NullPointerException("v is null");
	   if(w == null) throw new java.lang.NullPointerException("w is null");
           
           BreadthFirstDirectedPaths dfdpV = new BreadthFirstDirectedPaths(dig,v);
	   BreadthFirstDirectedPaths dfdpW = new BreadthFirstDirectedPaths(dig,w);
	   
	   int path = Integer.MAX_VALUE;
	   for(int i = 0;i<dig.V();i++){
		   if(dfdpV.hasPathTo(i) && dfdpW.hasPathTo(i)){
			   if(path > (dfdpV.distTo(i) + dfdpW.distTo(i))){
				   path = dfdpV.distTo(i) + dfdpW.distTo(i);
			   }
		   }
	   }

	   return path == Integer.MAX_VALUE?-1:path;
   }

   // a common ancestor that participates in shortest ancestral path; -1 if no such path
   public int ancestor(Iterable<Integer> v, Iterable<Integer> w)
   {
	   if(v == null) throw new java.lang.NullPointerException("v is null");
	   if(w == null) throw new java.lang.NullPointerException("w is null");
           
           BreadthFirstDirectedPaths dfdpV = new BreadthFirstDirectedPaths(dig,v);
	   BreadthFirstDirectedPaths dfdpW = new BreadthFirstDirectedPaths(dig,w);
           
 	   int path = Integer.MAX_VALUE;
           int acestor = -1;
	   for(int i = 0;i<dig.V();i++){
		   if(dfdpV.hasPathTo(i) && dfdpW.hasPathTo(i)){
			   if(path > dfdpV.distTo(i) + dfdpW.distTo(i)){
				   path = dfdpV.distTo(i) + dfdpW.distTo(i);
                                   acestor = i;
			   }
		   }
	   }
	   return acestor;
   }

   // do unit testing of this class
   public static void main(String[] args){
        In in = new In(new File("C:\\Users\\Borui Wang\\Desktop\\wordnet-testing\\wordnet\\digraph2.txt"));
        Digraph G = new Digraph(in);
        SAP sap = new SAP(G);
        int a = 1;
        int b = 5;
        Stack<Integer> st = new Stack<Integer>();
        st.push(4);
        st.push(11);
        st.push(2);
        
        Stack<Integer> st1 = new Stack<Integer>();
        st1.push(7);
        st1.push(8);
        StdOut.println(sap.length(a, b));
        StdOut.println(sap.ancestor(a, b));
   }
}