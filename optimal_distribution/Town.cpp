#include"Town.h" 
CTown::CTown(int id, int good) {
  m_id = id;
  m_good = good;
}
void CTown::AddNeighbour(int neighbourId) {
  m_neighbours.push_back(neighbourId);
  return;
}
void CTown::AddNeighbourBoth(int neighbourId) {
  
  m_neighbours.push_back(neighbourId);
  return;
}