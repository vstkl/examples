#include <stdio.h>
#include <stdlib.h>

typedef struct {
} Queue;
typedef struct {
  int size;
  int * n;
  int * SP;
  void create(){
    size = 100;
    n = (int*)malloc(size * sizeof(int));
    SP = &n[0];
  };
  void push(int data) {
    *SP++ = data; 
  }
  void pop() {
    *SP-- = NULL; 
  }
} Stack;
void create(){
    size = 100;
    n = (int*)malloc(size * sizeof(int));
    SP = &n[0];
  };
int main() {
  Stack s;
  s.create();
  int i = 0;

  while( i > s.size) {
  //  s.push(i++);
  }
  return 0;
}