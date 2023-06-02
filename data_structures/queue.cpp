#include<iostream>

class Queue {
  private: 
    int * m_tail;
    int * m_head;
    int data;
  public: 
    Queue();
    ~Queue();
    bool push(int data);

};
Queue::Queue() {
  m_tail = m_head;
}
Queue::~Queue() {

}
bool Queue::push(int data) {
  
}
int main () {

}