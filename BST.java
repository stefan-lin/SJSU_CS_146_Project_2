/**
 * Created by Lambda on 9/5/2015.
 */
import java.util.LinkedList;
import java.util.Random;

/**
 * BST PUBLIC CLASS
 *
 *
 */
public class BST<T extends Comparable<T>> {
  // PROTECTED CLASS
  /**
   * TreeNode PROTECTED INNER CLASS
   *
   * TreeNode CLASS IS RESPONSIBLE FOR STORING SEVERAL FIELDS:
   *   (1) _height : THE HEIGHT OF THE TreeNode WITHIN THE TREE
   *   (2) _value  : VALUE STORED IN TREE NODE
   *   (3) _left   : LEFT CHILD TREE NODE
   *   (4) _right  : RIGHT CHILD TREE NODE
   */
  protected class TreeNode<T extends Comparable<T>>{
    // PRIVATE FIELDS
    private int _height = -1;
    private T _value = null;
    private TreeNode<T> _left = null;
    private TreeNode<T> _right = null;

    /**
     * TreeNode CONSTRUCTOR
     *
     * @param input_value A GENERIC INPUT FROM THE USER
     *
     * THE CONSTRUCTOR WILL TAKE AN INPUT FROM USER AND STORE IT INTO A NEWLY
     * CREATED TreeNode BEFORE RETURNING IT TO USER.
     */
    public TreeNode(T input_value){
      _height = 1;
      _value = input_value;
      _left = null;
      _right = null;
    } // END CONSTRUCTOR

    // PUBLIC METHODS
    /**
     * append_right PUBLIC METHOD
     *
     * @param input_node A NEW NODE PROVIDED BY USER
     *
     * append_right METHOD WILL TAKE ONE INPUT (NEW NODE) AND APPEND IT AS THE
     * RIGHT CHILD NODE
     */
    public void append_right(TreeNode<T> input_node){
      this._right = input_node;
    } // END append_right

    /**
     * append_left PUBLIC METHOD
     *
     * @param input_node A NEW NODE PROVIDED BY USER
     *
     * append_left METHOD WILL TAKE ONE INPUT (NEW NODE) AND APPEND IT AS THE
     * LEFT CHILD NODE
     */
    public void append_left(TreeNode<T> input_node){
      this._left = input_node;
    } // END append_left

    /**
     * get_value PUBLIC METHOD
     *
     * @return T VALUE THAT STORED IN THE TREE NODE
     *
     * SIMPLE GETTER METHOD THAT WILL RETURN THE STORED VALUE UPON REQUESTS
     */
    public T get_value(){
      return _value;
    } // END get_value

    /**
     * change_value PUBLIC METHOD
     *
     * @param new_value VALUE THAT PROVIDED BY USER WHICH WILL BE STORED INTO
     *                  THE TREE NODE
     *
     * SIMPLE SETTER METHOD THAT MANIPULATES THE STORED VALUE OF A TREE NODE
     */
    public void change_value(T new_value){
      this._value = new_value;
    } // END change_value

    /**
     * has_child PUBLIC METHOD
     *
     * @return A BOOLEAN VALUE - TRUE  : AT LEAST A CHILD NODE
     *                           FALSE : NO CHILDREN NODE
     *
     * THIS METHOD WILL IDENTIFY THE EXISTENCE OF CHILD NODE(S)
     */
    public boolean has_child(){
      return this._left != null || this._right != null;
    }

    /**
     * get_left, get_right, get_height PUBLIC METHODS
     *
     * SIMPLE GETTER METHOD THAT PROVIDES ACCESS TO THE STORED VALUE IN NODE
     */
    public TreeNode<T> get_left(){
      return this._left;
    }
    public TreeNode<T> get_right(){
      return this._right;
    }
    public int get_height(){
      return _height;
    }

    /**
     * set_height PUBLIC METHOD
     * @param input_value INPUT VALUE THAT PROVIDED BY USER
     *
     * TAKES A VALUE FROM USER AND STORE IT INTO THE TREE NODE
     */
    public void set_height(int input_value){
      _height = input_value;
    }
  } // END TreeNode CLASS

  // PRIVATE FIELDS FOR BST CLASS
  protected TreeNode<T> _head = null; // ROOT OF THE BST
  protected int _num_of_nodes = -1;

  /**
   * BST CONSTRUCTOR
   *
   * INITIALIZE BST OBJECT(S)
   */
  public BST(){
    _head = null;
    _num_of_nodes = 0;
  }

  /**
   * OVERLOADED BST CONSTRUCTOR
   *
   * @param input_value USER PROVIDED INPUT VALUE
   *
   * OVERLOADED CONSTRUCTOR WILL TAKE AN INPUT VALUE AND INITIALIZE A TREE
   * NODE OBJECT WITH THE INPUT VALUE
   */
  public BST(T input_value){
    _head = new TreeNode<>(input_value);
    _num_of_nodes = 1;
  }

  /**
   * inorder_print PUBLIC METHOD
   *
   * PRINTING BST BY INORDER ORDER
   */
  public void inorder_print(){
    _inorder(_head);
    _num_of_nodes++;
  }

  /**
   * _inorder PRIVATE METHOD
   * @param root THE ROOT OF SUBT-TREE(S)
   *
   * PRINTING ENTIRE TREE BY THE INORDER ORDER
   */
  private void _inorder(TreeNode<T> root){
    if(root != null){
      _inorder(root.get_left());
      System.out.print("[" + root.get_value() + "], ");
      _inorder(root.get_right());
    }
    System.out.println();
  }

  /**
   * print PUBLIC METHOD
   *
   * ITERATE THE ENTIRE TREE IN BREADTH FIRST ORDER AND CALLING A HELPER METHOD
   * TO PRINT OUT THE INDENTATION
   */
  public void print(){
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
    System.out.println();
  }

  /**
   * _print_tree_lines PRIVATE METHOD
   * @param node_num INDICATES WHICH NODE NUMBER IS THE CURRENT NODE ( IN ORDER
   *                 TO KNOW ITS EXACT POSITION )
   * @param node     THE REFERENCE TO CURRENT NODE
   *
   * BASED ON THE POSITION OF THE CURRENT NODE, THE METHOD WILL PRINT OUT THE
   * PROPER INDENTATION ( SPACING )
   */
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
    boolean _new_line_flag = false;
    int __indent = 0;
    if(node_num == 1 || node_num ==3){
      _new_line_flag = true;
      if(node_num == 1){
        __indent = 15+2;
      }
      else{
        __indent = 15+1;
      }
    }
    else if(node_num == 2 || node_num>=5 && node_num<=7){
      if(node_num == 7){
        _new_line_flag = true;
      }
      if(node_num == 2){
        __indent = 7+2;
      }
      else{
        __indent = 7+1;
      }
    }
    else if(node_num == 4 || node_num>=9 && node_num<=15){
      if(node_num == 15){
        _new_line_flag = true;
      }
      if(node_num ==4){
        __indent = 3+2;
      }
      else{
        __indent = 3;
      }
    }
    else if(node_num == 8 || node_num>=17 && node_num<=31) {
      if(node_num == 31){
        _new_line_flag = true;
      }
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
      // testing /////////////////////////////////////////////////////////////
      System.out.print(" = ");
      System.out.print(node.get_height());
      if(_new_line_flag){
        System.out.println();
      }
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

  /**
   * insert_node PUBLIC METHOD
   *
   * @param input_value THE VALUE THAT WILL STORES INTO NEW NODE
   *
   * THE insert_node METHOD WILL CALL A PRIVATE HELPER METHOD TO DO THE
   * ACTUAL INSERTION WORK
   */
  public void insert_node(T input_value){
    if(input_value == null){
      System.out.println("Input value can not be null.");
      return;
    }
    _head = _insert(_head, input_value);
  }

  /**
   * _insert PRIVATE METHOD
   *
   * @param root        INDICATES THE CURRENT ROOT NODE OF THE SUBTREE
   * @param input_value THE VALUE THAT NEEDED TO BE ADDED
   * @return            A REFERENCE TO THE CURRENT ROOT NODE
   *
   *
   * THIS METHOD WILL RECURSIVELY FIND A CORRECT POSITION IN BST TO CREATE
   * AND INSERT THE NEW NODE THAT CONTAINS THE USER INPUT VALUE
   */
  protected TreeNode<T> _insert(TreeNode<T> root, T input_value){
    if(root == null){
      // ALLOCATE THE NEW NODE WHEN THE INSERT LOCATION IS FOUND
      root = new TreeNode<>(input_value);
    }
    else {
      if (root._value.compareTo(input_value) >= 0) {
        root.append_left(_insert(root.get_left(), input_value));
      }
      else {
        root.append_right(_insert(root.get_right(), input_value));
      }
      // UPDATING HEIGHT OF THE NODE
      root.set_height(Math.max(
          _get_height(root.get_left()), _get_height(root.get_right())
      ) + 1);
    }
    return root;
  }

  /**
   * search_node PUBLIC METHOD
   *
   * @param input_value THE SEARCHING VALUE
   * @return            BOOLEAN VALUE INDICATES NODE FOUND OR NOT FOUND
   *
   * THE search_node METHOD WILL ASK HELPS FROM A PRIVATE HELPER METHOD TO FIND
   * THE SPECIFIC NODE
   */
  public boolean search_node(T input_value) {
    if(input_value == null){
      System.out.println("Input value can not be null.");
      return false;
    }
    TreeNode<T> __node_ref = _find_node(this._head, input_value);

    return __node_ref != null;
  }

  /**
   * delete_node PUBLIC METHOD
   *
   * @param input_value INDICATES THE VALUE USER REQUESTS TO DELETE
   *
   * THE METHOD WILL CALL UP A PRIVATE HELPER METHOD (RECURSIVE METHOD) TO FIND
   * THE RIGHT NODE TO BE DELETED
   */
  public void delete_node(T input_value){
    if(input_value == null){
      System.out.println("Input value can not be null.");
      return;
    }
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

  /**
   * _delete_node PROTECTED METHOD
   *
   * @param root        INDICATES THE CURRENT ROOT NODE OF SUBTREE
   * @param input_value INDICATES THE VALUE NEEDED TO BE DELETED
   * @return            A REFERENCE TO THE CURRENT ROOT NODE
   *
   * THE METHOD RECURSIVELY FINDS A CORRECT NODE TO DELETE AND IT WOULD
   * SUBSTITUTE THE ROOT NODE (IF IT'S THE ONE TO BE DELETED) WITH THE GREATEST
   * NODE IN LEFT SUBTREE.
   */
  protected TreeNode<T> _delete_node(TreeNode<T> root, T input_value){
    if(root != null) {
      int __comparison_result = root.get_value().compareTo(input_value);
      // TESTING
      System.out.println(__comparison_result);

      if (__comparison_result > 0) {  // DELETE VALUE IS LESS
        root.append_left(_delete_node(root.get_left(), input_value));
      }
      else if (__comparison_result < 0) { // DELETE VALUE IS GREATER
        root.append_right(_delete_node(root.get_right(), input_value));
      }
      else { // FOUND
        if (root.get_left() == null) {
          return root.get_right();
        }
        else if (root.get_right() == null) {
          return root.get_left();
        }
        else { // HAS TWO CHILDREN
          // COPY VALUE
          root.change_value(_get_max_node(root.get_left()).get_value());
          root.append_left(_delete_node(root.get_left(), root.get_value()));
        }
      }
    }
    return root;
  }

  /**
   * _get_max_node PROTECTED METHOD
   *
   * @param node INDICATES THE ROOT NODE OF THE CURRENT SUBTREE
   * @return     THE REFERENCE TO THE GREATEST CHILD NODE IN THIS SUBTREE
   *
   * SIMPLY USING A LOOP TO FIND THE RIGHT-MOST NODE IN LEFT SUBTREE AND
   * RETURN A REFERENCE TO IT
   */
  protected TreeNode<T> _get_max_node(TreeNode<T> node){
    while(node.get_right() != null){
      //node = node.get_left(); <------------- CAUSING PROBLEM
      node = node.get_right();
    } // END WHILE
    return node;
  }

  /**
   * _find_node PRIVATE METHOD
   *
   * @param root        THE ROOT NODE OF THE CURRENT SUBTREE
   * @param input_value INDICATES THE SEARCHING VALUE
   * @return            A REFERENCE TO THE TARGET NODE; RETURN NULL IF NOT FOUND
   */
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

  /**
   *
   * @param node
   * @return
   */
  protected int _get_height(TreeNode<T> node){
    return (node == null) ? 0 : node.get_height();
  }

  public boolean is_height_five(){
    if(_head == null){
      return false;
    }
    return _head.get_height() == 5;
  }

  public boolean is_empty(){
    return _head == null;
  }

  public T get_first_value(){
    return _head.get_value();
  }

  public T pop(){
    TreeNode<T> __deleted_root = _head;
    this.delete_node(__deleted_root.get_value());
    _num_of_nodes--;
    return __deleted_root.get_value();
  }
}