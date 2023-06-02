def read_int_arr():
   return [int(n) for n in input().split()]

(N, M) = read_int_arr()
(P, Q) = read_int_arr()
# 1 <= Q <= P <= min(N, 100)

assert 1 <= N, 'invalid cities count'
assert 0 <= M, 'invalid path count'
assert 1 <= Q and Q <= P and P <= min([N, 100]), 'invalid input'

city_food = read_int_arr()
assert min(city_food) >= 0 and max(city_food) < P and N == len(city_food), 'invalid food array'

edges = []
for _ in range(0, M):
   edges.append(read_int_arr())

assert M == len(edges), 'invalid edges count'
assert len(list(filter(lambda x: len(edges) != 2, edges))) != 0, 'invalid edges format'

# END OF INPUT #

incidence_matrix = [
    [0] * N for _ in range(0, N)
]

for edge in edges:
    incidence_matrix[edge[0]][edge[1]] = 1
    incidence_matrix[edge[1]][edge[0]] = 1

food_in_city = [0] * N # list for every city
price_in_city = [0 for _ in range(0, N)]
for i in range(0, N):
    food_in_city[i] = [0] * P
    food_in_city[i][city_food[i]] = 1

UNDEFINED = -1

nearest_city_for_food = [0] * N
nearest_city_for_food_price = [0] * N
for i in range(0, N):
    nearest_city_for_food[i] = [UNDEFINED] * P
    nearest_city_for_food_price[i] = [UNDEFINED] * P

for n in range(0, N):
    visited = [0] * N
    distance_for_city = [0] * N
    queue = []
    queue.append(n)
    visited[n] = 1

    food_in_city[n] = [0] * P
    food_in_city[n][city_food[n]] = 1 # mark food city is producing as found
    food_found_count = 1 # we already have one

    while len(queue):
        v = queue[0]
        del queue[0]
        visited[v] = 1
        # add neighbours to the queue
        for i in range(0, N):
            if incidence_matrix[v][i] and not visited[i]:
                queue.append(i)
                if not distance_for_city[i]:
                    distance_for_city[i] = distance_for_city[v] + 1
        # check food
        if not food_in_city[n][city_food[v]]:
            food_in_city[n][city_food[v]] = 1
            food_found_count += 1
            price_in_city[n] += distance_for_city[v]

            nearest_city_for_food[v][city_food[v]] = v
            nearest_city_for_food_price[v][city_food[v]] = distance_for_city[v]

        if food_found_count >= Q:
            break

print(sum(price_in_city))
for i in range(0, N):
    print(str(price_in_city[i]) + ' ' + ' '.join(filter(lambda x: x, map(lambda x: str(x[0]) if x[1] else 0, enumerate(food_in_city[i])))))
