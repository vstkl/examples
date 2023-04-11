#include<iostream>
#include<set>
#include<vector>
#include<queue>

class CTown {
private:
	int m_good;
	int price;
public:
	int import_size;
	std::vector<bool> m_import;
	std::vector<CTown*> m_neighbours;
	CTown(int P, int good);
	CTown() {}
	int getImport() {
		return m_good;
	};
	int getPrice() {
		return price;
	};
	int getImportSize() {
		return import_size;
	};
	void incrementImport() {
		++import_size;
	}
	void addPrice(int x) {
		price += x;
	}
};
CTown::CTown(int P, int good) : m_good(good),price(0), import_size(1) {
	m_import.resize(P, false);
	m_import[good] = true;
}
class CEment {
private:
	CTown * city;
	int price;
	int type;
public:
	CEment(CTown * city, int city_price, int import_type) {
		this->city = city;
		price = city_price;
		type = import_type;
	}
	CTown * getCity() {
		return city;
	}
	int getPrice() {
		return price;
	}
	int getType() {
		return type;
	}
};
class CNetwork {
private:
	long long int price = 0;
	int N, M, P, Q;
	std::queue<CEment> q;
	std::vector<CTown*> m_cities;
public:
	CNetwork() {
		int temp[2];
		std::cin >> N
			>> M;
		std::cin >> P
			>> Q;
		m_cities.resize(N);
		for (int i = 0; i < N; i++) {
			std::cin >> temp[0];
			m_cities[i] = (new CTown(P, temp[0]));
			q.push(*new CEment(m_cities[i], 0, temp[0]));
		}
		for (int i = 0; i < M; i++) {
			std::cin >> temp[0]
				>> temp[1];
			m_cities[temp[1]]->m_neighbours.push_back(m_cities[temp[0]]);
			m_cities[temp[0]]->m_neighbours.push_back(m_cities[temp[1]]);
		}
	}
	void VFS() {
		while (!q.empty()) 
		{
			auto curr = q.front();
			for (auto e : curr.getCity()->m_neighbours) 
			{
				if (e->getImportSize() < Q && e->m_import[curr.getType()] == false) 
				{
					q.push(CEment(e, curr.getPrice() + 1, curr.getType()));
					e->m_import[curr.getType()] = true;
					++e->import_size;
					e->addPrice(curr.getPrice()+1);
					price += curr.getPrice()+1;
				}
			}
			q.pop();
		}
	}
	void Print() {
		std::cout << price << std::endl;
		for (auto city : m_cities) {
			std::cout << city->getPrice();
			for (int i = 0; i < P; i++) {
				if (city->m_import[i])
					std::cout << " " << i;
			}
			std::cout << std::endl;
		}
	}
};
int main() {
	auto net = new CNetwork();
	net->VFS();
	net->Print();
	return 0;
}