/**
 * Created by Lambda on 9/13/2015.
 */
public class Tree_Demo {
  public static void main(String[] args) {
    AVL_Tree __avl = new AVL_Tree();

    __avl.insert_node(50);
    __avl.insert_node(35);
    __avl.insert_node(25);
    __avl.insert_node(40);
    __avl.insert_node(55);
    __avl.insert_node(45);

    __avl.print();

    System.out.println();

    //__avl.delete_node(40);
    __avl.delete_node(35);
    __avl.print();
  }
}
