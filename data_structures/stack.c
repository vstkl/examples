#include<stdio.h>
#include<stdlib.h>

typedef struct Stack {
  int stack_size ;
  int used_elements;
  int * data;
  int * pointer;
}TStack;
void print_stack(TStack * stack) {
  printf("stack:\n");
  for(int i = stack->stack_size; i > -1 ; i--) {
    if(i > stack->used_elements) {
      printf("/:%d\n", i);
      continue;
    }
    printf("%d:%d\n",stack->data[i], i);
  }
  printf("____\n");
}
int push(TStack * stack, int value) {
  if(stack->used_elements++ > stack->stack_size) {
    printf("stack overflow\n");
    return 1;
  }
  *stack->pointer++ = value; 
  return 0;
}
int pop(TStack * stack) {
  if(stack->used_elements-- <= 0 ) {
   return 1;
  }
  stack->pointer-- ; 
  return 0;
}
int main() {
  TStack x;
  x.stack_size = 15;
  x.used_elements = 0;
  x.data = (int*)malloc(x.stack_size * sizeof(int));
  x.pointer = x.data;
  int i = 0;
  
  for(; i <= x.stack_size + 120; i ++) 
    if(push(&x, i) == 1) break;
  print_stack(&x);
  for(int k = 0; k < 10; k ++)
    pop(&x);
  print_stack(&x);
}