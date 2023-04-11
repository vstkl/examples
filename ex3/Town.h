#include<vector>
#include<iostream>
class CTown{
  int m_id;
  int m_good;
  std::vector<int> m_neighbours; 
  CTown(int id, int good);
  void AddNeighbour(int neighbourId);
  void AddNeighbourBoth(int neighbourId);
};