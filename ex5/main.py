arr = [2,11,7, 17, 15]
arrs = [arr, arr]

target1 = 13
target2 = 22
targets = [target1, target2]
test_data = [{
    "target": target1,
    "arr": arr,
    "result": [0,1]
},
{
    "target": target2,
    "arr": arr,
    "result": [2,4]
}
]

def find_target(_target: int,  _arr: list):
    for index1, val1 in enumerate(_arr):
        for index2, val2 in enumerate(_arr):
            if _target  == val1 + val2:
                return[index1, index2]
    return[None, None]

def find_target2(_target: int, _arr: list):
    complements = {}
    
    for index in range(len(_arr)):
        complement = _target - _arr[index]

        if complement in complements:
            return[complements[complement], index]
        else:
            complements[_arr[index]] = index

result = find_target(_target = target1, _arr  = arr)

for data in test_data:
    assert find_target2(data["target"], data["arr"]) == data["result"], "TEST FAILED"
