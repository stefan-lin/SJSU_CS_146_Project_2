/**
 * Created by Lambda on 9/13/2015.
 */
public class Tree_Demo {
  public static void main(String[] args) {
	  
	//test null case
	BST<Integer> binary = new BST();
	binary.insert_node(null);
	binary.print();
	System.out.println("Empty BST");
	System.out.println();
	
	//print a 5 lvl BST
	BST<Integer> binary2 = new BST();
	binary2.insert_node(50);
	binary2.insert_node(45);
	binary2.insert_node(65);
	binary2.insert_node(40);
	binary2.insert_node(48);
	binary2.insert_node(60);
	binary2.insert_node(70);
	binary2.insert_node(30);
	binary2.insert_node(35);
	binary2.insert_node(47);
	binary2.insert_node(53);
	binary2.insert_node(68);
	binary2.insert_node(75);	
	binary2.print();
	System.out.println("Successful printing of 5 lvl tree");
	System.out.println();
	
	//testing Delete func of BST
	BST<Integer> binary3 = new BST();
	binary3.insert_node(50);
	binary3.insert_node(45);
	binary3.insert_node(65);
	binary3.insert_node(40);
	binary3.insert_node(48);
	binary3.insert_node(60);
	binary3.insert_node(70);
	binary3.insert_node(30);
	binary3.insert_node(35);
	binary3.insert_node(47);
	binary3.insert_node(53);
	binary3.insert_node(68);
	binary3.insert_node(75);
	//delete starts here
	/*binary3.delete_node(50);
	binary3.delete_node(40);//gives null pt exception, delete_node line 245/228
	binary3.delete_node(null);
	binary3.delete_node(null);
	binary3.delete_node(null);
	binary3.delete_node(null);
	binary3.delete_node(null);
	binary3.delete_node(null);
	binary3.delete_node(null);
	binary3.delete_node(null);*/
	
	AVL_Tree av1 = new AVL_Tree();
	
	av1.insert_node(null); //print nothing
	av1.print();
	System.out.println("Empty AVL Tree");
	System.out.println();
	
	AVL_Tree av2 = new AVL_Tree();
	av2.delete_node(40);
	
   // AVL_Tree __avl = new AVL_Tree();

    //__avl.insert_node(50);
    //__avl.insert_node(35);
    //__avl.insert_node(25);
    //__avl.insert_node(40);
    //__avl.insert_node(55);
    //__avl.insert_node(45);

    //__avl.print();

    //System.out.println();

    //__avl.delete_node(40);
    //__avl.delete_node(35);
    //__avl.print();
  }
}
