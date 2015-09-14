/**
 * Created by Lambda on 9/13/2015.
 */
import java.lang.Math;

public class AVL_Tree<T extends Comparable<T>> extends BST<T> {
  // PRIVATE FIELDS

  // CONSTRUCTOR
  public AVL_Tree(){
    _head = null;
    _num_of_nodes = 0;
  }

  public TreeNode<T> right_rotate(TreeNode<T> root){
    TreeNode<T> __left_child = root.get_left();
    TreeNode<T> __left_child_right_sub_tree = __left_child.get_right();

    // ROTATION
    __left_child.append_right(root);
    root.append_left(__left_child_right_sub_tree);

    // UPDATING HEIGHT OF TREE NODES
    root.set_height(Math.max(
        _get_height(root.get_left()),
        _get_height(root.get_right())
    ) + 1);
    __left_child.set_height(Math.max(
        _get_height(__left_child.get_left()),
        _get_height(__left_child.get_right())
    ) + 1);

    return __left_child;  // RETURNING NEW ROOT
  }

  public TreeNode<T> left_rotate(TreeNode<T> root) {
    TreeNode<T> __right_child = root.get_right();
    TreeNode<T> __right_child_left_sub_tree = __right_child.get_left();

    // ROTATION
    __right_child.append_left(root);
    root.append_right(__right_child_left_sub_tree);

    // UPDATING HEIGHT OF TREE NODES
    root.set_height(Math.max(
        _get_height(root.get_left()),
        _get_height(root.get_right())
    ) + 1);
    __right_child.set_height(Math.max(
        _get_height(__right_child.get_left()),
        _get_height(__right_child.get_right())
    ) + 1);

    return __right_child;  // RETURNING NEW ROOT
  }

  int get_height_difference(TreeNode<T> root){
    if(root == null){
      return 0;
    }
    return _get_height(root.get_left()) - _get_height(root.get_right());
  }
  private int _get_height(TreeNode<T> node){
    return (node == null) ? 0 : node.get_height();
  }

  private TreeNode<T> _balance_tree(TreeNode<T> root, T input_value){
    // UPDATING HEIGHT OF THE NODE
    root.set_height(Math.max(
        _get_height(root.get_left()), _get_height(root.get_right())
    ) + 1);

    int __height_difference = get_height_difference(root);

    // DETEREMINE IF ROTATION(S) IS/ARE NEEDED
    if(__height_difference > 1){
      // LEFT LEFT
      if(input_value.compareTo(root.get_left().get_value()) < 0){
        // INPUT VALUE IS LESS THAN THE VALUE STORES IN LEFT CHILD
        return right_rotate(root);
      }
      else{ // LEFT RIGHT : INPUT VALUE > LEFT CHILD VALUE
        root.append_left(left_rotate(root.get_left()));
        return right_rotate(root);
      }
    }
    if(__height_difference < -1){
      // RIGHT RIGHT
      if(input_value.compareTo(root.get_right().get_value()) > 0){
        return left_rotate(root);
      }
      else{ // RIGHT LEFT
        root.append_right(right_rotate(root.get_right()));
        return left_rotate(root);
      }
    }
    return root;
  }

  @Override
  protected TreeNode<T> _insert(TreeNode<T> root, T input_value){
    if(root == null){
      root = new TreeNode<>(input_value);
    }
    else{
      if (root.get_value().compareTo(input_value) >= 0) {
        root.append_left(_insert(root.get_left(), input_value));
      } else {
        root.append_right(_insert(root.get_right(), input_value));
      }

      root = _balance_tree(root, input_value);
    }
    return root;
  } // END _insert PRIVATE METHOD

  @Override
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

      // IF THERE IS ONLY ONE NODE TO BE DELETED
      if(root == null){
        return root;
      }
      else{
        root = _balance_tree(root, input_value);
      }
    }
    return root;
  } // END _delete_node METHOD
} // END AVL_Tree CLASS
