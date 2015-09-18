/**
 * Created by Lambda on 9/17/2015.
 */
/**
 * TreeNode PROTECTED INNER CLASS
 *
 * TreeNode CLASS IS RESPONSIBLE FOR STORING SEVERAL FIELDS:
 *   (1) _height : THE HEIGHT OF THE TreeNode WITHIN THE TREE
 *   (2) _value  : VALUE STORED IN TREE NODE
 *   (3) _left   : LEFT CHILD TREE NODE
 *   (4) _right  : RIGHT CHILD TREE NODE
 */
public class BinaryNode<T extends Comparable<T>>{
  // PRIVATE FIELDS
  private int _height = -1;
  private T _value = null;
  private BinaryNode<T> _left = null;
  private BinaryNode<T> _right = null;

  /**
   * TreeNode CONSTRUCTOR
   *
   * @param input_value A GENERIC INPUT FROM THE USER
   *
   * THE CONSTRUCTOR WILL TAKE AN INPUT FROM USER AND STORE IT INTO A NEWLY
   * CREATED TreeNode BEFORE RETURNING IT TO USER.
   */
  public BinaryNode(T input_value){
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
  public void append_right(BinaryNode<T> input_node){
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
  public void append_left(BinaryNode<T> input_node){
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
  public BinaryNode<T> get_left(){
    return this._left;
  }
  public BinaryNode<T> get_right(){
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