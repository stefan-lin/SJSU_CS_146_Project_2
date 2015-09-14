/**
 * Created by Lambda on 9/5/2015.
 */
import java.util.LinkedList;
import java.util.Random;

public class BST<T extends Comparable<T>> {
  // PROTECTED CLASS
  protected class TreeNode<T extends Comparable<T>>{
    // PRIVATE FIELDS
    private int _height = -1;
    private T _value = null;
    private TreeNode<T> _left = null;
    private TreeNode<T> _right = null;

    // CONSTRUCTOR
    public TreeNode(T input_value){
      _height = 1;
      _value = input_value;
      _left = null;
      _right = null;
    } // END CONSTRUCTOR

    // PUBLIC METHODS
    public void append_right(TreeNode<T> input_node){
      this._right = input_node;
    } // END append_right

    public void append_left(TreeNode<T> input_node){
      this._left = input_node;
    } // END append_left

    public T get_value(){
      return _value;
    } // END get_value

    public void change_value(T new_value){
      this._value = new_value;
    } // END change_value

    public boolean has_child(){
      return this._left != null || this._right != null;
    }

    public TreeNode<T> get_left(){
      return this._left;
    }

    public TreeNode<T> get_right(){
      return this._right;
    }

    public int get_height(){
      return _height;
    }

    public void set_height(int input_value){
      _height = input_value;
    }
  } // END TreeNode CLASS

  // PRIVATE FIELDS
  protected TreeNode<T> _head = null;
  protected int _num_of_nodes = -1;

  public BST(){
    _head = null;
    _num_of_nodes = 0;
  }

  public BST(T input_value){
    _head = new TreeNode<>(input_value);
    _num_of_nodes = 1;
  }

  public void inorder_print(){
    _inorder(_head);
    _num_of_nodes++;
  }
  private void _inorder(TreeNode<T> root){
    if(root != null){
      _inorder(root.get_left());
      System.out.print("[" + root.get_value() + "], ");
      _inorder(root.get_right());
    }
    System.out.println();
  }

  public void print(){
    // FORMAT STRINGS
    int __spaces_lvl_0 = 39;
    int __spaces_lvl_1 = 25;

    //int __tree_depth = 0;
    int __print_count = 1;
    LinkedList<TreeNode<T>> __local_queue = new LinkedList<>();
    if(_head == null){
      System.out.println("Empty Tree");
      return;
    }
    TreeNode<T> __curr_node = _head;
    __local_queue.addLast(__curr_node);
    __curr_node = null;
    while(!__local_queue.isEmpty()){
      __curr_node = __local_queue.removeFirst();
      // IF THE CURRENT NODE EXISTS
      if(__curr_node != null) {
        __local_queue.addLast(__curr_node.get_left());
        __local_queue.addLast(__curr_node.get_right());
      }
      // PRINT OUT THE CURRENT NODE
      //System.out.print(__curr_node.get_value());
      _print_tree_lines(__print_count, __curr_node);

      // INCREMENT THE __print_count
      __print_count++;
    } // END WHILE LOOP
  }

  private void _print_tree_lines(int node_num, TreeNode<T> node){
    /**
     * INDENTATION:
     *   (1) LEVEL 0 = 2^(5-1) - 1 = 15
     *   (2) LEVEL 1 = 2^(5-2) - 1 = 7
     *   (3) LEVEL 3 = 2^(5-3) - 1 = 3
     *   (4) LEVEL 4 = 2^(5-4) - 1 = 1
     *   (5) LEVEL 5 = 2^(5-5) - 1 = 0
      */
    // PRINT OUT THE INTERNAL LINES INSIDE THE TREE
    int __indent = 0;
    if(node_num == 1 || node_num ==3){
      if(node_num == 1){
        __indent = 15+2;
      }
      else{
        __indent = 15+1;
      }
    }
    else if(node_num == 2 || node_num>=5 && node_num<=7){
      if(node_num == 2){
        __indent = 7+2;
      }
      else{
        __indent = 7+1;
      }
    }
    else if(node_num == 4 || node_num>=9 && node_num<=15){
      if(node_num ==4){
        __indent = 3+2;
      }
      else{
        __indent = 3;
      }
    }
    else if(node_num == 8 || node_num>=17 && node_num<=31) {
      if(node_num == 8){
        __indent = 1+2;
      }
      else{
        if(node_num%2 != 0){
          __indent = 1;
        }
        else {
          __indent = 2;
        }
      }
    }
    else {
      __indent = 2;
    }
    for(int i=0; i<__indent; i++){
      System.out.print(" ");
    }
    if(node != null) {
      System.out.print(node.get_value());
    }
    else{
      System.out.print("X");
    }
    // DETERMINE IF NEW LINE CHARACTER NEEDED TO BE PRINTED
    if(node_num == 1 || node_num == 3 || node_num == 7 ||
        node_num == 15 || node_num == 31){
      System.out.println();
    }
  }



  public void insert_node(T input_value){
    _head = _insert(_head, input_value);
  }

  protected TreeNode<T> _insert(TreeNode<T> root, T input_value){
    if(root == null){
      // ALLOCATE THE NEW NODE WHEN THE INSERT LOCATION IS FOUND
      root = new TreeNode<>(input_value);
    }
    else {
      if (root._value.compareTo(input_value) >= 0) {
        root.append_left(_insert(root.get_left(), input_value));
      } else {
        root.append_right(_insert(root.get_right(), input_value));
      }
    }
    return root;
  }

  public boolean search_node(T input_value) {
    TreeNode<T> __node_ref = _find_node(this._head, input_value);

    return __node_ref != null;
  }

  public void delete_node(T input_value){
    if(_head == null){
      System.out.println("The BST is empty.");
      return;
    }

    if(_find_node(_head, input_value) == null){
      // NODE DOES NOT EXIST
      System.out.println("The node does not exist.");
      return;
    }
    else{
      _head = _delete_node(_head, input_value);
    }
  }
  protected TreeNode<T> _delete_node(TreeNode<T> root, T input_value){
    if(root != null) {
      int __comparison_result = root.get_value().compareTo(input_value);
      if (__comparison_result > 0) {  // DELETE VALUE IS LESS
        root.append_left(_delete_node(root.get_left(), input_value));
      } else if (__comparison_result < 0) { // DELETE VALUE IS GREATER
        root.append_right(_delete_node(root.get_right(), input_value));
      } else { // FOUND
        if (root.get_left() == null) {
          return root.get_right();
        } else if (root.get_right() == null) {
          return root.get_left();
        } else { // HAS TWO CHILDREN
          // COPY VALUE
          root.change_value(_get_max_node(root.get_left()).get_value());
          root.append_left(_delete_node(root.get_left(), root.get_value()));
        }
      }
    }
    return root;
  }

  protected TreeNode<T> _get_max_node(TreeNode<T> node){
    while(node.get_right() != null){
      node = node.get_left();
    } // END WHILE
    return node;
  }

  private TreeNode<T> _find_node(TreeNode<T> root, T input_value){
    if(root == null){
      // NOT FOUND
      return null;
    }
    int __result = root._value.compareTo(input_value);
    if(__result == 0){
      // FOUND VALUE
      return root;
    }
    else if(__result > 0){
      return _find_node(root._left, input_value);
    }
    else{
      return _find_node(root._right, input_value);
    }

  }
}

/**
                                    91
                                    /\
                      --------------   --------------
                     /                               \
                    55                               94
                    /\                               /\
             ------   ------                  ------   ------
            /               \                /               \
           30               70              85               97
           /\               /\              /\               /\
        --   --          --   --         --   --          --   --
       /       \        /       \       /       \        /       \
      10       50      60       80     84       87      95       98
      /\       /\      /\       /\     /\       /\      /\       /\
     -  -     -  -    -  -     -  -   -  -     -  -    -  -     -  -
    /    \   /    \  /    \   /    \ /    \   /    \  /    \   /    \
   2     11 44    52
 */