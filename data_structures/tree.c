#include<stdio.h>
#include<stdlib.h>
typedef struct TNode{
  struct TNode * left;
  struct TNode * right;
  int level;
  int depth;
  int value;
}Node;
typedef struct TTree{
  Node * root;
}Tree;
void print_node(Node * x){
    printf("l:%p r: %p v: %d d: %d\n",x->left, x->right, x->value, x->level);
}
void print_tree(Node * x){
    //print_node(x);
    if(x->left) {
      print_tree(x->left);
      print_node(x);
    }
    if(x->right){
      print_tree(x->right);
      print_node(x);
    }
    else
      print_node(x);
}
void rotate_tree_left(Node * x, Node * y){
  x->right = y->left;
  y->left = x;
}
void rotate_tree_right(Node * x, Node * y){
  y->left = x->right;
  x->right = y;
}
Node * create_node(int n, int d){
 // printf("creating node ");
  Node * node = (Node *)malloc(sizeof(Node));
  node->left = node->right = NULL; 
  node->value = n;
  node->depth = d;
 // printf("l:%p r: %p v: %d d:%d\n",node->left, node->right, node->value, node->depth);
  return node;
};
Node * insert_node(Node * x, int n, int d){
  if(x){
    if(x->value < n){
      x->right = insert_node(x->right, n, d + 1);
      return x;
    }else{
      x->left = insert_node(x->left, n, d + 1);
      return x;
    }
  }
  return create_node(n, d);
};
int main(){
  int nodes=10;
  Node * root = create_node(50,0);
  for(int i=1; i <= nodes; i++){
    insert_node(root, rand() % 100, 0);
  }
  print_tree(root);
  rotate_tree_left(root, root->right);
  printf("rotated\n");
  print_tree(root);
 
}