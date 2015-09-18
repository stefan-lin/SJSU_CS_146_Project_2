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
  final int INT_ARR_SIZE = 100000;
  final int RAND_ARR = 10000;
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
    (new TreePrinter<>(__bst)).print("");
    System.out.println("------------------------------------------\n");
    while(!__bst.is_empty()){
      System.out.println("= = = = = = = = = = = = = = = = = = = = = ");
      System.out.println("DELETING " + __bst.pop() + " : ");
      (new TreePrinter<>(__bst)).print("");
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
    (new TreePrinter<>(__avl)).print("");
    System.out.println("------------------------------------------\n");
    while(!__avl.is_empty()){
      System.out.println("= = = = = = = = = = = = = = = = = = = = = ");
      System.out.println("DELETING " + __avl.pop() + " : ");
      (new TreePrinter<>(__avl)).print("");
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
      
    //NOT SURE IF WE CAN USE THIS BUT : TimeUnit.NANOSECONDS.toSeconds(1000000000000L);
    System.out.println(
        "Inserting 100k nodes into BST took " +
<<<<<<< HEAD
            (double)__elapsed_time_bst/1000000000000.0 + "seconds");
    System.out.println(
        "Inserting 100k nodes into AVL took " +
            (double)__elapsed_time_avl/1000000000000.0  + "seconds");
=======
            (double)__elapsed_time_bst/1000000000000.0  + "seconds");
    System.out.println(
        "Inserting 100k nodes into AVL took " +
            (double)__elapsed_time_avl/1000000000000.0  + "seconds");
>>>>>>> origin/Sep13

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
<<<<<<< HEAD
           (double) __bst_search/1000000000000.0  + "seconds");
    System.out.println(
        "Searching 10k nodes in AVL with 100k nodes took " +
            (double)__avl_search/1000000000000.0  + "seconds");
=======
           (double) __bst_search + "seconds");
    System.out.println(
        "Searching 10k nodes in AVL with 100k nodes took " +
            (double)__avl_search/1000000000000.0  + "seconds");
>>>>>>> origin/Sep13

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
<<<<<<< HEAD
           (double) __bst_mix/1000000000000.0  + "nanoseconds");
    System.out.println(
        "Searching or inserting 10k nodes in AVL with 100k nodes took " +
            (double)__avl_mix/1000000000000.0  + "nanoseconds");
=======
           (double) __bst_mix/1000000000000.0  + " nanoseconds");
    System.out.println(
        "Searching or inserting 10k nodes in AVL with 100k nodes took " +
           (double) __avl_mix/1000000000000.0  + " nanoseconds");
>>>>>>> origin/Sep13
  }

  public static void main(String[] args) {
    Tree_Demo __demo = new Tree_Demo();
    try {
      __demo.bst_demo_method();
      System.in.read();
      __demo.avl_demo_method();
      System.in.read();
      __demo.efficiency_test();
    }
    catch(Exception e){

    }

    //AVL_Tree<Integer> __avl = new AVL_Tree<>();
    //Random __rand_gen = new Random();
    //ArrayList<Integer> __arr = new ArrayList<>(50);
    //
    //for(int i =0; i<50; i++){
    //  __arr.add(i, __rand_gen.nextInt(99-10)+10);
    //}
    //
    //for(int j=0; j<50; j++){
    //  System.out.print(__arr.get(j) + ", ");
    //  if(j%10 == 0){
    //    System.out.println();
    //  }
    //}
    //
    //for(int i=0; i<50; i++){
    //  System.out.println("[ " + i + " ] = { " + __arr.get(i) + " }");
    //  __avl.insert_node(__arr.get(i));
    //  //__avl.print();
    //  //TreePrinter<Integer> __tp = new TreePrinter<>(__avl);
    //  //__tp.print("Test");
    //  System.out.println();
    //  try {
    //    System.in.read();
    //  }
    //  catch (Exception e){}
    //}
  }
}
