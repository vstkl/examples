# Open files to generate code from
files = [
    open('./file1.txt'),
    open('./file2.txt'),
    open('./file3.txt')
]

res = open('result.txt',"w+r")

# Limit logging for debug purposes 
x = 0
max_loops = 100

# Move file pointers to their start
for file in files:
    file.seek(0,0)

def getchar_loop(f):
    line = f.readline()
    if line == '':
        f.seek(0,0)
        line = f.readline()
    return line

print("Starting over")

test_array = []

while x < max_loops:
    ch = getchar_loop(files[x % 3])
    cch = ch.strip('\n')
    res.write(cch)
    test_array.append(cch)
    x = x + 1

expected_payload=['1', 'A', '\\-', '2', 'B', '\\+', '3', 'C', '\\-', '1', 'D', '\\+', '2', 'A', '\\-', '3', 'B', '\\+', '1', 'C', '\\-', '2', 'D', '\\+', '3', 'A', '\\-', '1', 'B', '\\+', '2', 'C', '\\-', '3', 'D', '\\+', '1', 'A', '\\-', '2', 'B', '\\+', '3', 'C', '\\-', '1', 'D', '\\+', '2', 'A', '\\-', '3', 'B', '\\+', '1', 'C', '\\-', '2', 'D', '\\+', '3', 'A', '\\-', '1', 'B', '\\+', '2', 'C', '\\-', '3', 'D', '\\+', '1', 'A', '\\-', '2', 'B', '\\+', '3', 'C', '\\-', '1', 'D', '\\+', '2', 'A', '\\-', '3', 'B', '\\+', '1', 'C', '\\-', '2', 'D', '\\+', '3', 'A', '\\-', '1']

print("Chars fetched while running: ",test_array)
print("Expected chars: ",expected_payload)
assert test_array == expected_payload
