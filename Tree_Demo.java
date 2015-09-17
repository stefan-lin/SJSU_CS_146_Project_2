/**
 * Created by Lambda on 9/13/2015.
 */

import java.lang.Math;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class Tree_Demo {
  final int RAND_MIN = 10;
  final int RAND_MAX = 99;
  final int NUM_AVL_NODES = 35;
  final int INT_ARR_SIZE = 100;
  final int RAND_ARR = 50;
  public void bst_demo_method(){
    BST<Integer> __bst = new BST<>();
    Random __rand_gen = new Random();
    // GENERATE BINARY SEARCH TREE WITH HEIGHT 5
    while(!__bst.is_height_five()){
      __bst.insert_node(__rand_gen.nextInt(RAND_MAX - RAND_MIN) + RAND_MIN);
    } // END WHILE LOOP

    // PRINT AND DELETE ROOT REPEATLY
    System.out.println("INITIAL TREE : ");
    System.out.println("= = = = = = = = = = = = = = = = = = = = = ");
    __bst.print();
    System.out.println("------------------------------------------\n");
    while(!__bst.is_empty()){
      System.out.println("= = = = = = = = = = = = = = = = = = = = = ");
      System.out.println("DELETING " + __bst.pop() + " : ");
      __bst.print();
      System.out.println("------------------------------------------\n");
    }

    System.out.println("TREE IS NOW EMPTY.\n");
  }

  public void avl_demo_method(){
    AVL_Tree<Integer> __avl = new AVL_Tree<>();
    Random __rand_gen = new Random();

    for(int i=0; i<NUM_AVL_NODES; i++){
      __avl.insert_node(__rand_gen.nextInt(RAND_MAX - RAND_MIN) + RAND_MIN);
    } // END FOR LOOP
    System.out.println("INITIAL TREE : ");
    System.out.println("= = = = = = = = = = = = = = = = = = = = = ");
    __avl.print();
    System.out.println("------------------------------------------\n");
    while(!__avl.is_empty()){
      System.out.println("= = = = = = = = = = = = = = = = = = = = = ");
      System.out.println("DELETING " + __avl.pop() + " : ");
      __avl.print();
      System.out.println("------------------------------------------\n");
    } // END WHILE LOOP

    System.out.println("TREE IS NOW EMPTY.\n");
  }

  public void efficiency_test(){
    long __elapsed_time_bst = -1;
    long __elapsed_time_avl = -1;
    BST<Integer> __bst = new BST<>();
    AVL_Tree<Integer> __avl = new AVL_Tree<>();
    Random __rand_gen = new Random();
    ArrayList<Integer> __int_arr = new ArrayList<>(INT_ARR_SIZE);
    ArrayList<Integer> __rand_search_targets = new ArrayList<>(RAND_ARR);

    // INITIALIZE __int_arr WITH NUMBERS
    for(int i=0; i<INT_ARR_SIZE; i++){
      __int_arr.add(__rand_gen.nextInt(INT_ARR_SIZE - 1) + 1);
    } // END FOR LOOP
    for(int i=0; i<INT_ARR_SIZE; i++){
      __rand_search_targets.add(__rand_gen.nextInt(INT_ARR_SIZE - 1) + 1);
    } // END FOR LOOP

    // INSERTING INTO BST
    long __begin = System.nanoTime();
    for(int itr=0; itr<__int_arr.size(); itr++){
      __bst.insert_node(__int_arr.get(itr));
    } // END FOR LOOP
    __elapsed_time_bst = System.nanoTime() - __begin;

    // INSERTING INTO AVL
    __begin = System.nanoTime();
    for(int itr=0; itr<__int_arr.size(); itr++){
      __avl.insert_node(__int_arr.get(itr));
    } // END FOR LOOP
    __elapsed_time_avl = System.nanoTime() - __begin;

    System.out.println(
        "Inserting 100k nodes into BST took " +
            __elapsed_time_bst + "nanoseconds");
    System.out.println(
        "Inserting 100k nodes into AVL took " +
            __elapsed_time_avl + "nanoseconds");

    /////////////////// SEARCH ////////////////////////////////////////////////
    long __bst_search = -1;
    long __avl_search = -1;

    __begin = System.nanoTime();
    for(int i=0; i<__rand_search_targets.size(); i++){
      __bst.search_node(__rand_search_targets.get(i));
    }
    __bst_search = System.nanoTime() - __begin;

    __begin = System.nanoTime();
    for(int i=0; i<__rand_search_targets.size(); i++){
      __avl.search_node(__rand_search_targets.get(i));
    }
    __avl_search = System.nanoTime() - __begin;

    System.out.println(
        "Searching 10k nodes in BST with 100k nodes took " +
            __bst_search + "nanoseconds");
    System.out.println(
        "Searching 10k nodes in AVL with 100k nodes took " +
            __avl_search + "nanoseconds");

    /////////////////// INSERT + SEARCH ///////////////////////////////////////
    // USING THE RANDOM GENERATED SEARCHING NUMBER TO EITHER INSERTING OR
    // SEARCHING THE __bst AND __avl WHICH BOTH CONTAINS 100k NODES ALREADY
    long __bst_mix = -1;
    long __avl_mix = -1;

    __begin = System.nanoTime();
    for(int i=0; i<__rand_search_targets.size(); i++){
      if(__rand_gen.nextBoolean()) {
        __bst.insert_node(__rand_search_targets.get(i));
      }
      else {
        __bst.search_node(__rand_search_targets.get(i));
      }
    } // END FOR LOOP
    __bst_mix = System.nanoTime() - __begin;

    __begin = System.nanoTime();
    for(int i=0; i<__rand_search_targets.size(); i++){
      if(__rand_gen.nextBoolean()) {
        __avl.insert_node(__rand_search_targets.get(i));
      }
      else {
        __avl.search_node(__rand_search_targets.get(i));
      }
    } // END FOR LOOP
    __avl_mix = System.nanoTime() - __begin;

    System.out.println(
        "Searching or inserting 10k nodes in BST with 100k nodes took " +
            __bst_mix + "nanoseconds");
    System.out.println(
        "Searching or inserting 10k nodes in AVL with 100k nodes took " +
            __avl_mix + "nanoseconds");
  }

  public static void main(String[] args) {
    Tree_Demo __demo = new Tree_Demo();
    __demo.efficiency_test();
  }
}
