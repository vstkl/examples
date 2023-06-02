#include<iostream>

class Vector{
  public:
    Vector();
    Vector(int size);
    ~Vector();
    int add(int n);
    bool del(int index);
  private:
    int size = 100;
    Vector deepCopy();
    void resize();
    int indexed_values;
};
Vector::Vector () {
  int * data = new int [this -> size];
  
}
Vector::~Vector () {
  
}
Vector::Vector (int _size) {
  int * data = new int [_size];
}
int Vector::add(int n) {
  int index;
  if(indexed_values + 1 >= size) 
    
  return index;
}

bool Vector::del(int index) {

}