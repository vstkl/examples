#include<iostream>

struct TList {
  int n;
  TList * m_next;
  TList * m_prev;
};
int main() {
  TList x[100];
  for(int i = 0; i < 100; i ++) {
    if(i != 99) x[i].m_next = &(x[i+1]); 
    x[i].n = i;
  }
  for(int i = 0; i < 100; i ++) {
    std::cout << x[i].n;
  }
}